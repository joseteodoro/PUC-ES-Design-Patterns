package br.puc.se.designPatterns.structural.nativelibrary.mac;

import br.puc.se.designPatterns.structural.nativelibrary.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.ScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.MacCannonScannerDriver;

public class MacCannonScannerImageAcquirer implements ScannerImageAcquirer {

	public ImageData getImagesFromScanner() {
		MacCannonScannerDriver driver = new MacCannonScannerDriver();
		driver.startScannerDevice();
		driver.showScanDialog();
		ImageData scanned = driver.scan();
		return scanned;
	}

	public boolean isScannerPresent() {
		return System.getProperty("imageAcquirer.vendor", "").equals("cannon") &&
				System.getProperty("imageAcquirer.so", "").equals("mac");
	}

}
