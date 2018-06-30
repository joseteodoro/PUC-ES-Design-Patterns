package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;

public class ScannerImageAcquirerBuilder {

	private ScannerImageAcquirer acquirer;
	
	public ScannerImageAcquirerBuilder() {
		acquirer = new ScannerImageAcquirerFactory().createImageAcquirer();
	}
	
	public ScannerImageAcquirerBuilder withScale(int width, int height) {
		this.acquirer = new ScaledImageAcquirer(this.acquirer, width, height);
		return this;
	}

	public ScannerImageAcquirerBuilder withGrayScale() {
		this.acquirer = new GrayImageAcquirer(this.acquirer);
		return this;
	}

	public ScannerImageAcquirerBuilder withPNGConvertion() {
		this.acquirer = new PNGImageAcquirer(this.acquirer);
		return this;
	}

	public ScannerImageAcquirerBuilder withPersistence(String fileNameToSave) {
		this.acquirer = new PersistentImageAcquirer(this.acquirer, fileNameToSave);
		return this;
	}

	public ScannerImageAcquirer build() {
		return this.acquirer;
	}

}
