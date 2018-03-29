package jnshu.taskseven.controller;

import jnshu.taskseven.model.Student;
import jnshu.taskseven.service.AttestSmsService;
import jnshu.taskseven.service.EmailService;
import jnshu.taskseven.service.ReadFileService;
import jnshu.taskseven.service.StudentService;
import jnshu.taskseven.util.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-10-31
 * @Time: 下午 9:49
 * Description:
 **/

@Controller
public class UserInformationController {

    // 定义允许上传的文件扩展名

    @Autowired
    ReadFileService readFileService;

    @Autowired
    AttestSmsService attestSmsService;

    @Autowired
    EmailService emailService;

    @Autowired
    StudentService studentService;

    public static String[] Ext_Name = new String[]{
            "gif","jpg","jpeg","png","bmp","swf","flv",
            "mp3","wav","wma","wmv","mid", "avi","mpg",
            "asf","rm","rmvb","doc","docx","xls","xlsx","ppt","htm","html","txt","zip","rar","gz","bz2"};

    public static String[] Picture_Ext_Name = new String[]{
            "gif","jpg","jpeg","png","bmp","tiff","pcx","tga",
            "exif","fpx","svg","psd","cdr","pcd","dxf","ufo",
            "eps","ai","raw","WMF"};


    private static Logger loggerUplFilSer = LoggerFactory.getLogger(UserInformationController.class);


