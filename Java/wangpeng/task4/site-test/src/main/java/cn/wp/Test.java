package cn.wp;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * @ClassName: cn.wp.Test
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/18 14:45
 * @Version: 1.0
 */
public class Test extends TagSupport {

    private PageContext pageContext;

    @Override
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    @Override
    public int doStartTag() throws JspException {

        try {
            pageContext.getResponse().getWriter().write("这是自定义C标签");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return super.doStartTag();
    }
}
