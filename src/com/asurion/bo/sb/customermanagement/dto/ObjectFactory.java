
package com.asurion.bo.sb.customermanagement.dto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.asurion.bo.sb.customermanagement.dto package. 
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

    private final static QName _GetAllCustomersRequest_QNAME = new QName("http://dto.customermanagement.sb.bo.asurion.com/", "GetAllCustomersRequest");
    private final static QName _GetAllCustomersResponse_QNAME = new QName("http://dto.customermanagement.sb.bo.asurion.com/", "GetAllCustomersResponse");
    private final static QName _GetCustomerRequest_QNAME = new QName("http://dto.customermanagement.sb.bo.asurion.com/", "GetCustomerRequest");
    private final static QName _GetCustomerResponse_QNAME = new QName("http://dto.customermanagement.sb.bo.asurion.com/", "GetCustomerResponse");
    private final static QName _CreateCustomerRequest_QNAME = new QName("http://dto.customermanagement.sb.bo.asurion.com/", "CreateCustomerRequest");
    private final static QName _CreateCustomerResponse_QNAME = new QName("http://dto.customermanagement.sb.bo.asurion.com/", "CreateCustomerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.asurion.bo.sb.customermanagement.dto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllCustomersRequest }
     * 
     */
    public GetAllCustomersRequest createGetAllCustomersRequest() {
        return new GetAllCustomersRequest();
    }

    /**
     * Create an instance of {@link GetAllCustomersResponse }
     * 
     */
    public GetAllCustomersResponse createGetAllCustomersResponse() {
        return new GetAllCustomersResponse();
    }

    /**
     * Create an instance of {@link GetCustomerRequest }
     * 
     */
    public GetCustomerRequest createGetCustomerRequest() {
        return new GetCustomerRequest();
    }

    /**
     * Create an instance of {@link GetCustomerResponse }
     * 
     */
    public GetCustomerResponse createGetCustomerResponse() {
        return new GetCustomerResponse();
    }

    /**
     * Create an instance of {@link CreateCustomerRequest }
     * 
     */
    public CreateCustomerRequest createCreateCustomerRequest() {
        return new CreateCustomerRequest();
    }

    /**
     * Create an instance of {@link CreateCustomerResponse }
     * 
     */
    public CreateCustomerResponse createCreateCustomerResponse() {
        return new CreateCustomerResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCustomersRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.customermanagement.sb.bo.asurion.com/", name = "GetAllCustomersRequest")
    public JAXBElement<GetAllCustomersRequest> createGetAllCustomersRequest(GetAllCustomersRequest value) {
        return new JAXBElement<GetAllCustomersRequest>(_GetAllCustomersRequest_QNAME, GetAllCustomersRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCustomersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.customermanagement.sb.bo.asurion.com/", name = "GetAllCustomersResponse")
    public JAXBElement<GetAllCustomersResponse> createGetAllCustomersResponse(GetAllCustomersResponse value) {
        return new JAXBElement<GetAllCustomersResponse>(_GetAllCustomersResponse_QNAME, GetAllCustomersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.customermanagement.sb.bo.asurion.com/", name = "GetCustomerRequest")
    public JAXBElement<GetCustomerRequest> createGetCustomerRequest(GetCustomerRequest value) {
        return new JAXBElement<GetCustomerRequest>(_GetCustomerRequest_QNAME, GetCustomerRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.customermanagement.sb.bo.asurion.com/", name = "GetCustomerResponse")
    public JAXBElement<GetCustomerResponse> createGetCustomerResponse(GetCustomerResponse value) {
        return new JAXBElement<GetCustomerResponse>(_GetCustomerResponse_QNAME, GetCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCustomerRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.customermanagement.sb.bo.asurion.com/", name = "CreateCustomerRequest")
    public JAXBElement<CreateCustomerRequest> createCreateCustomerRequest(CreateCustomerRequest value) {
        return new JAXBElement<CreateCustomerRequest>(_CreateCustomerRequest_QNAME, CreateCustomerRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.customermanagement.sb.bo.asurion.com/", name = "CreateCustomerResponse")
    public JAXBElement<CreateCustomerResponse> createCreateCustomerResponse(CreateCustomerResponse value) {
        return new JAXBElement<CreateCustomerResponse>(_CreateCustomerResponse_QNAME, CreateCustomerResponse.class, null, value);
    }

}
