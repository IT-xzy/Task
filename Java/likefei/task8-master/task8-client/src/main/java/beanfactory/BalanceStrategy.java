package beanfactory;

import java.util.Collection;

public interface BalanceStrategy {
	
	public abstract Object getCurrent();
	
	public abstract Object increment(Collection collection);
}
