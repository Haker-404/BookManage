<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>增加图书</title>
</head>
<body>
<h1>增加一个图书</h1>
<form action="/books/add/do" method="post">
    <p>书名： <input type="text" name="name" /></p>
    <p>作者： <input type="text" name="author" /></p>
    <p>价格： <input type="text" name="price" /></p>
    <input type="submit" value="Submit" />
</form>
</body>
</html>