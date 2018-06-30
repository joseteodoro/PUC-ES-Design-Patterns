package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.linux.LinuxCannonScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.linux.LinuxKodakScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.mac.MacCannonScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.mac.MacKodakScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.windows.WindowsCannonScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.windows.WindowsKodakScannerImageAcquirer;

public class ScannerImageAcquirerFactory {

	public ScannerImageAcquirer createImageAcquirer() {
		String so = System.getProperty("imageAcquirer.so", "linux");
		String vendor = System.getProperty("imageAcquirer.vendor", "kodak");
		if (so.equalsIgnoreCase("linux")) {
			if (vendor.equals("kodak")) {
				return new LinuxKodakScannerImageAcquirer();
			}
			return new LinuxCannonScannerImageAcquirer();
		}
		if (so.equalsIgnoreCase("windows")) {
			if (vendor.equals("kodak")) {
				return new WindowsKodakScannerImageAcquirer();
			}
			return new WindowsCannonScannerImageAcquirer();
		}
		if (so.equalsIgnoreCase("mac")) {
			if (vendor.equals("kodak")) {
				return new MacKodakScannerImageAcquirer();
			}
			return new MacCannonScannerImageAcquirer();
		}
//		return new LinuxKodakScannerImageAcquirer();
		return null;
	}

}
