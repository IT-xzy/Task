package mybatis.po;
import java.io.Serializable;

public class User implements Serializable{
    private int id;
    private String name;
    private String emp;
    private Double salary;

    public User(){}
        public User(int id,String name,String emp,Double salary){
        super();
        this.id=id;
        this.name=name;
        this.emp=name;
        this.salary=salary;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmp() {
        return emp;
    }

    public void setEmp(String emp) {
        this.emp = emp;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emp='" + emp + '\'' +
                ", salary=" + salary +
                '}';
    }
}
