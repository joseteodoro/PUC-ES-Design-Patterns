package br.puc.se.designPatterns.creational.singleton;

import java.util.Optional;

public class MyCustomApplicationContext {

	private static Optional<MyCustomApplicationContext> INSTANCE = Optional.empty();
	
	public static MyCustomApplicationContext getInstance() {
		if (!INSTANCE.isPresent()) {
			INSTANCE = Optional.of(new MyCustomApplicationContext());
		}
		return INSTANCE.get();
	}
	
	private MyCustomApplicationContext() {};

}
