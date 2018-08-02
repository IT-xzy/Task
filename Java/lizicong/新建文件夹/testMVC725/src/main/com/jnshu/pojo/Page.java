package main.com.jnshu.pojo;

public class Page {
    private Integer index;

    public Page() {
        super();
    }

    public Page(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Page{" +
                "index=" + index +
                '}';
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
