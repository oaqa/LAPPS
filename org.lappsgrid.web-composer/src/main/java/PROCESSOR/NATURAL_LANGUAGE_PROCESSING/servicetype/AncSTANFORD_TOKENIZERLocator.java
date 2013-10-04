/**
 * AncSTANFORD_TOKENIZERLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package PROCESSOR.NATURAL_LANGUAGE_PROCESSING.servicetype;

public class AncSTANFORD_TOKENIZERLocator extends org.apache.axis.client.Service implements PROCESSOR.NATURAL_LANGUAGE_PROCESSING.servicetype.AncSTANFORD_TOKENIZER {

    public AncSTANFORD_TOKENIZERLocator() {
    }


    public AncSTANFORD_TOKENIZERLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AncSTANFORD_TOKENIZERLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Tokenizer
    private java.lang.String Tokenizer_address = "http://grid.anc.org:8080/service_manager/invoker/anc:STANFORD_TOKENIZER";

    public java.lang.String getTokenizerAddress() {
        return Tokenizer_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TokenizerWSDDServiceName = "Tokenizer";

    public java.lang.String getTokenizerWSDDServiceName() {
        return TokenizerWSDDServiceName;
    }

    public void setTokenizerWSDDServiceName(java.lang.String name) {
        TokenizerWSDDServiceName = name;
    }

    public PROCESSOR.NATURAL_LANGUAGE_PROCESSING.servicetype.Tokenizer getTokenizer() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Tokenizer_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTokenizer(endpoint);
    }

    public PROCESSOR.NATURAL_LANGUAGE_PROCESSING.servicetype.Tokenizer getTokenizer(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            PROCESSOR.NATURAL_LANGUAGE_PROCESSING.servicetype.TokenizerSoapBindingStub _stub = new PROCESSOR.NATURAL_LANGUAGE_PROCESSING.servicetype.TokenizerSoapBindingStub(portAddress, this);
            _stub.setPortName(getTokenizerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTokenizerEndpointAddress(java.lang.String address) {
        Tokenizer_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (PROCESSOR.NATURAL_LANGUAGE_PROCESSING.servicetype.Tokenizer.class.isAssignableFrom(serviceEndpointInterface)) {
                PROCESSOR.NATURAL_LANGUAGE_PROCESSING.servicetype.TokenizerSoapBindingStub _stub = new PROCESSOR.NATURAL_LANGUAGE_PROCESSING.servicetype.TokenizerSoapBindingStub(new java.net.URL(Tokenizer_address), this);
                _stub.setPortName(getTokenizerWSDDServiceName());
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
        if ("Tokenizer".equals(inputPortName)) {
            return getTokenizer();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("servicegrid:servicetype:NATURAL_LANGUAGE_PROCESSING:PROCESSOR", "anc:STANFORD_TOKENIZER");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("servicegrid:servicetype:NATURAL_LANGUAGE_PROCESSING:PROCESSOR", "Tokenizer"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Tokenizer".equals(portName)) {
            setTokenizerEndpointAddress(address);
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
