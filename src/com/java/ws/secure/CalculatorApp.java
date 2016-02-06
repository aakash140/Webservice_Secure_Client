package com.java.ws.secure;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

public class CalculatorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatorService calculatorService=new CalculatorService();
		CalculatorIfc calculatorIfc=calculatorService.getCalculatorPort();
		Map<String,Object> requestContext=((BindingProvider)calculatorIfc).getRequestContext();
		Map<String,Object> requestHeader=new HashMap<String, Object>();
		requestHeader.put("USERNAME", Collections.singletonList("admin"));
		requestHeader.put("PASSWORD", Collections.singletonList("pass@123"));
		requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
				"http://localhost:8085/ws_secure/calculator?wsdl");
		requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, requestHeader);
		calculatorIfc.add(3, 2);
	}
}