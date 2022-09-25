<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<body>

<h2>All Clients</h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Pass</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="cli" items="${allCli}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="cliId" value="${cli.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteClient">
            <c:param name="cliId" value="${cli.id}"/>


        </c:url>

        <tr>
            <td>${cli.name}</td>
            <td>${cli.surname}</td>
            <td>${cli.passportNumber}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'"/>

                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>

            </td>
        </tr>

    </c:forEach>

</table>
<br>

<input type="button" value="Add client"
       onclick="window.location.href = 'addNewClient'"/>

</body>

</html>
