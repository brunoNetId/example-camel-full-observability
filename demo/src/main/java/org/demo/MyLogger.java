package org.demo;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static net.logstash.logback.argument.StructuredArguments.*;

public class MyLogger {
  private static final Logger logger = LoggerFactory.getLogger(MyLogger.class);

  public void info(String message, Exchange exchange) throws Exception {
    String clientId = exchange.getIn().getHeader("client-id", String.class);
    logger.info(message, value("clientId", clientId));
  }
}