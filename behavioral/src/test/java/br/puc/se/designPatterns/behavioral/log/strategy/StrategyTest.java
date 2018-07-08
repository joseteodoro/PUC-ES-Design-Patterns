package br.puc.se.designPatterns.behavioral.log.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.puc.se.designPatterns.behavioral.log.LogLevel;
import br.puc.se.designPatterns.behavioral.log.LogListener;
import br.puc.se.designPatterns.behavioral.strategy.ConsoleOutput;
import br.puc.se.designPatterns.behavioral.strategy.DefaultLogger;
import br.puc.se.designPatterns.behavioral.strategy.FileOuput;
import br.puc.se.designPatterns.behavioral.strategy.HttpOutput;

public class StrategyTest {

	@Test
	public void consoleTest() {
		LogListener listener = new LogListener();

		ConsoleOutput consoleOuput = new ConsoleOutput();
		DefaultLogger logger = new DefaultLogger(consoleOuput);
		logger.setLogLevel(LogLevel.ERROR);
		logger.addListener(listener);

		logger.log(LogLevel.INFO, "should not log");
		logger.log(LogLevel.WARNING, "should not log");
		logger.log(LogLevel.ERROR, "should log");
		logger.log(LogLevel.FATAL, "should log");

		assertEquals(2, listener.getLogs().size());
	}

	@Test
	public void fileTest() {
		LogListener listener = new LogListener();

		DefaultLogger logger = new DefaultLogger(new FileOuput());
		logger.setLogLevel(LogLevel.FATAL);
		logger.addListener(listener);

		logger.log(LogLevel.INFO, "should not log");
		logger.log(LogLevel.WARNING, "should not log");
		logger.log(LogLevel.ERROR, "should not log");
		logger.log(LogLevel.FATAL, "should log");

		assertEquals(1, listener.getLogs().size());
	}

	@Test
	public void httpTest() {
		LogListener listener = new LogListener();

		DefaultLogger logger = new DefaultLogger(new HttpOutput());
		logger.setLogLevel(LogLevel.INFO);
		logger.addListener(listener);

		logger.log(LogLevel.INFO, "should log");
		logger.log(LogLevel.WARNING, "should log");
		logger.log(LogLevel.ERROR, "should log");
		logger.log(LogLevel.FATAL, "should log");

		assertEquals(4, listener.getLogs().size());
	}

	@Test
	public void consoleMessageTest() {
		LogListener listener = new LogListener();

		ConsoleOutput consoleOutput = new ConsoleOutput();
		DefaultLogger logger = new DefaultLogger(consoleOutput);
		logger.setLogLevel(LogLevel.ERROR);
		logger.addListener(listener);

		logger.log(LogLevel.ERROR, "should log");

		assertEquals(1, listener.getLogs().size());
		for (String message : listener.getLogs()) {
			assertTrue("should contains the message ['should log']", message.contains("should log"));
			assertTrue("should contains the logger name '[Logger: ConsoleLogger]'",
					message.contains("[Logger: ConsoleLogger]"));
			assertTrue("should contains the log level ':ERROR:'", message.contains(":ERROR:"));
		}
	}

	@Test
	public void fileMessageTest() {
		LogListener listener = new LogListener();

		FileOuput fileOuput = new FileOuput();
		DefaultLogger logger = new DefaultLogger(fileOuput);
		logger.setLogLevel(LogLevel.ERROR);
		logger.addListener(listener);

		logger.log(LogLevel.INFO, "should not log");
		logger.log(LogLevel.ERROR, "should log");

		assertEquals(1, listener.getLogs().size());
		for (String message : listener.getLogs()) {
			assertTrue("should contains the message ['should log']", message.contains("should log"));
			assertTrue(
					"should contains the logger name '[Logger: FileLogger on "
							+ fileOuput.getFileName() + "]'",
					message.contains("[Logger: FileLogger on "+ fileOuput.getFileName() +"]"));
			assertTrue("should contains the log level ':ERROR:'", message.contains(":ERROR:"));
		}
	}

	@Test
	public void httpMessageTest() {
		LogListener listener = new LogListener();

		HttpOutput httpOuput = new HttpOutput();
		DefaultLogger logger = new DefaultLogger(httpOuput);
		logger.setLogLevel(LogLevel.DEBUG);
		logger.addListener(listener);

		logger.log(LogLevel.DEBUG, "should log");

		assertEquals(1, listener.getLogs().size());
		for (String message : listener.getLogs()) {
			assertTrue("should contains the message ['should log']", message.contains("should log"));
			assertTrue(
					"should contains the logger name '[Logger: HttpPostLogger on "
							+ httpOuput.getUri() + "]'",
					message.contains("[Logger: HttpPostLogger on "+ httpOuput.getUri() +"]"));
			assertTrue("should contains the log level ':DEBUG:'", message.contains(":DEBUG:"));
		}
	}

}
