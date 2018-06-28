package br.puc.se.designPatterns.structural.nativelibrary.mac;

import br.puc.se.designPatterns.structural.nativelibrary.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.ScannerImageAcquirer;

public class MacKodakScannerImageAcquirer implements ScannerImageAcquirer {

	public ImageData getImagesFromScanner() {
		MacKodakScannerDriver driver = new MacKodakScannerDriver();
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
