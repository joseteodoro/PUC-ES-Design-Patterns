package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerDriver;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;

public class GenericScannerImageAcquirer implements ScannerImageAcquirer {

	private ScannerDriverType type;

	public GenericScannerImageAcquirer(ScannerDriverType type) {
		this.type = type;
		
	}
	
	public ImageData getImagesFromScanner() {
		ScannerDriver driver = type.buildDriver();
		driver.startScannerDevice();
		driver.showScanDialog();
		return driver.scan();
	}

	public boolean isScannerPresent() {
		return System.getProperty("imageAcquirer.vendor", "").equals(type.getVendor()) &&
				System.getProperty("imageAcquirer.so", "").equals(type.getSo());
	}

}
