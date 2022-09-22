<!DOCTYPE html>
<html>
<head>
    <title>Littera</title>
</head>
<body>
<h2>Registration</h2><hr>

<h3>Add message</h3>
<form action="/registration" method="post">
    Имя: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>
    Никнейм: <input type="text" name="username"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Registration</button>
</form>
</body>
</html>