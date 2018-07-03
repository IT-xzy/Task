package services;

import org.apache.tuscany.sca.data.collection.Collection;
import org.osoa.sca.annotations.Remotable;

@Remotable
public interface Cart extends Collection<String, Item> {
	
}
