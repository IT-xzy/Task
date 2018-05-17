package pojo;

import java.io.Serializable;

public class UserRole implements Serializable{
    //URolePermissionMapper ID
    private Long uid;
    //Role ID
    private Long rid;

    public UserRole() {
    }

    public UserRole(Long uid, Long rid) {
        this.uid = uid;
        this.rid = rid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (rid != null ? !rid.equals(userRole.rid) : userRole.rid != null) return false;
        if (uid != null ? !uid.equals(userRole.uid) : userRole.uid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (rid != null ? rid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "uid=" + uid +
                ", rid=" + rid +
                '}';
    }
}
