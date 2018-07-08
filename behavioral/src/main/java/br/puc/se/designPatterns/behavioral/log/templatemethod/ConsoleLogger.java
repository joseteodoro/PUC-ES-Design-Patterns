package br.puc.se.designPatterns.behavioral.log.templatemethod;

import java.util.Date;

import br.puc.se.designPatterns.behavioral.log.LogLevel;

public class ConsoleLogger extends DefaultLogger  {

	String formatMessage(LogLevel messageLevel, String message) {
		return String.format("[Logger: %s] %s:%s: %s", "ConsoleLogger", new Date(), messageLevel, message);
	}

}
