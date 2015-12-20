/**
 * SimpleSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.copaair.webservices;

public interface SimpleSoap extends java.rmi.Remote {

    /**
     * Use this method to create a new connection to Runway.  The
     * method returns an XML document containing a valid Runway Connection
     * ID or error information.
     */
    public com.copaair.webservices.ConnectResponseConnectResult connect(java.lang.String server, java.lang.String host, int timeOutRetries) throws java.rmi.RemoteException;

    /**
     * Use this method to execute a Runway message using an existing
     * connection.  This method expects a complex type (XmlNode) and therefore
     * does not support HTTP GET.  The ExecuteMessageHttpGet method is provided
     * for HTTP GET compatibility.  Use ExecuteMessage from .NET applications.
     */
    public com.copaair.webservices.ExecuteMessageResponseExecuteMessageResult executeMessage(java.lang.String transactionName, com.copaair.webservices.ExecuteMessageMessage message, java.lang.String connectionID, int timeOutRetries) throws java.rmi.RemoteException;

    /**
     * Same functionality as ExecuteMessage but accepts the Runway
     * Message in a simple string type.  Provided for HTTP GET compatibility.
     * Use ExecuteMessage from .NET applications.
     */
    public java.lang.String executeMessageHttpGet(java.lang.String transactionName, java.lang.String message, java.lang.String connectionID, int timeOutRetries) throws java.rmi.RemoteException;

    /**
     * Use this method to disconnect an existing Runway connection.
     * The method returns an XML document containing the result of the operation
     * or error information.
     */
    public com.copaair.webservices.DisconnectResponseDisconnectResult disconnect(java.lang.String server, java.lang.String host, java.lang.String connectionID, int timeOutRetries) throws java.rmi.RemoteException;
}
