package br.puc.se.designPatterns.behavioral.strategy;

import java.util.Date;

import br.puc.se.designPatterns.behavioral.log.LogLevel;

public class HttpOutput implements LogOutput {

	private String uri = "http://localhost:8080";
	
	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	@Override
	public String format(LogLevel messageLevel, String message) {
		return String.format("[Logger: %s on %s]:%s:%s: %s", "HttpPostLogger", this.uri, new Date(), messageLevel, message);
	}

}
