package br.puc.se.designPatterns.structural.nativelibrary.linux;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.so.LinuxCannonScannerDriver;

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
