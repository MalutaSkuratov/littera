<!DOCTYPE html>
<html>
<head>
    <title>Littera</title>
</head>
<body>
<h2>L I T T E R A</h2><hr>
<#list messages as message>
    <p><b>${message.title}</b>:
        ${message.message} |
        <i>${message.author}</i></p>
    <form action="/messages/delete/${message.id}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Удалить</button>
    </form>
<#else>
    <h3>Нет сообщений</h3>
</#list>
<hr>
<h3>Новое сообщение</h3>
<form action="/messages/new" method="post">
    Тема: <input type="text" name="title"><br><br>
    Сообщение: <input type="text" name="message"><br><br>
    Автор: <input type="text" name="author"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Опубликовать</button>
</form>
</body>
</html>