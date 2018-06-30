package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;

public class ScannerImageAcquirerFactory {

	public ScannerImageAcquirer createImageAcquirer() {
		String so = System.getProperty("imageAcquirer.so", "linux");
		String vendor = System.getProperty("imageAcquirer.vendor", "kodak");
		ScannerDriverType driver = ScannerDriverType.getBySOandVendor(so, vendor);
		return new GenericScannerImageAcquirer(driver);
	}

}
