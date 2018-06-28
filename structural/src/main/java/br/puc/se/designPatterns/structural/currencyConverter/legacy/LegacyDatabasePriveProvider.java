package br.puc.se.designPatterns.structural.currencyConverter.legacy;

public class LegacyDatabasePriveProvider implements PriceProvider {

	public float getConvertionFactor(String source, String target) {
		String urlToConvert = String.format("http://free.currencyconverterapi.com/api/v5/convert?q=%s_%s&compact=y", source, target);
		float factor = this.connectAndGetFactor(urlToConvert);
		return factor;
	}

	private float connectAndGetFactor(String urlToConvert) {
		//mocking the connecting and factor extraction
		return 1.5f;
	}

}
