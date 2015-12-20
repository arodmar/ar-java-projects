/**
 * Simple.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.copaair.webservices;

public interface Simple extends javax.xml.rpc.Service {

/**
 * .NET Wrapper for the Runway Client COM Component.  Property of
 * Copa Airlines.  Authorization from Copa Airlines is required to use
 * this Web Service.
 */
    public java.lang.String getSimpleSoapAddress();

    public com.copaair.webservices.SimpleSoap getSimpleSoap() throws javax.xml.rpc.ServiceException;

    public com.copaair.webservices.SimpleSoap getSimpleSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
