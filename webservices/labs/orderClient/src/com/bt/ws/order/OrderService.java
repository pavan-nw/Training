/**
 * OrderService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bt.ws.order;

public interface OrderService extends java.rmi.Remote {
    public void addOrder(com.bt.ws.order.Order arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public com.bt.ws.order.Order getOrder(java.lang.String arg0) throws java.rmi.RemoteException;
}
