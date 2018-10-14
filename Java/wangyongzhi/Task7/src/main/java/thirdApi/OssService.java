package thirdApi;

public interface OssService {

    public void uploadFile(String name, String localFile);

    public Boolean isExist(String objectName);

    public void deleteImage(String objectName);

    public String getUrl();
}
