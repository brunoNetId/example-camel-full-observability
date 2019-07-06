package org.demo;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;

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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "payment")
public class Payment {
	
	String clientId;
	String content;
	String promoCode;

	@XmlElement(name = "client-id")
	public void setClientId(String id)
	{
		clientId = id;
	}

	public String getClientId()
	{
		return clientId;
	}

	@XmlElement(name = "content-id")
	public void setContent(String content)
	{
		this.content = content;
	}

	public String getContent()
	{
		return content;
	}

	@XmlElement(name = "promo-code")
	public void setPromoCode(String code)
	{
		promoCode = code;
	}

	public String getPromoCode()
	{
		return promoCode;
	}
}
