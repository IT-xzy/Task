package dao;

public interface UserMapper {
	/**
	 * 保存照片的路径
	 * @param userName 要保存照片的用户
	 * @param pictureDir 要保存的照片路径
	 */
	void updateUserPictureByName(String userName, String pictureDir);
}
