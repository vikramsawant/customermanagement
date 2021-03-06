package com.asurion.bo.sb.customermanagement.dto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2016-12-12T17:22:03.248-06:00
 * Generated source version: 3.1.7
 * 
 */
@WebService(targetNamespace = "http://dto.customermanagement.sb.bo.asurion.com/", name = "GetCustomerPortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface GetCustomerPortType {

    @WebMethod(operationName = "GetCustomer")
    @WebResult(name = "GetCustomerResponse", targetNamespace = "http://dto.customermanagement.sb.bo.asurion.com/", partName = "response")
    public GetCustomerResponse getCustomer(
        @WebParam(partName = "request", name = "GetCustomerRequest", targetNamespace = "http://dto.customermanagement.sb.bo.asurion.com/")
        GetCustomerRequest request
    );
}
