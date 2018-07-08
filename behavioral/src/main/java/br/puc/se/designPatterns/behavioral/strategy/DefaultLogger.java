package br.puc.se.designPatterns.behavioral.strategy;

import java.util.HashSet;
import java.util.Set;

import br.puc.se.designPatterns.behavioral.log.LogLevel;
import br.puc.se.designPatterns.behavioral.log.LogListener;
import br.puc.se.designPatterns.behavioral.log.Logger;

public class DefaultLogger implements Logger {
	
	private LogOutput output;
	
	public DefaultLogger(LogOutput output) {
		this.output = output;
	}

	private LogLevel level = LogLevel.INFO;
	
	private Set<LogListener> listeners = new HashSet<>();
	
	@Override
	public void setLogLevel(LogLevel logLevel) {
		this.level= logLevel;
	}

	@Override
	public void log(LogLevel messageLevel, String message) {
		if (messageLevel.getPriority() <= level.getPriority()) {
			String formatedMessage = this.formatMessage(messageLevel, message);
			this.doLog(formatedMessage);
		}
	}
	
	private String formatMessage(LogLevel messageLevel, String message) {
		return output.format(messageLevel, message);
	}

	private void doLog(String formatedMessage) {
		// mock the log for console and send it to listeners
		for (LogListener listener : this.listeners) {
			listener.onLog(formatedMessage);
		}
	}

	@Override
	public void addListener(LogListener listener) {
		this.listeners.add(listener);
	}

}
