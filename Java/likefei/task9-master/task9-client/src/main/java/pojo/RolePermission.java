package pojo;

import java.io.Serializable;

public class RolePermission implements Serializable{
    //Role ID
    private Long rid;
    //Permission ID
    private Long pid;

    public RolePermission() {
    }

    public RolePermission(Long uid, Long pid) {
        this.rid = uid;
        this.pid = pid;
    }

    public Long getUid() {
        return rid;
    }

    public void setUid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePermission that = (RolePermission) o;

        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;
        if (rid != null ? !rid.equals(that.rid) : that.rid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid != null ? rid.hashCode() : 0;
        result = 31 * result + (pid!= null ? pid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "rid=" + rid +
                ", pid=" + pid +
                '}';
    }
}
