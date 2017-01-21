
package com.bt.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bt.service package. 
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

    private final static QName _GetTariffPlanEconomyResponse_QNAME = new QName("http://service.bt.com/", "getTariffPlanEconomyResponse");
    private final static QName _GetTariffPlanLikeResponse_QNAME = new QName("http://service.bt.com/", "getTariffPlanLikeResponse");
    private final static QName _GetTariffPlan_QNAME = new QName("http://service.bt.com/", "getTariffPlan");
    private final static QName _Tariff_QNAME = new QName("http://service.bt.com/", "tariff");
    private final static QName _GetTariffPlanResponse_QNAME = new QName("http://service.bt.com/", "getTariffPlanResponse");
    private final static QName _GetTariffPlanEconomy_QNAME = new QName("http://service.bt.com/", "getTariffPlanEconomy");
    private final static QName _GetTariffPlanLike_QNAME = new QName("http://service.bt.com/", "getTariffPlanLike");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bt.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTariffPlanResponse }
     * 
     */
    public GetTariffPlanResponse createGetTariffPlanResponse() {
        return new GetTariffPlanResponse();
    }

    /**
     * Create an instance of {@link GetTariffPlanEconomy }
     * 
     */
    public GetTariffPlanEconomy createGetTariffPlanEconomy() {
        return new GetTariffPlanEconomy();
    }

    /**
     * Create an instance of {@link GetTariffPlanLikeResponse }
     * 
     */
    public GetTariffPlanLikeResponse createGetTariffPlanLikeResponse() {
        return new GetTariffPlanLikeResponse();
    }

    /**
     * Create an instance of {@link GetTariffPlanEconomyResponse }
     * 
     */
    public GetTariffPlanEconomyResponse createGetTariffPlanEconomyResponse() {
        return new GetTariffPlanEconomyResponse();
    }

    /**
     * Create an instance of {@link GetTariffPlan }
     * 
     */
    public GetTariffPlan createGetTariffPlan() {
        return new GetTariffPlan();
    }

    /**
     * Create an instance of {@link TariffPlan }
     * 
     */
    public TariffPlan createTariffPlan() {
        return new TariffPlan();
    }

    /**
     * Create an instance of {@link GetTariffPlanLike }
     * 
     */
    public GetTariffPlanLike createGetTariffPlanLike() {
        return new GetTariffPlanLike();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTariffPlanEconomyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bt.com/", name = "getTariffPlanEconomyResponse")
    public JAXBElement<GetTariffPlanEconomyResponse> createGetTariffPlanEconomyResponse(GetTariffPlanEconomyResponse value) {
        return new JAXBElement<GetTariffPlanEconomyResponse>(_GetTariffPlanEconomyResponse_QNAME, GetTariffPlanEconomyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTariffPlanLikeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bt.com/", name = "getTariffPlanLikeResponse")
    public JAXBElement<GetTariffPlanLikeResponse> createGetTariffPlanLikeResponse(GetTariffPlanLikeResponse value) {
        return new JAXBElement<GetTariffPlanLikeResponse>(_GetTariffPlanLikeResponse_QNAME, GetTariffPlanLikeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTariffPlan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bt.com/", name = "getTariffPlan")
    public JAXBElement<GetTariffPlan> createGetTariffPlan(GetTariffPlan value) {
        return new JAXBElement<GetTariffPlan>(_GetTariffPlan_QNAME, GetTariffPlan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TariffPlan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bt.com/", name = "tariff")
    public JAXBElement<TariffPlan> createTariff(TariffPlan value) {
        return new JAXBElement<TariffPlan>(_Tariff_QNAME, TariffPlan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTariffPlanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bt.com/", name = "getTariffPlanResponse")
    public JAXBElement<GetTariffPlanResponse> createGetTariffPlanResponse(GetTariffPlanResponse value) {
        return new JAXBElement<GetTariffPlanResponse>(_GetTariffPlanResponse_QNAME, GetTariffPlanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTariffPlanEconomy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bt.com/", name = "getTariffPlanEconomy")
    public JAXBElement<GetTariffPlanEconomy> createGetTariffPlanEconomy(GetTariffPlanEconomy value) {
        return new JAXBElement<GetTariffPlanEconomy>(_GetTariffPlanEconomy_QNAME, GetTariffPlanEconomy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTariffPlanLike }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bt.com/", name = "getTariffPlanLike")
    public JAXBElement<GetTariffPlanLike> createGetTariffPlanLike(GetTariffPlanLike value) {
        return new JAXBElement<GetTariffPlanLike>(_GetTariffPlanLike_QNAME, GetTariffPlanLike.class, null, value);
    }

}
