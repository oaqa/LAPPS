/**
 * Tokenizer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package PROCESSOR.NATURAL_LANGUAGE_PROCESSING.servicetype;

public interface Tokenizer extends java.rmi.Remote {
    public api.lappsgrid.org.Data execute(api.lappsgrid.org.Data input) throws java.rmi.RemoteException;
    public api.lappsgrid.org.Data configure(api.lappsgrid.org.Data config) throws java.rmi.RemoteException;
    public long[] requires() throws java.rmi.RemoteException;
    public long[] produces() throws java.rmi.RemoteException;
}
