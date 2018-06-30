package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;

public class GrayImageAcquirer implements ScannerImageAcquirer {

	private ScannerImageAcquirer scannerImageAcquirer;

	public GrayImageAcquirer(ScannerImageAcquirer scannerImageAcquirer) {
		this.scannerImageAcquirer = scannerImageAcquirer;
	}

	@Override
	public ImageData getImagesFromScanner() {
		ImageData imagesFromScanner = this.scannerImageAcquirer.getImagesFromScanner();
		return imagesFromScanner.toGrayScale();
	}

	@Override
	public boolean isScannerPresent() {
		return this.scannerImageAcquirer.isScannerPresent();
	}

}
