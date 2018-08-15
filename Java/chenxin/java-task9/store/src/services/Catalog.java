package services;

import org.osoa.sca.annotations.Remotable;

@Remotable
public interface Catalog {
	Item[] get();
}
