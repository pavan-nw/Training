
package com.bt.ws.orderimport;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bt.ws.orderimport package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddOrder_QNAME = new QName("http://order.ws.bt.com/", "addOrder");
    private final static QName _GetOrder_QNAME = new QName("http://order.ws.bt.com/", "getOrder");
    private final static QName _GetOrderResponse_QNAME = new QName("http://order.ws.bt.com/", "getOrderResponse");
    private final static QName _AddOrderResponse_QNAME = new QName("http://order.ws.bt.com/", "addOrderResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bt.ws.orderimport
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddOrder }
     * 
     */
    public AddOrder createAddOrder() {
        return new AddOrder();
    }

    /**
     * Create an instance of {@link GetOrderResponse }
     * 
     */
    public GetOrderResponse createGetOrderResponse() {
        return new GetOrderResponse();
    }

    /**
     * Create an instance of {@link AddOrderResponse }
     * 
     */
    public AddOrderResponse createAddOrderResponse() {
        return new AddOrderResponse();
    }

    /**
     * Create an instance of {@link GetOrder }
     * 
     */
    public GetOrder createGetOrder() {
        return new GetOrder();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://order.ws.bt.com/", name = "addOrder")
    public JAXBElement<AddOrder> createAddOrder(AddOrder value) {
        return new JAXBElement<AddOrder>(_AddOrder_QNAME, AddOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://order.ws.bt.com/", name = "getOrder")
    public JAXBElement<GetOrder> createGetOrder(GetOrder value) {
        return new JAXBElement<GetOrder>(_GetOrder_QNAME, GetOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://order.ws.bt.com/", name = "getOrderResponse")
    public JAXBElement<GetOrderResponse> createGetOrderResponse(GetOrderResponse value) {
        return new JAXBElement<GetOrderResponse>(_GetOrderResponse_QNAME, GetOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://order.ws.bt.com/", name = "addOrderResponse")
    public JAXBElement<AddOrderResponse> createAddOrderResponse(AddOrderResponse value) {
        return new JAXBElement<AddOrderResponse>(_AddOrderResponse_QNAME, AddOrderResponse.class, null, value);
    }

}
