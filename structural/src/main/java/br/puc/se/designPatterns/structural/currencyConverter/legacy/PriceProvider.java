package br.puc.se.designPatterns.structural.currencyConverter.legacy;

@FunctionalInterface
public interface PriceProvider {

	float getConvertionFactor(String databasename, String currencyName, String targetCurrency);
	
}
