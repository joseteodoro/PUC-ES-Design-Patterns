package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;

// Refactor this to avoid those lot of replicated code
// Tips: #1 a controller / facade to abstract the image module
//       [x] #2 a factory to create the right imageAcquirer
//       [x] #3 a bridge to avoid 6 subclasses of ScannerImageAcquirer and reuse the code from drivers
//       [x] #4 a decorator to adjust the image (sizeScale, grayScale, TiffToPNG)
public class ImageAcquirerClient {

	private static int width = 640;

	private static int height = 480;

	public ImageData getImageFromScannerAndSave() {

		ScannerImageAcquirerBuilder builder = new ScannerImageAcquirerBuilder();
		ScannerImageAcquirer imageAcquirer = builder
				.withScale(width, height)
				.withGrayScale()
				.withPNGConvertion()
				.withPersistence(this.getFileNameToSave())
				.build();

		return imageAcquirer.getImagesFromScanner();

	}

	private String getFileNameToSave() {
		return "/data/images/1.png";
	}

}
