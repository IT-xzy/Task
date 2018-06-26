package com.jnshu.service;

import org.oasisopen.sca.annotation.Remotable;

@Remotable
public interface ServiceSMS {
    Boolean sendSMS(String telePhone, String SessionId);
}
