package org.demo;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
// import javax.mail.util.ByteArrayDataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultAttachment;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;


public class Helper {
	
	public void setStatus(Exchange exchange)
	{
		String status = "<payment>\n    <status>success</status>\n</payment>";

		exchange.getIn().setBody(status);
	}
}
