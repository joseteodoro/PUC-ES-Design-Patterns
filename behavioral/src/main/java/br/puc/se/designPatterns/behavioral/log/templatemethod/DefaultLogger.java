package br.puc.se.designPatterns.behavioral.log.templatemethod;

import java.util.HashSet;
import java.util.Set;

import br.puc.se.designPatterns.behavioral.log.LogLevel;
import br.puc.se.designPatterns.behavioral.log.LogListener;
import br.puc.se.designPatterns.behavioral.log.Logger;

public abstract class DefaultLogger implements Logger {

	private LogLevel level = LogLevel.INFO;
	private Set<LogListener> listeners = new HashSet<>();

	public DefaultLogger() {
		super();
	}

	public void setLogLevel(LogLevel logLevel) {
		this.level= logLevel;
	}

	public void log(LogLevel messageLevel, String message) {
		if (messageLevel.getPriority() <= level.getPriority()) {
			String formatedMessage = this.formatMessage(messageLevel, message);
			this.doLog(formatedMessage);
		}
	}

	abstract String formatMessage(LogLevel messageLevel, String message);

	private void doLog(String formatedMessage) {
		// mock the log for console and send it to listeners
		for (LogListener listener : this.listeners) {
			listener.onLog(formatedMessage);
		}
	}

	public void addListener(LogListener listener) {
		this.listeners.add(listener);
	}

}