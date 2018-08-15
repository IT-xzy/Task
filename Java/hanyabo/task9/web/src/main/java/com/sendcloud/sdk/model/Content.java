package com.sendcloud.sdk.model;

import com.sendcloud.sdk.exception.ContentException;

public interface Content {
	public boolean useTemplate();

	public boolean validate() throws ContentException;
}