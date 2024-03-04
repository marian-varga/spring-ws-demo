package com.example.springwsdemo;

import com.example.springwsdemo.gen.NumberToDollars;
import com.example.springwsdemo.gen.NumberToDollarsResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigDecimal;

@Service
public class NumberConversionClient extends WebServiceGatewaySupport {

    public NumberConversionClient() {
        setDefaultUri("https://www.dataaccess.com/webservicesserver/NumberConversion.wso");
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.springwsdemo.gen");
        setMarshaller(marshaller);
        setUnmarshaller(marshaller);
    }

    public String convert(BigDecimal input) {
        NumberToDollars requestPayload = new NumberToDollars();
        requestPayload.setDNum(input);
        NumberToDollarsResponse responsePayload = (NumberToDollarsResponse) getWebServiceTemplate()
                .marshalSendAndReceive(requestPayload);
        return responsePayload.getNumberToDollarsResult();
    }
}
