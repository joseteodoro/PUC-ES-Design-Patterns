package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;

public class ScaledImageAcquirer implements ScannerImageAcquirer {

	private ScannerImageAcquirer scannerImageAcquirer;
	private int width;
	private int height;
	
	public ScaledImageAcquirer(ScannerImageAcquirer acquirer, int width, int height) {
		this.scannerImageAcquirer = acquirer;
		this.width = width;
		this.height = height;
	}

	@Override
	public ImageData getImagesFromScanner() {
		ImageData imagesFromScanner = this.scannerImageAcquirer.getImagesFromScanner();
		return imagesFromScanner.scale(width, height);
	}

	@Override
	public boolean isScannerPresent() {
		return this.scannerImageAcquirer.isScannerPresent();
	}

}
