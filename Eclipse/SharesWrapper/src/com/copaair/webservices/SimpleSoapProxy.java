package com.copaair.webservices;

public class SimpleSoapProxy implements com.copaair.webservices.SimpleSoap {
  private String _endpoint = null;
  private com.copaair.webservices.SimpleSoap simpleSoap = null;
  
  public SimpleSoapProxy() {
    _initSimpleSoapProxy();
  }
  
  public SimpleSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initSimpleSoapProxy();
  }
  
  private void _initSimpleSoapProxy() {
    try {
      simpleSoap = (new com.copaair.webservices.SimpleLocator()).getSimpleSoap();
      if (simpleSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)simpleSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)simpleSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (simpleSoap != null)
      ((javax.xml.rpc.Stub)simpleSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.copaair.webservices.SimpleSoap getSimpleSoap() {
    if (simpleSoap == null)
      _initSimpleSoapProxy();
    return simpleSoap;
  }
  
  public com.copaair.webservices.ConnectResponseConnectResult connect(java.lang.String server, java.lang.String host, int timeOutRetries) throws java.rmi.RemoteException{
    if (simpleSoap == null)
      _initSimpleSoapProxy();
    return simpleSoap.connect(server, host, timeOutRetries);
  }
  
  public com.copaair.webservices.ExecuteMessageResponseExecuteMessageResult executeMessage(java.lang.String transactionName, com.copaair.webservices.ExecuteMessageMessage message, java.lang.String connectionID, int timeOutRetries) throws java.rmi.RemoteException{
    if (simpleSoap == null)
      _initSimpleSoapProxy();
    return simpleSoap.executeMessage(transactionName, message, connectionID, timeOutRetries);
  }
  
  public java.lang.String executeMessageHttpGet(java.lang.String transactionName, java.lang.String message, java.lang.String connectionID, int timeOutRetries) throws java.rmi.RemoteException{
    if (simpleSoap == null)
      _initSimpleSoapProxy();
    return simpleSoap.executeMessageHttpGet(transactionName, message, connectionID, timeOutRetries);
  }
  
  public com.copaair.webservices.DisconnectResponseDisconnectResult disconnect(java.lang.String server, java.lang.String host, java.lang.String connectionID, int timeOutRetries) throws java.rmi.RemoteException{
    if (simpleSoap == null)
      _initSimpleSoapProxy();
    return simpleSoap.disconnect(server, host, connectionID, timeOutRetries);
  }
  
  
}