/**
 * SimpleUGetServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.upenn.ldc.grid.lang_grid.services.SimpleUGetService;

public class SimpleUGetServiceServiceLocator extends org.apache.axis.client.Service implements edu.upenn.ldc.grid.lang_grid.services.SimpleUGetService.SimpleUGetServiceService {

    public SimpleUGetServiceServiceLocator() {
    }


    public SimpleUGetServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SimpleUGetServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SimpleUGetService
    private java.lang.String SimpleUGetService_address = "http://grid.ldc.upenn.edu:8081/lang_grid/services/SimpleUGetService";

    public java.lang.String getSimpleUGetServiceAddress() {
        return SimpleUGetService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SimpleUGetServiceWSDDServiceName = "SimpleUGetService";

    public java.lang.String getSimpleUGetServiceWSDDServiceName() {
        return SimpleUGetServiceWSDDServiceName;
    }

    public void setSimpleUGetServiceWSDDServiceName(java.lang.String name) {
        SimpleUGetServiceWSDDServiceName = name;
    }

    public edu.upenn.ldc.grid.lang_grid.services.SimpleUGetService.SimpleUGetService getSimpleUGetService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SimpleUGetService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSimpleUGetService(endpoint);
    }

    public edu.upenn.ldc.grid.lang_grid.services.SimpleUGetService.SimpleUGetService getSimpleUGetService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            edu.upenn.ldc.grid.lang_grid.services.SimpleUGetService.SimpleUGetServiceSoapBindingStub _stub = new edu.upenn.ldc.grid.lang_grid.services.SimpleUGetService.SimpleUGetServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSimpleUGetServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSimpleUGetServiceEndpointAddress(java.lang.String address) {
        SimpleUGetService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (edu.upenn.ldc.grid.lang_grid.services.SimpleUGetService.SimpleUGetService.class.isAssignableFrom(serviceEndpointInterface)) {
                edu.upenn.ldc.grid.lang_grid.services.SimpleUGetService.SimpleUGetServiceSoapBindingStub _stub = new edu.upenn.ldc.grid.lang_grid.services.SimpleUGetService.SimpleUGetServiceSoapBindingStub(new java.net.URL(SimpleUGetService_address), this);
                _stub.setPortName(getSimpleUGetServiceWSDDServiceName());
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
        if ("SimpleUGetService".equals(inputPortName)) {
            return getSimpleUGetService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://grid.ldc.upenn.edu:8081/lang_grid/services/SimpleUGetService", "SimpleUGetServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://grid.ldc.upenn.edu:8081/lang_grid/services/SimpleUGetService", "SimpleUGetService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SimpleUGetService".equals(portName)) {
            setSimpleUGetServiceEndpointAddress(address);
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
