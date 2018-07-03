package services;

public class CurrencyConverterImpl implements CurrencyConverter {

	@Override
	public double getConversion(String fromCurrencyCode, String toCurrencyCode, double amount) {
		// TODO Auto-generated method stub
		if(toCurrencyCode.equals("USD"))
			return amount;
		else if(toCurrencyCode.equals("EUR"))
			return ((double)Math.round(amount * 0.7256 * 100)) /100;
		return 0;
	}

	@Override
	public String getCurrencySymbol(String currencyCode) {
		// TODO Auto-generated method stub
		if (currencyCode.equals("USD"))
			return "$";
		else if (currencyCode.equals("EUR"))
			return "E"; //"â‚¬";
		return "?";
	}

}