    //图片上传后台
    @RequestMapping(value = "/a/u/backstage/file/picture" , method = RequestMethod.POST)
    public void uploadFiles(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        loggerUplFilSer.info("开始上传");
        OutputStream out = response.getOutputStream();


//        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
//        String savePath =request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
//        File file = new File(savePath);
//        /*判断上传文件的保存目录是否存在
//         * file.exists()即判断你指定的路径或着指定的目录文件是否已经存在。
//         * java.io.File.isDirectory() 检查表示此抽象路径名的文件是否是一个目录。
//         */
//
//        if(!file.exists() && !file.isDirectory()){
//            loggerUplFilSer.info(savePath +" 该目录不存在");
//            file.mkdir();
//        }
//
//        //使用Apache文件上传组件处理文件上传步骤：
//        //1、创建一个DiskFileItemFactory工厂
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        //2. 创建一个文件上传解析器
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        //监听文件上传进度
//        upload.setProgressListener(new ProgressListener(){
//            public void update(long pBytesRead, long pContentLength, int arg2) {
//                loggerUplFilSer.info("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
//            }
//        });
//
//
//        //解决上传文件名的中文乱码问题
//        upload.setHeaderEncoding("UTF-8");
//        //设置内存的临界值为500K
//        factory.setSizeThreshold(1024 * 500);
//        //设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
//        upload.setFileSizeMax(1024*1024);
//        //设置上传的文件总的大小不能超过5M
//        upload.setSizeMax(1024 * 1024 * 5);
//
//        //3. 判断提交上来的数据是否是上传表单
//        if(!ServletFileUpload.isMultipartContent(request)){
//            return;
//        }
//        try {
//            //使用ServletFileUpload解析器解析上传数据，
//            // 解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
//            List<FileItem> list = upload.parseRequest(request);
//            for (FileItem item : list){
//                /*isFormField方法用来判断FileItem对象里面封装的数据是一个普通文本表单字段，
//                 *还是一个文件表单字段。如果是普通文本表单字段，返回一个true否则返回一个false。
//                 *因此可以用该方法判断是否是普通表单域还是文件上传表单域。
//                 * 如果fileitem中封装的是普通输入项的数据
//                 */
//                if(item.isFormField()){
//                    //getFieldName方法用来返回表单标签的name属性的值。
//                    String name = item.getFieldName();
//                    //解决普通输入项的数据的中文乱码问题
//                    String value = item.getString("UTF-8");
//                    loggerUplFilSer.info(name + " = "+ value);
//                }
//                //如果fileitem中封装的是上传文件
//                else {
//
//                    //得到上传的文件名称
//                    String fileName = item.getName();
//                    loggerUplFilSer.info("file name : " + fileName);
//
//                    /*
//                     * String.trim()去掉字符串两端的多余的空格以及：
//                     *('/t', '/n', '/v', '/f', '/r', ' ', '/x0085', '/x00a0',
//                     *  ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
//                     *  ' ', '?', '/u2028', '/u2029', ' ', '?')
//                     */
//                    if(fileName==null || fileName.trim().equals("")){
//                        continue;
//                    }
//                    /*
//                     *注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，
//                     * 如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
//                     * 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
//                     */
//                    //截取掉从首字母起长度为filename.lastIndexOf("\\")+1的字符串，将剩余字符串赋值给filename ；
//                    fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
//
//                    // 得到上传文件的扩展名
//                    String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
//
//                    loggerUplFilSer.info("fileExt: " + fileExt);
//                    int sign = 0;
//                    // 检查扩展名
//                    for(String str : Picture_Ext_Name){
//                        //检查字符串(参数parameterValue)是否包含字符串(参数str), 忽略大小写.返回类型boolean
//                        if(StringUtils.containsIgnoreCase(fileExt,str)){
//                            sign = 1;
//                        }
//                    }
//                    if(sign == 0){
//                        out.write("<script charset=\"utf-8\" language='javaScript'> alert('图片类型非法');</script>".getBytes());
//                        loggerUplFilSer.info("上传文件扩展名是不允许的扩展名：" + fileExt);
//                        return;
//                    }
//
//                    //重新给文件命名
//                    String user = CookieUtils.getCookie(request,"user");
//                    String time = String.valueOf(System.currentTimeMillis());
//                    int random = ThreadLocalRandom.current().nextInt(999999);
//
//                    /* 命名规则： u:username   time: 当前时间戳   r: 随机6位数   f: 文件名*/
//                    fileName = "u_" + user + "-t_" + time + "-r_" + random + "-f_" + fileName;
//                    loggerUplFilSer.info("new  file name : " + fileName);
//
//                    //获取item中的上传文件的输入流
//                    InputStream in = item.getInputStream();
//
//                    //创建一个缓冲区
//                    byte buffer[] = new byte[1024];
//                    //判断输入流中的数据是否已经读完
//                    int len = 0;
//                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
//                    while((len=in.read(buffer))>0){
//                        //创建一个文件输出流
//                        FileOutputStream outFile = new FileOutputStream(savePath + "\\" + fileName);
//                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
//                        outFile.write(buffer, 0, len);
//                        //关闭输出流
//                        outFile.close();
//                    }
//
//                    //关闭输入流
//                    in.close();
//                    //删除处理文件上传时生成的临时文件
//                    item.delete();
//
//                }
//            }
//        }catch (FileUploadBase.FileSizeLimitExceededException e) {
//            e.printStackTrace();
//            out.write("<script charset=\"utf-8\" language='javaScript'> alert('单个文件超出最大值！！！');</script>".getBytes());
//            return;
//        }
//        catch (FileUploadBase.SizeLimitExceededException e) {
//            e.printStackTrace();
//            out.write("<script charset=\"utf-8\" language='javaScript'> alert('上传文件的总的大小超出限制的最大值！！！');</script>".getBytes());
//            return;
//        }
//        catch (Exception e){
//            out.write("<script charset=\"utf-8\" language='javaScript'> alert('文件上传失败！');</script>".getBytes());
//            e.printStackTrace();
//            return;
//        }
//        out.write("<script charset=\"utf-8\" language='javaScript'> alert('文件上传成功! ');</script>".getBytes());
//        request.getRequestDispatcher("/.jsp").forward(request, response);


        String message = readFileService.readPicture(request);

        loggerUplFilSer.info("message: "+ message);
        //查看在message里的第几个字符起为"u_" ,下标从0开始，如果没有就返回-1
        int sign = message.indexOf("u_");
        loggerUplFilSer.info("sign: " + sign);
        if(sign != -1){
            Student student = new Student();
            //从cookie获取到用户名
            String user = CookieUtils.getCookie(request,"user");
            student.setUser(user);
            //生成图片链接
            String imageURL = "http://xiuzhenyuan.oss-cn-beijing.aliyuncs.com/image/" + message + "/xiuzhenyuan_student_picture";
            student.setImages(imageURL);
            loggerUplFilSer.info("imageURL: " +imageURL);
            int i =  studentService.updateStudentUserPicturePhoneEmail(student);
            loggerUplFilSer.info("更改的数据量 ： "+ i);
            out.write(("<script charset=\"utf-8\" language='javaScript'> alert('文件上传成功');</script>").getBytes());
        }
        else{
            out.write(("<script charset=\"utf-8\" language='javaScript'> alert('" +message + "');</script>").getBytes());
        }
    }

    //获取手机验证码后台
    @RequestMapping(value = "/a/u/backstage/information/phone" ,method =  RequestMethod.POST)
    public void phoneNumber(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String phoneNumber = null;
        String message = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        OutputStream out = response.getOutputStream();
        phoneNumber = request.getParameter("phone");
        phoneNumber = phoneNumber.replaceAll(" ", "");
        loggerUplFilSer.info("phoneNumber: "+ phoneNumber);
        Integer length = phoneNumber.length();
        loggerUplFilSer.info("phoneNumber length: "+ length);
        HttpSession session =request.getSession();
        if(phoneNumber !=null && length == 11){
            message = attestSmsService.sendVerificationSMS(phoneNumber);
            loggerUplFilSer.info("message: "+ message);
        }
        else {
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('手机号输入错误！');</script>".getBytes());
            return;
        }
        if(message != null){
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('获取验证码成功！有效期为5分钟');</script>".getBytes());
            session.setAttribute("phoneNumber", phoneNumber);
        }
        else {
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证码获取失败');</script>".getBytes());
        }
        return;
    }


