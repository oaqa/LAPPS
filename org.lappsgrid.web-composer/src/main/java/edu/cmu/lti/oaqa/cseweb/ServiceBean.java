package edu.cmu.lti.oaqa.cseweb;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.rpc.ServiceException;

import jp.go.nict.langrid.ws_1_2.AccessLimitExceededException;
import jp.go.nict.langrid.ws_1_2.InvalidParameterException;
import jp.go.nict.langrid.ws_1_2.NoAccessPermissionException;
import jp.go.nict.langrid.ws_1_2.NoValidEndpointsException;
import jp.go.nict.langrid.ws_1_2.ProcessFailedException;
import jp.go.nict.langrid.ws_1_2.ServerBusyException;
import jp.go.nict.langrid.ws_1_2.ServiceNotActiveException;
import jp.go.nict.langrid.ws_1_2.ServiceNotFoundException;
import jp.go.nict.langrid.ws_1_2.UnsupportedLanguagePairException;

import org.lappsgrid.api.Data;
import org.lappsgrid.core.DataFactory;
import org.primefaces.event.DragDropEvent;
import org.yaml.snakeyaml.Yaml;

import PROCESSOR.NATURAL_LANGUAGE_PROCESSING.servicetype.AncSTANFORD_TOKENIZERLocator;
import PROCESSOR.NATURAL_LANGUAGE_PROCESSING.servicetype.TokenizerSoapBindingStub;
import edu.cmu.lti.oaqa.cseweb.model.LappsServiceDescriptor;
import edu.upenn.ldc.grid.lang_grid.services.SimpleUGetService.SimpleUGetService;
import edu.upenn.ldc.grid.lang_grid.services.SimpleUGetService.SimpleUGetServiceServiceLocator;

@ManagedBean
@SessionScoped
public class ServiceBean implements Serializable {

  private static final long serialVersionUID = 1L;

  private LappsServiceDescriptor registeringService = new LappsServiceDescriptor();

  public LappsServiceDescriptor getJmsClient() {
    return registeringService;
  }

  public void setJmsClient(LappsServiceDescriptor jmsClient) {
    this.registeringService = jmsClient;
  }

  private String output;

  public String getOutput() {
    return output;
  }

  public void setOutput(String output) {
    this.output = output;
  }

  List<LappsServiceDescriptor> services = loadServicesFromDB();;

  public List<LappsServiceDescriptor> getServices() {
    return services;
  }

  public List<LappsServiceDescriptor> loadServicesFromDB() {
    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection con;
    LinkedList<LappsServiceDescriptor> dbServices = new LinkedList<LappsServiceDescriptor>();
    try {
      con = getConnection();
      String stm = "Select * from resource";
      pst = con.prepareStatement(stm);
      pst.execute();
      rs = pst.getResultSet();

      while (rs.next()) {
        new LappsServiceDescriptor();
        Yaml yaml = new Yaml();
        LappsServiceDescriptor clientDesc = (LappsServiceDescriptor) yaml.load(rs.getString(2));
        dbServices.add(clientDesc);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return dbServices;
  }

  public void setServices(List<LappsServiceDescriptor> services) {
    this.services = services;
  }

  private List<LappsServiceDescriptor> droppedServices = new LinkedList<LappsServiceDescriptor>();;

  public List<LappsServiceDescriptor> getDroppedServices() {
    return droppedServices;
  }

  public void setDroppedServices(List<LappsServiceDescriptor> droppedServices) {
    this.droppedServices = droppedServices;
  }

  public void unDropServices() {
    services = loadServicesFromDB();
    droppedServices = new LinkedList<LappsServiceDescriptor>();
    setOutput("");
  }

  public void onServiceDrop(DragDropEvent ddEvent) {
    LappsServiceDescriptor srv = ((LappsServiceDescriptor) ddEvent.getData());
    droppedServices.add(srv);
    // services.remove(srv);
  }

  public Connection getConnection() throws SQLException {

    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup("java:comp/env/jdbc/uimaweb");
    } catch (NamingException e) {
      e.printStackTrace();
    }

    if (ds == null)
      throw new SQLException("Can't get data source");

    // get database connection
    Connection con = (Connection) ds.getConnection();

    if (con == null)
      throw new SQLException("Can't get database connection");

    return con;
  }

  // resource injection
  @Resource(name = "jdbc/uimaweb")
  private transient DataSource ds;

  // TODO investigate why the injection was not working

  public String register() throws SQLException {

    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup("java:comp/env/jdbc/uimaweb");
    } catch (NamingException e) {
      e.printStackTrace();
    }

    if (ds == null)
      throw new SQLException("Can't get data source");

    // get database connection
    Connection con = (Connection) ds.getConnection();

    if (con == null)
      throw new SQLException("Can't get database connection");

    Yaml yaml = new Yaml();
    String serviceYamlStr = yaml.dump(registeringService);
    System.out.println(serviceYamlStr);

    String insertTableSQL = "INSERT INTO resource" + "(resource_name, resource_text) VALUES"
            + "(?,?)" + "ON DUPLICATE KEY UPDATE resource_text = VALUES(resource_text)";
    PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
    preparedStatement.setString(1, registeringService.getResourceName());
    preparedStatement.setString(2, serviceYamlStr);
    // execute insert SQL stetement
    preparedStatement.executeUpdate();

    services = loadServicesFromDB();
    return "Registered" + registeringService.getResourceName();
  }

  public void runPipeline() throws UnsupportedLanguagePairException, ServiceNotFoundException,
          InvalidParameterException, NoValidEndpointsException, ServiceNotActiveException,
          AccessLimitExceededException, ServerBusyException, NoAccessPermissionException,
          ProcessFailedException, RemoteException, ServiceException, MalformedURLException {

    //TODO replace with DataStore API when LDC provides it
    SimpleUGetService service;
    service = new SimpleUGetServiceServiceLocator().getSimpleUGetService();
    String doc = service.getDocument("NYT_ENG_19940701.0001");

    api.lappsgrid.org.Data data = new api.lappsgrid.org.Data();
    Data docData = DataFactory.text(doc);
    data.setDiscriminator(docData.getDiscriminator());
    data.setPayload(docData.getPayload());

    StringBuffer outputBuffer = new StringBuffer();
    for (LappsServiceDescriptor srv : droppedServices) {
      String endpoint = srv.getEndpoint();
      AncSTANFORD_TOKENIZERLocator Locator = new AncSTANFORD_TOKENIZERLocator();
      TokenizerSoapBindingStub stub = new TokenizerSoapBindingStub(new URL(endpoint), Locator);
      stub.setUsername("operator");
      stub.setPassword("operator");
      api.lappsgrid.org.Data output = stub.execute(data);
      outputBuffer.append("<p>==================== Service [").append(srv.getResourceName())
              .append("] returns: ====================</p>");
      outputBuffer.append(output.getPayload().replaceAll("\n", "<br />")
              .replaceAll("<br /></P>", "</P>"));
      data = output;
    }
    setOutput(outputBuffer.toString());

  }

}
