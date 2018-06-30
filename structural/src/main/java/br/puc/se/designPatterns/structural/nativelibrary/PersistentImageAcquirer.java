package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;

public class PersistentImageAcquirer implements ScannerImageAcquirer {

	private ScannerImageAcquirer acquirer;
	private String fileNameToSave;

	public PersistentImageAcquirer(ScannerImageAcquirer acquirer, String fileNameToSave) {
		this.acquirer = acquirer;
		this.fileNameToSave = fileNameToSave;
	}

	@Override
	public ImageData getImagesFromScanner() {
		ImageData imagesFromScanner = this.acquirer.getImagesFromScanner();
		return imagesFromScanner.saveToFile(fileNameToSave);
	}

	@Override
	public boolean isScannerPresent() {
		return this.acquirer.isScannerPresent();
	}

}