    //验证验证码
    @RequestMapping(value = "/a/u/backstage/information/sms" ,method =  RequestMethod.POST)
    public void phoneSms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String verificationCode = "";
        String smsNumber = "";
        String phoneNumber = "";

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        OutputStream out = response.getOutputStream();
        HttpSession session =request.getSession();
        verificationCode = request.getParameter("verificationCode");
        verificationCode = verificationCode.replaceAll(" ", "");
        if(verificationCode == ""){
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证码不能为空');</script>".getBytes());
            return;
        }
        verificationCode =verificationCode.replaceAll(" ", "");
        loggerUplFilSer.info("verificationCode: "+ verificationCode);

        if(verificationCode != "" && verificationCode.length() == 6){
            phoneNumber = (String) session.getAttribute("phoneNumber");
            loggerUplFilSer.info("phoneNumber: "+ phoneNumber);
        }
        else{
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证码错误');</script>".getBytes());
            return;
        }

        if(phoneNumber != ""){
            smsNumber = attestSmsService.getCachePhoneNumber(phoneNumber);
            loggerUplFilSer.info("smsNumber: "+ smsNumber);

        }
        else {
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('手机号不能为空');</script>".getBytes());
            return;
        }
        if( smsNumber == null ){
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证码已经失效');</script>".getBytes());
            return;
        }
        if(smsNumber.equals(verificationCode)){
            Student student = new Student();
            student.setPhone(phoneNumber);
            String user = CookieUtils.getCookie(request,"user");
            student.setUser(user);
            loggerUplFilSer.info("user: " + user + "phone: "+ phoneNumber);
            Integer sgin =  studentService.updateStudentUserPicturePhoneEmail(student);
            loggerUplFilSer.info("是否更新成功： "+ sgin);
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证成功');</script>".getBytes());
        }
        else {
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证失败');</script>".getBytes());
        }
        return;

    }


    @RequestMapping(value = "/a/u/backstage/information/email" , method =  RequestMethod.POST)
    public void acquisitionEmail(HttpServletRequest request, HttpServletResponse response)  throws  IOException{
        String email = request.getParameter("email");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        OutputStream out = response.getOutputStream();
        email = email.replaceAll(" ", "");
        String user = CookieUtils.getCookie(request,"user");
        HttpSession session =request.getSession();
        final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        if(email == "" || email == null){
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('E-mail不能为空！');</script>".getBytes());
            return;
        }
        if (Pattern.matches(REGEX_EMAIL, email)){
            int message =  emailService.verificationEmail(email,user).length();
            loggerUplFilSer.info("message: "+ message);
            if(message == 6){
                out.write(" <script charset=\"utf-8\" language='javaScript'> alert('邮件已经发送！');</script>".getBytes());
                session.setAttribute("email",email);
                return;
            }
            else {
                out.write(" <script charset=\"utf-8\" language='javaScript'> alert('邮件发送失败！');</script>".getBytes());
                return;
            }
        }
        else {
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('邮件格式错误！');</script>".getBytes());
        }
        return;
    }

    @RequestMapping(value = "/a/u/backstage/information/email/verification" , method =  RequestMethod.POST)
    public void verificationEmail(HttpServletRequest request, HttpServletResponse response)  throws  IOException{
        String verificationCode = "";
        String number = "";
        String email = "";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        OutputStream out = response.getOutputStream();
        HttpSession session =request.getSession();
        verificationCode = request.getParameter("verificationCode");
        verificationCode = verificationCode.replaceAll(" ", "");
        if(verificationCode == "" || verificationCode == null){
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证码不能为空！');</script>".getBytes());
            return;
        }
        if(verificationCode.length() == 6){
            email  = (String) session.getAttribute("email");
            number = emailService.getCacheEmailNumber(email);
            if(number.equals(verificationCode)){
                Student student = new Student();
                student.setUserEmail(email);
                String user = CookieUtils.getCookie(request,"user");
                student.setUser(user);
                Integer sgin = studentService.updateStudentUserPicturePhoneEmail(student);
                loggerUplFilSer.info("是否更新成功： "+ sgin);
                out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证成功！');</script>".getBytes());
                return;
            }
        }
        else {
            out.write(" <script charset=\"utf-8\" language='javaScript'> alert('验证码错误！');</script>".getBytes());
            return;
        }
    }
}