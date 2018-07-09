package com.sendcloud.sdk.model;

import com.sendcloud.sdk.exception.VoiceException;
import org.apache.commons.lang.StringUtils;

public class SendCloudVoice {

	public String phone;
	public String code;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean validate() throws VoiceException {
		if (StringUtils.isEmpty(phone))
			throw new VoiceException("收信人为空");
		if (StringUtils.isEmpty(code))
			throw new VoiceException("验证码为空");
		return true;

	}
}