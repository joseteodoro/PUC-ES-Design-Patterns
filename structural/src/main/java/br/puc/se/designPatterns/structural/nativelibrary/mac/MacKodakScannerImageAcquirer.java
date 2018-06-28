package br.puc.se.designPatterns.structural.nativelibrary.mac;

import br.puc.se.designPatterns.structural.nativelibrary.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.ScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.MacKodakScannerDriver;

public class MacKodakScannerImageAcquirer implements ScannerImageAcquirer {

	public ImageData getImagesFromScanner() {
		MacKodakScannerDriver driver = new MacKodakScannerDriver();
		driver.startScannerDevice();
		driver.showScanDialog();
		ImageData scanned = driver.scan();
		return scanned;
	}

	public boolean isScannerPresent() {
		return System.getProperty("imageAcquirer.vendor", "").equals("kodak") &&
				System.getProperty("imageAcquirer.so", "").equals("mac");
	}

}
