package br.puc.se.designPatterns.structural.currencyConverter.legacy;

public class LegacyCurrencyConverter {
	
	public float convert(PriceProvider provider, float value, String sourceCurrency, String targetCurrency) {
		float factor = provider.getConvertionFactor(sourceCurrency, targetCurrency);
		return value * factor;
	}

}
