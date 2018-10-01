package dao;

import Entity.Signup;

public interface signupDAO {
    //
    String FindSignupByID(Long id);
    int InsertSignup(Signup signup);
    int DeleteByName(String name);
    int UpdateByName(String name);
}
