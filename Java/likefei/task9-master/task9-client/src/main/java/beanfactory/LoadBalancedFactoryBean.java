package beanfactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class LoadBalancedFactoryBean implements FactoryBean, MethodInterceptor, InitializingBean {

	private Class serviceInterface;
	
	private List serviceProxyList = new ArrayList();
	
	private Object serviceProxy;
	
	private boolean stateful = false;
	
	private BalanceStrategy balanceStrategy;
	
	public LoadBalancedFactoryBean(){	
		
	}
	
	public BalanceStrategy getBalanceStrategy() {
		return balanceStrategy;
	}

	public void setBalanceStrategy(BalanceStrategy balanceStrategy) {
		this.balanceStrategy = balanceStrategy;
	}
		
	/**
	 * Set the interface of the service to access.
	 * The interface must be suitable for the particular service and remoting tool.
	 * <p>Typically required to be able to create a suitable service proxy,
	 * but can also be optional if the lookup returns a typed stub.
	 */
	public void setServiceInterface(Class serviceInterface) {
		if (serviceInterface != null && !serviceInterface.isInterface()) {
			throw new IllegalArgumentException("serviceInterface must be an interface");
		}
		this.serviceInterface = serviceInterface;
		
	}
		
	public void afterPropertiesSet() throws Exception {
		serviceProxy = ProxyFactory.getProxy(getServiceInterface(), this);
		
	}

	public Object getObject() throws Exception {
		
		return serviceProxy;
	}

	public Class getObjectType() {
		return this.getClass();
	}

	public boolean isSingleton() {
		return true;
	}
	
	public Object invoke(MethodInvocation invocation) throws Throwable {			
		
		// spread the call across all nodes before hitting the current
		balanceStrategy.increment(serviceProxyList);
		
		if (stateful){
			Iterator iter = serviceProxyList.iterator();
			
			while(iter.hasNext()){
				Object current = iter.next();	
				
				if (current == balanceStrategy.getCurrent()){
					continue;
				}
				Method methodToCall = serviceInterface.getMethod(invocation.getMethod().getName(), invocation.getMethod().getParameterTypes());
				methodToCall.invoke(current, invocation.getArguments());		
			}				
			
		}		
		Object current = balanceStrategy.getCurrent();
			
		Method methodToCall = serviceInterface.getMethod(invocation.getMethod().getName(), invocation.getMethod().getParameterTypes());
					
		return methodToCall.invoke(current, invocation.getArguments());		
		
	}

	public List getServiceProxyList() {
		return serviceProxyList;
	}

	public void setServiceProxyList(List serviceProxyList) {
		this.serviceProxyList = serviceProxyList;
	}

	public Class getServiceInterface() {
		return serviceInterface;
	}

	public boolean isStateful() {
		return stateful;
	}

	public void setStateful(boolean stateful) {
		this.stateful = stateful;
	}
	
	
}
