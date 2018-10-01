package strategy;

import java.io.InputStream;

public interface Strategy {
	public void doOperation(String key, InputStream inputStream);
}
