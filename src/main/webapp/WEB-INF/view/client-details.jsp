<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>Task-details</h2>
<br>

<form:form action="saveClient" modelAttribute="client">

    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Pass <form:input path="passportNumber"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>