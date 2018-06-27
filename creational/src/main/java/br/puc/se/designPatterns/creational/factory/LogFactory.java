package br.puc.se.designPatterns.creational.factory;

public class LogFactory {

	public OutputLogger loggerOf(LoggerType type) {
		switch (type) {
		case FILE:
			return new FileOutputLogger();

		case HTTP_POST:
			return new HTTPOutputLogger();

		case JMS:
			return new JMSOutputLogger();

		case CONSOLE:
		default:
			return new ConsoleOutputLogger();
		}
	}

}
