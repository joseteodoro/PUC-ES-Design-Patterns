package br.puc.se.designPatterns.creational.builder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HttpInputBuilder implements InputBuilder<HttpInputConnection> {
	
	private Properties connectionProperties;

	public HttpInputBuilder fromPropertyFile(String fileName) throws FileNotFoundException, IOException {
		this.connectionProperties = BuilderUtilities.readPropertiesFromResourceFile(fileName);
		return this;
	}

}
