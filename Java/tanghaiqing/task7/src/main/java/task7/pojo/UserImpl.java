package task7.pojo;

import task7.util.OSSClientUtil;

public class UserImpl extends User {
    private String image;

    //public String getImage() {
    //    //if (image!=null){
    //    //    image= OSSClientUtil.getImgUrl(image);
    //    //    System.out.println(image);
    //    //}
    //    return image;
    //}


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "UserImpl{" +
                "image='" + image + '\'' +
                "} " + super.toString();
    }
}
