package br.puc.se.designPatterns.behavioral.strategy;

import br.puc.se.designPatterns.behavioral.log.LogLevel;

public interface LogOutput {

	String format(LogLevel messageLevel, String message);

}
