<!DOCTYPE html>
<html>
<head>
    <title>
        BUYsell
    </title>
</head>
<body>
<h1><a href="/">BUYsell</a></h1><hr>
<h4>Подробная информация о товаре</h4><hr>
<#list images as image>
    <img src="/images/${image.id}" height="60px"><br>
</#list>
<b>Наименование товара: </b>${product.title}<br>
<b>Описание товара: </b>${product.description}<br>
<b>Цена: </b>${product.price}<br>
<b>Город: </b>${product.city}<br>
<b>Автор: </b>${product.author}<br>
<form method="post" action="/product/delete/${product.id}">
    <input type="submit" value="Удалить товар">
</form>
</body>
</html>