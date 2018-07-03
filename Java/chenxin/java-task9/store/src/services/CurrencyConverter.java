package services;

import org.osoa.sca.annotations.Remotable;

@Remotable
public interface CurrencyConverter {
	public double getConversion(String fromCurrencyCode, String toCurrencyCode, double amount);
	
	public String getCurrencySymbol(String currencyCode);
}
