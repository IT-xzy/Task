package pojo;

/**
 * @author suger
 * @date 2018-09-13
 */
public class User {

    private Long userId;
    private String userName;
    private String qq;
    private String profession;
    private String startTime;
    private String graduatedFrom;
    private int onlineId;
    private String dailyLink;
    private String wish;
    private String counselor;
    private String way;
    private Long createAt;
    private Long updateAt;

    public User() {
    }

    public User(String userName, String qq, String profession, String startTime, String graduatedFrom, int onlineId, String dailyLink, String wish, String counselor, String way, Long createAt, Long updateAt) {
        this.userName = userName;
        this.qq = qq;
        this.profession = profession;
        this.startTime = startTime;
        this.graduatedFrom = graduatedFrom;
        this.onlineId = onlineId;
        this.dailyLink = dailyLink;
        this.wish = wish;
        this.counselor = counselor;
        this.way = way;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getGraduatedFrom() {
        return graduatedFrom;
    }

    public void setGraduatedFrom(String graduatedFrom) {
        this.graduatedFrom = graduatedFrom;
    }

    public int getOnlineId() {
        return onlineId;
    }

    public void setOnlineId(int onlineId) {
        this.onlineId = onlineId;
    }

    public String getDailyLink() {
        return dailyLink;
    }

    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getCounselor() {
        return counselor;
    }

    public void setCounselor(String counselor) {
        this.counselor = counselor;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("userId=").append(userId);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", qq='").append(qq).append('\'');
        sb.append(", profession='").append(profession).append('\'');
        sb.append(", startTime='").append(startTime).append('\'');
        sb.append(", graduatedFrom='").append(graduatedFrom).append('\'');
        sb.append(", onlineId=").append(onlineId);
        sb.append(", dailyLink='").append(dailyLink).append('\'');
        sb.append(", wish='").append(wish).append('\'');
        sb.append(", counselor='").append(counselor).append('\'');
        sb.append(", way='").append(way).append('\'');
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append('}');
        return sb.toString();
    }
}
