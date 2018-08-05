package com.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class OcT  extends Occupation{
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
