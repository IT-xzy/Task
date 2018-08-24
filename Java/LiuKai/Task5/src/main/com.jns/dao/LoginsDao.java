package dao;

import pojo.Logins;

public interface LoginsDao {
  Logins findById(long id);

  boolean addLogin(Logins logins);

 void deleteAll();
}
