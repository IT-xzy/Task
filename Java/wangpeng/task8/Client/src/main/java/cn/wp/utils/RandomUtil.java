package cn.wp.utils;

import java.util.Random;

/**
 * @ClassName:RandomUtil @Description:生成随机数,根据随机数的不同, 调用不同的bean. @Author: WP @Date: 2019/6/20
 * 16:49 @Version: 1.0
 */
public class RandomUtil {

  public static int randomCode() {
    return new Random().nextInt(2);
  }
}
