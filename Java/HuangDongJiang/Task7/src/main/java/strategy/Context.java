package strategy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.InputStream;

public class Context {
	private Log log = LogFactory.getLog(Context.class);
	private Strategy strategy;
	public Context (Strategy strategy){
		this.strategy = strategy;
	}
	public void executeStrategy(String key, InputStream inputStream){
		log.info("策略模式执行前。。。");
		strategy.doOperation(key, inputStream);
		log.info("策略模式生效。。。");
	}
}
