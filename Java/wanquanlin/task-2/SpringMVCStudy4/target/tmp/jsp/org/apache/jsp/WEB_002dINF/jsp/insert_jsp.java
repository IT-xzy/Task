package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <title>显示信息进行修改</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("添加：\r\n");
      out.write("<br><form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/user/student\" method=\"post\" align=\"center\">\r\n");
      out.write("    姓名:<br><input type=\"text\" name=\"name\" >*<br>\r\n");
      out.write("    QQ:<br><input type=\"text\" name=\"QQ\" >*<br>\r\n");
      out.write("    onlineID:<br><input type=\"text\" name=\"onlineID\" >*<br>\r\n");
      out.write("    time_of_enrollment:<br><input type=\"date\" name=\"time_of_enrollment\" >*<br>\r\n");
      out.write("    graduate_institutions:<br><input type=\"text\" name=\"graduate_institutions\"><br>\r\n");
      out.write("    report_link:<br><input type=\"text\" name=\"report_link\"><br>\r\n");
      out.write("    swear:<br><input type=\"text\" name=\"swear\"><br>\r\n");
      out.write("    hearfrom:<br><input type=\"text\" name=\"hearfrom\"><br>\r\n");
      out.write("    <input type=\"submit\" value=\"提交\">带*为必填项\r\n");
      out.write("</form><br>\r\n");
      out.write("<a href=\"/index.jsp\">返回主页</a>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
