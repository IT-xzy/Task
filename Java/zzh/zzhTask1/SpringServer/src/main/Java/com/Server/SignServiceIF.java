package com.Server;

import com.Dao.Sign;

public interface SignServiceIF {
    public Sign checkUserById(int id);
    public Sign checkUserByName(String name);
    public int puttUser(Sign user);
    public int cutUserById(int id);
    public int replayUserById(Sign user);
    public int cutUserByName(String name);
}
