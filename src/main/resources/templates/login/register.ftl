<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
</head>
<body>
<h1>用户注册</h1>
<form action="/users/register/do" method="post">
    <p>昵称： <input type="text" name="name" /></p>
    <p>邮箱： <input type="text" name="email" /></p>
    <p>密码： <input type="text" name="password" /></p>
    <input type="submit" value="Submit" />
</form>
</body>
</html>