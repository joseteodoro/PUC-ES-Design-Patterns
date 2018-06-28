package br.puc.se.designPatterns.structural.nativelibrary.windows;

import br.puc.se.designPatterns.structural.nativelibrary.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.ScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.WindowsCannonScannerDriver;

public class WindowsCannonScannerImageAcquirer implements ScannerImageAcquirer {

	public ImageData getImagesFromScanner() {
		WindowsCannonScannerDriver driver = new WindowsCannonScannerDriver();
		driver.startScannerDevice();
		driver.showScanDialog();
		ImageData scanned = driver.scan();
		return scanned;
	}

	public boolean isScannerPresent() {
		return System.getProperty("imageAcquirer.vendor", "").equals("cannon") &&
				System.getProperty("imageAcquirer.so", "").equals("windows");
	}

}
