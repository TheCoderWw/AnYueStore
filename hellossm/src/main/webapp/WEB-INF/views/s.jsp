<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>login test</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
        function login() {
            $.ajax({
                type: "POST",
                dataType: "json",//服务器返回的数据类型
                contentType: "application/json",//post请求的信息格式
                url: "/users/login" ,
                data: $('#form1').serialize(),
                success: function (result) {
                    console.log(result);//在浏览器中打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    };
                },
                error : function() {
                    alert("异常！");
                }
            });
        }
    </script>
</head>
<body>
<div id="form-div">
    <form id="form1" onsubmit="return false" action="##" method="post">
        <p>用户名：<input name="userName" type="text" id="txtUserName" tabindex="1" size="15" value=""/></p>
        <p>密　码：<input name="password" type="password" id="TextBox2" tabindex="2" size="16" value=""/></p>
        <p><input type="button" value="登录" onclick="login()">&nbsp;<input type="reset" value="重置"></p>
    </form>
</div>
</body>
</html>