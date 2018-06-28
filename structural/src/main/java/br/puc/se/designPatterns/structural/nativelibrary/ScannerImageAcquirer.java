package br.puc.se.designPatterns.structural.nativelibrary;

public interface ScannerImageAcquirer {
	
	public ImageData getImagesFromScanner();

	public boolean isScannerPresent();

}
