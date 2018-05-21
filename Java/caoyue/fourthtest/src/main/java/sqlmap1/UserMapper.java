package sqlmap1;

import fourth.com.student;

public interface UserMapper {
//    public student findStudentById(int ID) throws Exception;
    public student findStudentByName(String name) throws Exception;
}
