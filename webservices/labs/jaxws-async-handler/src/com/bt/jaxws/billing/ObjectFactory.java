
package com.bt.jaxws.billing;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bt.jaxws.billing package. 
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

    private final static QName _Account_QNAME = new QName("http://billing.jaxws.bt.com/", "account");
    private final static QName _InvalidCustomerException_QNAME = new QName("http://billing.jaxws.bt.com/", "InvalidCustomerException");
    private final static QName _CustomerAddress_QNAME = new QName("", "address");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bt.jaxws.billing
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link InvalidCustomerException }
     * 
     */
    public InvalidCustomerException createInvalidCustomerException() {
        return new InvalidCustomerException();
    }

    /**
     * Create an instance of {@link Invoice }
     * 
     */
    public Invoice createInvoice() {
        return new Invoice();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://billing.jaxws.bt.com/", name = "account")
    public JAXBElement<Customer> createAccount(Customer value) {
        return new JAXBElement<Customer>(_Account_QNAME, Customer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidCustomerException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://billing.jaxws.bt.com/", name = "InvalidCustomerException")
    public JAXBElement<InvalidCustomerException> createInvalidCustomerException(InvalidCustomerException value) {
        return new JAXBElement<InvalidCustomerException>(_InvalidCustomerException_QNAME, InvalidCustomerException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "address", scope = Customer.class)
    public JAXBElement<String> createCustomerAddress(String value) {
        return new JAXBElement<String>(_CustomerAddress_QNAME, String.class, Customer.class, value);
    }

}
