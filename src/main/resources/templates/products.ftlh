<!DOCTYPE html>
<html>
<head>
    <title>
        BUYsell
    </title>
</head>
<body>
<h1>BUYsell</h1><hr>
<h4>Товары</h4><hr>
<form method="get" action="/">
    Поиск по наименования объявления: <input type="text" name="title">
    <input type="submit" value="Поиск">
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} тг. | <a href="/product/${product.id}">Подробнее</a></p>
    </div>
<#else >
    <H3>Товаров нет</H3>
</#list><hr>
<form method="post" action="/product/create">
    Название объявления: <input type="text" name="title"><br>
    Описание объявления: <input type="text" name="description"><br>
    Цена: <input type="number" name="price"><br>
    Город: <input type="text" name="city"><br>
    Автор: <input type="text" name="author"><br>
    <input type="submit" value="Добавить товар">
</form>
</body>
</html>