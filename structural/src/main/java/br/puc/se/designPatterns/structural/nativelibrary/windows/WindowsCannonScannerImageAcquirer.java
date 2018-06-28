package br.puc.se.designPatterns.structural.nativelibrary.windows;

import br.puc.se.designPatterns.structural.nativelibrary.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.ScannerImageAcquirer;

public class WindowsCannonScannerImageAcquirer implements ScannerImageAcquirer {

	public ImageData getImagesFromScanner() {
		WindowsCannonScannerDriver driver = new WindowsCannonScannerDriver();
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
