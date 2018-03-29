package jnshu.tasknine.filter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Administrator on 2017-10-05.
 */
public class InvalidCharacterFilter extends CharacterEncodingFilter {

    private static Logger loggerICF = LoggerFactory.getLogger(InvalidCharacterFilter.class);

    //需要过滤的字符
    public static String[] invalidCharacter = new String[]{

            "script","select","insert","document","window","function","rumen",
            "delete","update","prompt","alert","create","alter",
            "drop","iframe","link","where","replace","function","onabort",
            "onactivate","onafterprint","onafterupdate","onbeforeactivate",
            "onbeforecopy","onbeforecut","onbeforedeactivateonfocus",
            "onkeydown","onkeypress","onkeyup","onload",
            "expression","applet","layer","ilayeditfocus","onbeforepaste",
            "onbeforeprint","onbeforeunload","onbeforeupdate",
            "onblur","onbounce","oncellchange","oncontextmenu",
            "oncontrolselect","oncopy","oncut","ondataavailable",
            "ondatasetchanged","ondatasetcomplete","ondeactivate",
            "ondrag","ondrop","onerror","onfilterchange","onfinish","onhelp",
            "onlayoutcomplete","onlosecapture","onmouse","ote",
            "onpropertychange","onreadystatechange","onreset","onresize",
            "onresizeend","onresizestart","onrow","onscroll",
            "onselect","onstaronsubmit","onunload","IMgsrc","infarction"
    };

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

//        loggerICF.info("这是继承spring的过滤器");
        String parameterName = null;
        String parameterValue = null;
        //获取请求的参数

        /**
         * 来源：http://www.cnblogs.com/fsjohnhuang/p/4040785.html
         * @SuppressWarnings 作用：用于抑制编译器产生警告信息。
         * @SuppressWarnings("unchecked")  抑制单类型的警告
         * 其注解目标为类、字段、函数、函数入参、构造函数和函数的局部变量。
         */
//        @SuppressWarnings("unchecked")

        /**
         * 把request的数据放到Enumeration<String>里
         * request.getParameterNames()方法是将发送请求页面中form表单里所有具有name属性的表单对象获取(包括button).
         * 返回一个Enumeration类型的枚举.
         * 通过Enumeration的hasMoreElements()方法遍历.
         * 再由nextElement()方法获得枚举的值.此时的值是form表单中所有控件的name属性的值.
         */
        Enumeration<String> allParameter = request.getParameterNames();

        request.setAttribute("errorMessage","1");
        // allParameter.hasMoreElements()测试此枚举是否包含更多的元素。返回值为boolean
        while(allParameter.hasMoreElements()){
            //此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素,在这里是
            parameterName = allParameter.nextElement();
            parameterValue = request.getParameter(parameterName);
            if(parameterValue != null){
                for(String str : invalidCharacter){

                    //检查字符串(参数parameterValue)是否包含字符串(参数str), 忽略大小写.返回类型boolean
                    if(StringUtils.containsIgnoreCase(parameterValue,str)){

                        String url = request.getRequestURL().toString();
                        String requestUri = request.getRequestURI();
                        loggerICF.info("在这里说明有非法字符" + str);

                        /**
                         * (1)request.getRequestDispatcher()是请求转发，前后页面共享一个request ;
                         *    这个是在服务端运行的，对浏览器来说是透明的。
                         * (2)response.sendRedirect()是重新定向，前后页面不是一个request。而这个是在浏览器端运行的。
                         * (3)forward()是request中的参数继续传递，redirect()则是重新生成request了。
                         * (4)getRequestDispatcher是服务器内部跳转，地址栏信息不变，只能跳转到web应用内的网页。
                         *    sendRedirect是页面重定向，地址栏信息改变，可以跳转到任意网页。
                         */
                        request.setAttribute("errorMessage","非法字符" + str);
//                        loggerICF.info(request.getAttribute("errorMessage"));
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher(requestUri);
                        requestDispatcher.forward(request,response);
//                        response.setHeader("refresh", "0;url=" + url.substring(22,url.length()));
                        return;
                    }
                }
            }
        }
        super.doFilterInternal(request,response,filterChain);
    }
}
