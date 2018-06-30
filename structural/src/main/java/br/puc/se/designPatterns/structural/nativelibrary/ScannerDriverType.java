package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerDriver;

public enum ScannerDriverType {
	
	KODAK_LINUX("Linux", "Kodak"), 
	KODAK_WINDOWS("Windows", "Kodak"), 
	KODAK_MAC("Mac", "Kodak"), 
	CANNON_LINUX("Linux", "Cannon"), 
	CANNON_WINDOWS("Windows", "Cannon"), 
	CANNON_MAC("Mac", "Cannon");

	private String so;
	private String vendor;

	private ScannerDriverType(String so, String vendor) {
		this.so = so;
		this.vendor = vendor;
		
	}
	
	public static ScannerDriverType getBySOandVendor(String so, String vendor) {
		for (ScannerDriverType s : values()) {
			if (s.so.equalsIgnoreCase(so) && s.vendor.equalsIgnoreCase(vendor)) {
				return s;
			}
		}
		return null;
	}
	
	public ScannerDriver buildDriver() {
		String className = String.format("br.puc.se.designPatterns.structural.nativelibrary.drivers.so.%s%sScannerDriver", so, vendor);
		try {
			Class<?> loadClass = this.getClass().getClassLoader().loadClass(className);
			return (ScannerDriver) loadClass.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getSo() {
		return so;
	}
	
	public String getVendor() {
		return vendor;
	}

}
