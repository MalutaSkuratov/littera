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
        <button type="submit">Delete</button>
    </form>
    <#else>
    <h3>Nothing messages</h3>
</#list>
<hr>
<h3>Add message</h3>
<form action="/messages/new" method="post">
    Title: <input type="text" name="title"><br><br>
    Message: <input type="text" name="message"><br><br>
    Author: <input type="text" name="author"><br><br>
    <button type="submit">Create</button>
</form>
</body>
</html>