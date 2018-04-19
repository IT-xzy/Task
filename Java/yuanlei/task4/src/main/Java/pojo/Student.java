package pojo;

public class Student {
    private int id;
    private String name;
    private String  declaration;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }
    public String toString(){
        return  "student{"+"id="+id+",name="+name+",declaration="+declaration+"}";
    }
}
