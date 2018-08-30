package yxpTask6.pojo;


public class Amount {

  private long amountId;
  private long createAt;
  private long updateAt;
  private long amountOnline;
  private long amountGraduation;

  @Override
  public String toString() {
    return "AmountDao{" +
            "amountId=" + amountId +
            ", createAt=" + createAt +
            ", updateAt=" + updateAt +
            ", amountOnline=" + amountOnline +
            ", amountGraduation=" + amountGraduation +
            '}';
  }

  public long getAmountId() {
    return amountId;
  }

  public void setAmountId(long amountId) {
    this.amountId = amountId;
  }


  public long getCreateAt() {
    return createAt;
  }

  public void setCreateAt(long createAt) {
    this.createAt = createAt;
  }


  public long getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(long updateAt) {
    this.updateAt = updateAt;
  }


  public long getAmountOnline() {
    return amountOnline;
  }

  public void setAmountOnline(long amountOnline) {
    this.amountOnline = amountOnline;
  }


  public long getAmountGraduation() {
    return amountGraduation;
  }

  public void setAmountGraduation(long amountGraduation) {
    this.amountGraduation = amountGraduation;
  }

}
