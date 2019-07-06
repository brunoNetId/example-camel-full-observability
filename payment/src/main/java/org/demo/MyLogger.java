package org.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

import static net.logstash.logback.argument.StructuredArguments.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyLogger {
	
	private static final Logger logger = LoggerFactory.getLogger(MyLogger.class);

    public void info(String message, Exchange exchange) throws Exception
    {
		String traceId = exchange.getIn().getHeader("uber-trace-id", String.class).split(":")[0];
		logger.info(message, value("traceId", traceId));
    }
}
