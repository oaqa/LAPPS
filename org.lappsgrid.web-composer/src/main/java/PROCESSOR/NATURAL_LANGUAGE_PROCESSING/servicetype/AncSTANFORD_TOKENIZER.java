/**
 * AncSTANFORD_TOKENIZER.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package PROCESSOR.NATURAL_LANGUAGE_PROCESSING.servicetype;

public interface AncSTANFORD_TOKENIZER extends javax.xml.rpc.Service {
    public java.lang.String getTokenizerAddress();

    public PROCESSOR.NATURAL_LANGUAGE_PROCESSING.servicetype.Tokenizer getTokenizer() throws javax.xml.rpc.ServiceException;

    public PROCESSOR.NATURAL_LANGUAGE_PROCESSING.servicetype.Tokenizer getTokenizer(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
