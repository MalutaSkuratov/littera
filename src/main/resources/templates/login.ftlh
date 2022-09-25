<#import "parts/common.ftlh" as c>
<@c.page>
<h2>Login</h2><hr>
<form action="/login" method="post">
    Email: <input type="text" name="username"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Вход</button><br><br>
</form>
<a href="/registration">Регистрация</a>
</@c.page>