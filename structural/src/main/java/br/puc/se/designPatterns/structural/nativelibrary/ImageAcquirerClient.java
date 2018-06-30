package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;

// Refactor this to avoid those lot of replicated code
// Tips: #1 a controller / facade to abstract the image module
//       #2 a factory to create the right imageAcquirer
//       #3 a bridge to avoid 6 subclasses of ScannerImageAcquirer and reuse the code from drivers
//       #4 a decorator to adjust the image (sizeScale, grayScale, TiffToPNG)
public class ImageAcquirerClient {

	private static int width = 640;
	
	private static int height = 480;
	
	public ImageData getImageFromScannerAndSave() {
		ScannerImageAcquirerFactory factory = new ScannerImageAcquirerFactory();
		
		ScannerImageAcquirer imageAcquirer = factory.createImageAcquirer();
		
		ImageData source = imageAcquirer.getImagesFromScanner();
		ImageData scaled = this.scaleImage(this.toGrayScale(this.convertFromTIFFToPNG(source)), width, height);
		return this.saveImageOnDatabase(scaled, this.getFileNameToSave());
	}
	
	private ImageData convertFromTIFFToPNG(ImageData source) {
		return source.convertToPNG();
	}

	private ImageData saveImageOnDatabase(ImageData scaled, String fileNameToSave) {
		return scaled.saveToFile(fileNameToSave);
	}

	private String getFileNameToSave() {
		return "/data/images/1.png";
	}

	public ImageData toGrayScale(ImageData source) {
		return source.toGrayScale();
	}
	
	public ImageData scaleImage(ImageData source, int width, int height) {
		return source.scale(width, height);
	}
	
}
