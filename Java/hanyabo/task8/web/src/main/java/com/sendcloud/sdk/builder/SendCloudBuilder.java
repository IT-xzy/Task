package com.sendcloud.sdk.builder;

import com.sendcloud.sdk.config.Config;
import com.sendcloud.sdk.core.SendCloud;

public class SendCloudBuilder {

	public static SendCloud build() {
		SendCloud sc = new SendCloud();
		sc.setServer(Config.server);
		sc.setMailAPI(Config.send_api);
		sc.setTemplateAPI(Config.send_template_api);
		sc.setSmsAPI(Config.send_sms_api);
		sc.setVoiceAPI(Config.send_voice_api);
		return sc;
	}
}