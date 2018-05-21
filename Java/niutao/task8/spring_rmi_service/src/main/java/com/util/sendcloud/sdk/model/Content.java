package com.util.sendcloud.sdk.model;

import com.util.sendcloud.sdk.exception.ContentException;

public interface Content {
	public boolean useTemplate();

	public boolean validate() throws ContentException;
}