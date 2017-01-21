package com.bt.ws.order;

public class OrderServiceProxy implements com.bt.ws.order.OrderService {
  private String _endpoint = null;
  private com.bt.ws.order.OrderService orderService = null;
  
  public OrderServiceProxy() {
    _initOrderServiceProxy();
  }
  
  public OrderServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initOrderServiceProxy();
  }
  
  private void _initOrderServiceProxy() {
    try {
      orderService = (new com.bt.ws.order.OrderServiceImplServiceLocator()).getOrderServiceImplPort();
      if (orderService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)orderService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)orderService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (orderService != null)
      ((javax.xml.rpc.Stub)orderService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.bt.ws.order.OrderService getOrderService() {
    if (orderService == null)
      _initOrderServiceProxy();
    return orderService;
  }
  
  public void addOrder(com.bt.ws.order.Order arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (orderService == null)
      _initOrderServiceProxy();
    orderService.addOrder(arg0, arg1);
  }
  
  public com.bt.ws.order.Order getOrder(java.lang.String arg0) throws java.rmi.RemoteException{
    if (orderService == null)
      _initOrderServiceProxy();
    return orderService.getOrder(arg0);
  }
  
  
}