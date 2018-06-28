package br.puc.se.designPatterns.structural.nativelibrary.linux;

import br.puc.se.designPatterns.structural.nativelibrary.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.ScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.LinuxCannonScannerDriver;

public class LinuxCannonScannerImageAcquirer implements ScannerImageAcquirer {

	public ImageData getImagesFromScanner() {
		LinuxCannonScannerDriver driver = new LinuxCannonScannerDriver();
		driver.startScannerDevice();
		driver.showScanDialog();
		return driver.scan();
	}

	public boolean isScannerPresent() {
		return System.getProperty("imageAcquirer.vendor", "").equals("cannon") &&
				System.getProperty("imageAcquirer.so", "").equals("linux");
	}

}
