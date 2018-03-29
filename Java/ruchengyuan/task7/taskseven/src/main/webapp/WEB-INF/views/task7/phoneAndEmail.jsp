<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>jQuery Contact Form Plugin: FFForm</title>
    <link href="/statics/css/demo.css" rel="stylesheet" type="text/css">
    <script src="/statics/js/task7/jquery-1.10.2.min.js" type="text/javascript"></script>
    <!--Framework-->
    <script src="/statics/js/task7/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="/statics/js/task7/jquery-ui.js" type="text/javascript"></script>
    <!--End Framework-->
     <script src="/statics/js/task7/jquery.ffform.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#form').ffform({ animation: 'fade', submitButton: '#submit', validationIndicator: '#validation', errorIndicator: '#error', successIndicator: '#success', 'fields': [{ 'id': 'email', required: true, requiredMsg: 'E-Mail is required', type: 'email', validate: true, msg: 'Invalid E-Mail Address' }, { 'id': 'phone', required: false, type: 'custom', validate: false, msg: 'Invalid Phone #' }, { 'id': 'message', required: false, type: 'text', validate: false, msg: ''}] });
        });
    </script>
</head>
<body class="flipInX animated">
    <div class="demos-buttons">
        <h3>
            Demos
		</h3>
		</div>
    <section id="getintouch">
        <div class="container" style="border-bottom: 0;">
            <h1>
                <span>GET STARTED NOW — IT'S FREE!</span>
            </h1>
        </div>
        <div class="container">	
			<form class="contact" action="/a/u/backstage/information/email" method="post" id="E-Mailtext">
            <div class="row clearfix">
                <div class="lbl">
                    <label for="email">
                        E-Mail</label>
                </div>
                <div class="ctrl">
                    <input type="text" id="email" name="email" data-required="true" data-validation="email"
                        data-msg="Invalid E-Mail" placeholder="Ex: youremail@domain.com">
						<input type="submit" name="submit" id="submit1" class="submit" value="邮箱验证" style="display: inline-block;">
                </div>

                <input type="text" id="verificationEmail" name="verificationCode" data-required="true" data-validation="custom"
                       data-msg="Invalid Phone #" placeholder="Ex: 123456">
                <input  formaction="/a/u/backstage/information/email/verification" type="submit" name="submit" id="submit4" class="submit" value="验证" style="display: inline-block;">

            </div>
			</form>
			
			<form class="contact" action="/a/u/backstage/information/sms" method="post" id="phonetext">
            <div class="row clearfix">
                <div class="lbl">
                    <label for="email">
                        Phone</label>
                </div>
                <div class="ctrl">
                    <input type="text" id="phone" name="phone" data-required="true" data-validation="custom"
                        data-msg="Invalid Phone #" placeholder="Ex: 111-258-444">
                    <input formaction="/a/u/backstage/information/phone" type="submit" name="submit" id="submit3" class="submit" value="获取验证码" style="display: inline-block;">

                </div>
                <input type="text" id="verificationCode" name="verificationCode" data-required="true" data-validation="custom"
                       data-msg="Invalid Phone #" placeholder="Ex: 123456">
                <input  formaction="/a/u/backstage/information/sms" type="submit" name="submit" id="submit2" class="submit" value="验证" style="display: inline-block;">

            </div>
			
			</form>
            <div id="success">
                Your E-Mail has been sent successfully!</div>
            <div id="error">
                Unable to send e-mail at the moment, please try later.</div>
            <div id="validation">
            </div>
        </div>
    </section>
</body>
</html>
