package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.linux.LinuxCannonScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.linux.LinuxKodakScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.mac.MacCannonScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.mac.MacKodakScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.windows.WindowsCannonScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.windows.WindowsKodakScannerImageAcquirer;

// Refactor this to avoid those lot of replicated code
// Tips: #1 a controller / facade to abstract the image module
//       #2 a factory to create the right imageAcquirer
//       #3 a bridge to avoid 6 subclasses of ScannerImageAcquirer and reuse the code from drivers
//       #4 a decorator to adjust the image (sizeScale, grayScale, TiffToPNG)
public class ImageAcquirerClient {

	private static int width = 640;
	
	private static int height = 480;
	
	public void getImageFromScannerAndSave() {
		String so = System.getProperty("os.name");
		ScannerImageAcquirer imageAcquirer = null;
		if (so.equalsIgnoreCase("linux")) {
			imageAcquirer = new LinuxKodakScannerImageAcquirer();
			if (!imageAcquirer.isScannerPresent()) {
				imageAcquirer = new LinuxCannonScannerImageAcquirer();
			}
		}
		if (so.equalsIgnoreCase("windows")) {
			imageAcquirer = new WindowsKodakScannerImageAcquirer();
			if (!imageAcquirer.isScannerPresent()) {
				imageAcquirer = new WindowsCannonScannerImageAcquirer();
			}
		}
		if (so.equalsIgnoreCase("mac")) {
			imageAcquirer = new MacKodakScannerImageAcquirer();
			if (!imageAcquirer.isScannerPresent()) {
				imageAcquirer = new MacCannonScannerImageAcquirer();
			}
		}
		ImageData source = imageAcquirer.getImagesFromScanner();
		ImageData scaled = this.scaleImage(this.toGrayScale(this.convertFromTIFFToPNG(source)), width, height);
		this.saveImageOnDatabase(scaled, this.getFileNameToSave());
	}
	
	private ImageData convertFromTIFFToPNG(ImageData source) {
		// convert the image from tiff to png encoding
		return source;
	}

	private void saveImageOnDatabase(ImageData scaled, String fileNameToSave) {
		// save image on the filename path
	}

	private String getFileNameToSave() {
		// mock returning a filename to store the image file
		return null;
	}

	public ImageData toGrayScale(ImageData source) {
		// convert the image to gray
		return source;
	}
	
	public ImageData scaleImage(ImageData source, int width, int height) {
		// scale the image to fit the size
		return source;
	}
	
}
