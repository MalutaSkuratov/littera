<#import "parts/common.ftlh" as c>
<@c.page>
<h2>Registration</h2><hr>

<hr>
<form action="/registration" method="post">
    Имя: <input type="text" name="name"><br><br>
    Email: <input type="text" name="email"><br><br>
    Никнейм: <input type="text" name="username"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Регистрировать</button>
</form>
</@c.page>