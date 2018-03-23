package com.util.sendcloud.sdk.model;

import com.util.sendcloud.sdk.exception.ReceiverException;

public interface Receiver {
	public boolean useAddressList();
	
	public boolean validate() throws ReceiverException;
	
	public String toString();
}