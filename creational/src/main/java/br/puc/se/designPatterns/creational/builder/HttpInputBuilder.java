package br.puc.se.designPatterns.creational.builder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HttpInputBuilder implements InputBuilder<HttpInputConnection> {
	
	private Properties connectionProperties;
	
	public HttpInputBuilder() {
		this.connectionProperties = new Properties();
	}
	
	public HttpInputBuilder fromPropertyFile(String fileName) throws FileNotFoundException, IOException {
		this.connectionProperties = BuilderUtilities.readPropertiesFromResourceFile(fileName);
		return this;
	}
	
	@Override
	public Input<HttpInputConnection> build() {
		HttpInputConnection httpInputConnection = new HttpInputConnection();
		httpInputConnection.setMethod(this.connectionProperties.getProperty("method"));
		httpInputConnection.setProtocol(this.connectionProperties.getProperty("protocol"));
		httpInputConnection.setHost(this.connectionProperties.getProperty("host"));
		httpInputConnection.setPort(this.connectionProperties.getProperty("port"));
		return () -> httpInputConnection;
	}
	
	public HttpInputBuilder fromHost(String host) {
		this.connectionProperties.put("host", host);
		return this;
	}

	public HttpInputBuilder usingProtocol(String protocol) {
		this.connectionProperties.put("protocol", protocol);
		return this;
	}

	public HttpInputBuilder onPort(int port) {
		this.connectionProperties.put("port", String.valueOf(port));
		return this;
	}

	public HttpInputBuilder usingMethod(String method) {
		this.connectionProperties.put("method", method);
		return this;
	}

}
