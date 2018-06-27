package beanfactory;

import java.util.Collection;
import java.util.Iterator;

public class RoundRobinStrategy implements BalanceStrategy {

	private Iterator currentIterator;
	private Object current;
	
	public RoundRobinStrategy(){
		
	}
	
	public Object getCurrent() {
		return current;
	}

	public Object increment(Collection collection) {
		if (currentIterator == null){
			currentIterator = collection.iterator();
		}
		if (currentIterator.hasNext()){
			current = currentIterator.next();
		}else{
			currentIterator = collection.iterator();
		}
		
		return current;
	}

}
