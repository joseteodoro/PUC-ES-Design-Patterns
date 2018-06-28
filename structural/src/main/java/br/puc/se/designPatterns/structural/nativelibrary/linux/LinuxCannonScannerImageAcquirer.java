package br.puc.se.designPatterns.structural.nativelibrary.linux;

import br.puc.se.designPatterns.structural.nativelibrary.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.ScannerImageAcquirer;

public class LinuxCannonScannerImageAcquirer implements ScannerImageAcquirer {

	public ImageData getImagesFromScanner() {
		LinuxCannonScannerDriver driver = new LinuxCannonScannerDriver();
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
