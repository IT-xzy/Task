package com.ev.utils;

import com.ev.model.Student;

public class StudentCheck {

    public boolean checkStudent(Student student) {

        if (student.getName().length() > 8)
            return false;
        if (student.getGender().length() > 5)
            return false;
        if (student.getAge() > 100)
            return false;
        if (student.getQq().length() > 13)
            return false;
        if (student.getOccupation().length() > 10)
            return false;
        if (student.getSchool().length() > 20)
            return false;
        if (student.getNumber().length() > 20)
            return false;
        if (student.getDailyUrl().length() > 100)
            return false;
        if (student.getDeclaration().length() > 50)
            return false;
        if (student.getConsoler().length() > 20)
            return false;
        return true;

    }

}


