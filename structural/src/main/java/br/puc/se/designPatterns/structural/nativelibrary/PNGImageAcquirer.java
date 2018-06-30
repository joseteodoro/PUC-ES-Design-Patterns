package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;

public class PNGImageAcquirer implements ScannerImageAcquirer {

	private ScannerImageAcquirer scannerImageAcquirer;

	public PNGImageAcquirer(ScannerImageAcquirer scannerImageAcquirer) {
		this.scannerImageAcquirer = scannerImageAcquirer;
	}

	@Override
	public ImageData getImagesFromScanner() {
		ImageData imagesFromScanner = this.scannerImageAcquirer.getImagesFromScanner();
		return imagesFromScanner.convertToPNG();
	}

	@Override
	public boolean isScannerPresent() {
		return this.scannerImageAcquirer.isScannerPresent();
	}

}
