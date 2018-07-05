package services;

import java.util.ArrayList;
import java.util.List;

import org.osoa.sca.annotations.Init;
import org.osoa.sca.annotations.Property;
import org.osoa.sca.annotations.Reference;

public class CatalogImpl implements Catalog {
	@Property
	public String currencyCode = "USD";
	@Reference
	public CurrencyConverter currencyConverter;
	
	private List<Item> catalog = new ArrayList<Item>();

	@Init
	public void init() {
		String currencySymbol = currencyConverter
				.getCurrencySymbol(currencyCode);
		catalog.add(new Item("Apple", currencySymbol
				+ currencyConverter.getConversion("USD", currencyCode, 2.99)));
		catalog.add(new Item("Orange", currencySymbol
				+ currencyConverter.getConversion("USD", currencyCode, 3.55)));
		catalog.add(new Item("Pear", currencySymbol
				+ currencyConverter.getConversion("USD", currencyCode, 1.55)));
	}
	@Override
	public Item[] get() {
		// TODO Auto-generated method stub
		Item[] catalogArray = new Item[catalog.size()];
		catalog.toArray(catalogArray);
		return catalogArray;
	}
	
}
