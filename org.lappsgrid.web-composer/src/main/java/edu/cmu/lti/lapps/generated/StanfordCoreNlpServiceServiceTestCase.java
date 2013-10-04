/**
 * StanfordCoreNlpServiceServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.cmu.lti.lapps.generated;

public class StanfordCoreNlpServiceServiceTestCase extends junit.framework.TestCase {
    public StanfordCoreNlpServiceServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testStanfordCoreNlpServiceWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new edu.cmu.lti.lapps.generated.StanfordCoreNlpServiceServiceLocator().getStanfordCoreNlpServiceAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new edu.cmu.lti.lapps.generated.StanfordCoreNlpServiceServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1StanfordCoreNlpServiceMain() throws Exception {
        edu.cmu.lti.lapps.generated.StanfordCoreNlpServiceSoapBindingStub binding;
        try {
            binding = (edu.cmu.lti.lapps.generated.StanfordCoreNlpServiceSoapBindingStub)
                          new edu.cmu.lti.lapps.generated.StanfordCoreNlpServiceServiceLocator().getStanfordCoreNlpService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        binding.main(new java.lang.String[0]);
        // TBD - validate results
    }

    public void test2StanfordCoreNlpServiceProcess() throws Exception {
        edu.cmu.lti.lapps.generated.StanfordCoreNlpServiceSoapBindingStub binding;
        try {
            binding = (edu.cmu.lti.lapps.generated.StanfordCoreNlpServiceSoapBindingStub)
                          new edu.cmu.lti.lapps.generated.StanfordCoreNlpServiceServiceLocator().getStanfordCoreNlpService();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        edu.cmu.lti.lapps.generated.Annotation value = null;
        value = binding.process(new java.lang.String());
        // TBD - validate results
    }

}
