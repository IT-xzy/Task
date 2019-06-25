package cn.wp.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @ClassName: cn.DateTag
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/18 14:45
 * @Version: 1.0
 */
public class DateTag extends TagSupport {

    private Long value;

    /**
     * 重写TagSupport的doStartTag方法，转换时间的数据类型
     */
    @Override
    public int doStartTag() throws JspException {
// 设置时间格式，通过simpleDateFormat的format方法转换时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//转换时间格式
        String s = dateFormat.format(System.currentTimeMillis());
        try {
//            将转化格式的时间写入value
            pageContext.getOut().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    /**
     * set方法,设置值
     */
    public void setValue(Long value) {
        this.value = value;
    }

}
