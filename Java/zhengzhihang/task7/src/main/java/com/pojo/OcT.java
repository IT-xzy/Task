package com.pojo;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class OcT  extends Occupation implements Serializable {
    private static final long serialVersionUID = -5809782578272943999L;
    private int courseSum;

    @Override
    public String toString() {
        return "OcT{" +
                "id=" + super.getId() +
                ", career='" + super.getCareer() + '\'' +
                ", introduction='" + super.getIntroduction() + '\'' +
                ",courseSum=" + courseSum +'\'' +
                ", pic='" + super.getPic() + '\'' +
                ", threshold=" + super.getThreshold() +
                ", complexity=" + super.getComplexity() +
                ", growthCycle='" + super.getGrowthCycle() + '\'' +
                ", requirement='" + super.getRequirement() + '\'' +
                ", skillRelated='" + super.getSkillRelated()+ '\'' +
                ", eSalary='" + super.geteSalary()+ '\'' +
                ", mSalary='" + super.getmSalary() + '\'' +
                ", lSalary='" + super.getlSalary() + '\'' +
                '}'+"\n";
    }

    public int getCourseSum() {
        return courseSum;
    }

    public void setCourseSum(int courseSum) {
        this.courseSum = courseSum;
    }
}
