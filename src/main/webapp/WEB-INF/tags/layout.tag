<%@tag description="Layout Tag" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<h1>Example Application</h1>

<c:if test="${__user}">
    <a href="/logout">logout</a>
</c:if>
<c:if test="${!__user}">
    <a href="/login">login</a>
</c:if>

<hr/>

<jsp:doBody/>
</body>