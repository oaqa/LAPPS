package edu.cmu.lti.oaqa.cseweb.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

public class RegisteredServiceDataModel extends ListDataModel<LappsServiceDescriptor> implements
        SelectableDataModel<LappsServiceDescriptor> {

  public RegisteredServiceDataModel() {
    super();
  }

  public RegisteredServiceDataModel(List<LappsServiceDescriptor> list) {
    super(list);
  }

  @Override
  public Object getRowKey(LappsServiceDescriptor desc) {
    return desc.getResourceName();
  }

  @Override
  public LappsServiceDescriptor getRowData(String rowKey) {

    @SuppressWarnings("unchecked")
    List<LappsServiceDescriptor> descs = (List<LappsServiceDescriptor>) getWrappedData();

    for (LappsServiceDescriptor desc : descs) {
      if (desc.getResourceName().equals(rowKey))
        return desc;
    }

    return null;
  }

}
