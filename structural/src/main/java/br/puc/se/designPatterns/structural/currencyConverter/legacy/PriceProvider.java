package br.puc.se.designPatterns.structural.currencyConverter.legacy;

public interface PriceProvider {

	float getConvertionFactor(String currencyName, String targetCurrency);

	
	
}
