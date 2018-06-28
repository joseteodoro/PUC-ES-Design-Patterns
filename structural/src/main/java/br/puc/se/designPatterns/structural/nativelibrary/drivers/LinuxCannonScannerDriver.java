package br.puc.se.designPatterns.structural.nativelibrary.drivers;

import br.puc.se.designPatterns.structural.nativelibrary.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.ScannerConfig;
import br.puc.se.designPatterns.structural.nativelibrary.ScannerDriver;

public class LinuxCannonScannerDriver implements ScannerDriver {

	private ScannerConfig config = new ScannerConfig("linux", "cannon", false, false);
	
	public void startScannerDevice() {
		config.start();
	}

	public void showScanDialog() {
		config.configure();
	}

	public ImageData scan() {
		return new ImageData(config);
	}

}
