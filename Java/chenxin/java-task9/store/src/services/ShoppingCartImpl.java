package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.tuscany.sca.data.collection.Entry;
import org.apache.tuscany.sca.data.collection.NotFoundException;
import org.osoa.sca.annotations.Init;
import org.osoa.sca.annotations.Scope;

@Scope("COMPOSITE")
public class ShoppingCartImpl implements Cart, Total {

	private Map<String, Item> cart;

	@Init
	public void init() {
		cart = new HashMap<String, Item>();
	}

	public Entry<String, Item>[] getAll() {
		@SuppressWarnings("unchecked")
		Entry<String, Item>[] entries = new Entry[cart.size()];
		int i = 0;
		for (Map.Entry<String, Item> e : cart.entrySet()) {
			entries[i++] = new Entry<String, Item>(e.getKey(), e.getValue());
		}
		return entries;
	}

	public Item get(String key) throws NotFoundException {
		Item item = cart.get(key);
		if (item == null) {
			throw new NotFoundException(key);
		} else {
			return item;
		}
	}

	public String post(String key, Item item) {
		if (key == null) {
			key = "cart-" + UUID.randomUUID().toString();
		}
		cart.put(key, item);
		return key;
	}

	public void put(String key, Item item) throws NotFoundException {
		if (!cart.containsKey(key)) {
			throw new NotFoundException(key);
		}
		cart.put(key, item);
	}

	public void delete(String key) throws NotFoundException {
		if (key == null || key.equals("")) {
			cart.clear();
		} else {
			Item item = cart.remove(key);
			if (item == null)
				throw new NotFoundException(key);
		}
	}

	@SuppressWarnings("unchecked")
	public Entry<String, Item>[] query(String queryString) {
		List<Entry<String, Item>> entries = new ArrayList<Entry<String, Item>>();
		if (queryString.startsWith("name=")) {
			String name = queryString.substring(5);
			for (Map.Entry<String, Item> e : cart.entrySet()) {
				Item item = e.getValue();
				if (item.getName().equals(name)) {
					entries.add(new Entry<String, Item>(e.getKey(), e
							.getValue()));
				}
			}
		}
		return entries.toArray(new Entry[entries.size()]);
	}

	public String getTotal() {
		double total = 0;
		String currencySymbol = "";
		if (!cart.isEmpty()) {
			Item item = cart.values().iterator().next();
			currencySymbol = item.getPrice().substring(0, 1);
		}
		for (Item item : cart.values()) {
			total += Double.valueOf(item.getPrice().substring(1));
		}
		return currencySymbol + String.valueOf(total);
	}
}