package cn.summerwaves.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Data
public class Man {
    private String name;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Man)) return false;
        if (!super.equals(o)) return false;
        Man man = (Man) o;
        return Objects.equals(getName(), man.getName()) &&
                Objects.equals(getPassword(), man.getPassword());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getName(), getPassword());
    }
}
