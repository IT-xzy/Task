package service;

import pojo.Logins;

public interface LoginService {
    Logins findById(long id);

    boolean addLogin(Logins logins);
}
