<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
    <form method="post">
        Can I <input type="text" name="key">
        <p>
        <input type="submit" value="Ask">
    </form>
    <p>
    ${sessionScope.q}
    ${sessionScope.s}
</body>
<html>