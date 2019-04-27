<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书列表</title>
</head>
<body>
<div align="center">
    <h3>图书列表</h3>
    <h4 id="status"></h4>
    <#if host??>
    <table cellpadding="10">
        <tr>
            <td>${host.name}</td>
            <td><a href="/users/logout/do">退出登录</a></td>
        </tr>
    </table>
    <#else>
    <h5>未登录！<a href="/users/login">登陆/</a><a href="/users/register">注册</a></h5>
    </#if>

<table border="1" cellpadding="10">
    <tr>

        <td>书名</td>
        <td>作者</td>
        <td>价格</td>
        <td>状态</td>
        <td colspan="2" align="center"><a href="/book/addbook" target="_blank">Add</a></td>
    </tr>
    <#list books as book>
    <tr>

        <td>《${book.name}》</td>
        <td>${book.author}</td>
        <td>${book.price}</td>
        <td><#if book.status == 0> 在库 <#elseif book.status == 1> 已借出 </#if></td>
        <td><a href="/books/${book.id}/delete">借书</a></td>
        <td><a href="/books/${book.id}/recover">还书</a></td>
    </tr>
</#list>
</table>
</div>
</body>
</html>