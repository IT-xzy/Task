package com.mutesaid.utils;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

public class SendMsgUtil extends CCPRestSmsSDK {
    public SendMsgUtil(String SERVER_IP, String SERVER_PORT,
                       String ACCOUNT_SID, String ACCOUNT_TOKEN, String App_ID) {
        super.init(SERVER_IP, SERVER_PORT);
        super.setAccount(ACCOUNT_SID, ACCOUNT_TOKEN);
        super.App_ID = App_ID;
    }
}
