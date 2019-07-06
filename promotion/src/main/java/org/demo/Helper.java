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

	String[] promocodes =
		{ 
			"promo-01", 
			"promo-02", 
			"promo-03", 
			"promo-04", 
			"promo-05", 
			"promo-06"
		};

	Random rand = new Random();

	public void setRandomPromoCode(Exchange exchange)
	{
		int randomNum = rand.nextInt(promocodes.length);
		String payload = "{\n    \"promocode\":\""+promocodes[randomNum]+"\"\n}";

		exchange.getIn().setHeader("promocode", promocodes[randomNum]);
		exchange.getIn().setBody(payload);
	}
}
