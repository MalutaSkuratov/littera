<#import "parts/common.ftlh" as c>
<@c.page>

<h2>L I T T E R A</h2><hr>
<#list messages as message>
    <p><b>${message.title}</b>:
        ${message.message} |
        <i>${message.author}</i></p>
    <form action="/messages/delete/${message.id}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit"class="btn btn-dark">Удалить</button>
    </form>
<#else>
    <h6>Нет сообщений</h6>
</#list>
<hr>
<h6>Новое сообщение</h6>
<form action="/messages/new" method="post">
    Тема: <input type="text" name="title"><br><br>
    Сообщение: <input type="text" name="message"><br><br>
    Автор: <input type="text" name="author"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit"class="btn btn-dark">Опубликовать</button>
</form>
</@c.page>