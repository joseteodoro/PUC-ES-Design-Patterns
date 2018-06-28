package br.puc.se.designPatterns.structural.nativelibrary.mac;

import br.puc.se.designPatterns.structural.nativelibrary.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.ScannerImageAcquirer;

public class MacCannonScannerImageAcquirer implements ScannerImageAcquirer {

	public ImageData getImagesFromScanner() {
		MacCannonScannerDriver driver = new MacCannonScannerDriver();
		driver.startScannerDevice();
		driver.showScanDialog();
		ImageData scanned = driver.scan();
		return scanned;
	}

	public boolean isScannerPresent() {
		// TODO Auto-generated method stub
		return false;
	}

}
