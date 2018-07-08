package br.puc.se.designPatterns.behavioral.strategy;

import java.util.Date;

import br.puc.se.designPatterns.behavioral.log.LogLevel;

public class ConsoleOutput implements LogOutput{

	@Override
	public String format(LogLevel messageLevel, String message) {
		return String.format("[Logger: %s] %s:%s: %s", "ConsoleLogger", new Date(), messageLevel, message);
	}

}
