package com.service.thirdParty;

import com.model.Code;
import com.service.BaseService;

public interface TelService extends BaseService {

    public boolean sendNote(String tel, String rand_Code);
    public boolean checkRandCode(String rand_Code, long tel);
    public boolean sendRandCode(Code code, String rand_Code);
    public Code checkTelSum(long tel);
    public String getRangCode();
}
