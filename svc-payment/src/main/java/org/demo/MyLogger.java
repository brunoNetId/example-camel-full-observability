package org.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.apache.camel.Message;
import org.apache.camel.Property;

import static net.logstash.logback.argument.StructuredArguments.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyLogger {
	
    private static final Logger logger = LoggerFactory.getLogger(MyLogger.class);

    JAXBContext jaxbContext;
    Marshaller jaxbMarshaller; 

    MyLogger() throws Exception
    {
        jaxbContext    = JAXBContext.newInstance( Payment.class );
        jaxbMarshaller = jaxbContext.createMarshaller();
	 
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        jaxbMarshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
    }

    public void info(
						String message,
						boolean includePayload,
						@Header("uber-trace-id") 	String traceId,
						@Property("request") 		org.demo.Payment payment,
						@Property("identifier") 	String clientId
					) throws Exception
    {
		String id = traceId.split(":")[0];

		if(!includePayload)
		{
			logger.info(
					message, 
					value("traceId", id),
					value("clientId", clientId)
			);
		}
		else
		{
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(payment, new PrintWriter( sw ));

			logger.info(
					message, 
					value("traceId", id),
					value("clientId", clientId),
					value("payload", sw.toString())
			);
		}
    }

}
