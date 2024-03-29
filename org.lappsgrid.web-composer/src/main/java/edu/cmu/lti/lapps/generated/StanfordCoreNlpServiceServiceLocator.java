/**
 * StanfordCoreNlpServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.cmu.lti.lapps.generated;

public class StanfordCoreNlpServiceServiceLocator extends org.apache.axis.client.Service implements edu.cmu.lti.lapps.generated.StanfordCoreNlpServiceService {

    public StanfordCoreNlpServiceServiceLocator() {
    }


    public StanfordCoreNlpServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StanfordCoreNlpServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StanfordCoreNlpService
    private java.lang.String StanfordCoreNlpService_address = "http://localhost:8083/langrid-service-1.2/services/StanfordCoreNlpService";

    public java.lang.String getStanfordCoreNlpServiceAddress() {
        return StanfordCoreNlpService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StanfordCoreNlpServiceWSDDServiceName = "StanfordCoreNlpService";

    public java.lang.String getStanfordCoreNlpServiceWSDDServiceName() {
        return StanfordCoreNlpServiceWSDDServiceName;
    }

    public void setStanfordCoreNlpServiceWSDDServiceName(java.lang.String name) {
        StanfordCoreNlpServiceWSDDServiceName = name;
    }

    public edu.cmu.lti.lapps.generated.StanfordCoreNlpService_PortType getStanfordCoreNlpService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StanfordCoreNlpService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStanfordCoreNlpService(endpoint);
    }

    public edu.cmu.lti.lapps.generated.StanfordCoreNlpService_PortType getStanfordCoreNlpService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            edu.cmu.lti.lapps.generated.StanfordCoreNlpServiceSoapBindingStub _stub = new edu.cmu.lti.lapps.generated.StanfordCoreNlpServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getStanfordCoreNlpServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStanfordCoreNlpServiceEndpointAddress(java.lang.String address) {
        StanfordCoreNlpService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (edu.cmu.lti.lapps.generated.StanfordCoreNlpService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                edu.cmu.lti.lapps.generated.StanfordCoreNlpServiceSoapBindingStub _stub = new edu.cmu.lti.lapps.generated.StanfordCoreNlpServiceSoapBindingStub(new java.net.URL(StanfordCoreNlpService_address), this);
                _stub.setPortName(getStanfordCoreNlpServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("StanfordCoreNlpService".equals(inputPortName)) {
            return getStanfordCoreNlpService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:lapps.lti.cmu.edu", "StanfordCoreNlpServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:lapps.lti.cmu.edu", "StanfordCoreNlpService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StanfordCoreNlpService".equals(portName)) {
            setStanfordCoreNlpServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
