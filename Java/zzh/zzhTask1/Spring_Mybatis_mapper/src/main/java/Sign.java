public class Sign {
    private int id;
    private String name;
    private String city;

    @Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
