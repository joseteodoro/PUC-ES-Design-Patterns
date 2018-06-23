package br.puc.se.designPatterns.creational.builder;

public class ResourceFileBuilder implements InputBuilder<String> {

	private Input<String> input;
	
	public ResourceFileBuilder() {
		this.input = () -> "no content";
	}
	
	public Input<String> build() {
		return input;
	}

	public InputBuilder<String> fromResource(String pathToResource) {
		this.input = new ResourceFileInput(pathToResource);
		return this;
	}

}
