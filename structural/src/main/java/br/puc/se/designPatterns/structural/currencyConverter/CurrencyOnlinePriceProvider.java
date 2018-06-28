package br.puc.se.designPatterns.structural.currencyConverter;

public interface CurrencyOnlinePriceProvider {

	public float onlinePrice(String from, String to);
	
}
