package br.puc.se.designPatterns.structural.nativelibrary.windows;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.so.WindowsKodakScannerDriver;

public class WindowsKodakScannerImageAcquirer implements ScannerImageAcquirer {

	public ImageData getImagesFromScanner() {
		WindowsKodakScannerDriver driver = new WindowsKodakScannerDriver();
		driver.startScannerDevice();
		driver.showScanDialog();
		ImageData scanned = driver.scan();
		return scanned;
	}

	public boolean isScannerPresent() {
		return System.getProperty("imageAcquirer.vendor", "").equals("kodak") &&
				System.getProperty("imageAcquirer.so", "").equals("windows");
	}

}
