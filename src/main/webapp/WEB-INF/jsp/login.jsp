<%@include file="templates/header.jsp"%>
<div class="container">

    <div class="jumbotron">
        <h1 class="display-4 text-center"><spring:message code="login.welcome"/></h1>
        <p class="lead text-center"><spring:message code="login.welcome.sub"/></p>
    </div>

    <div class="card card-login">
        <div class="card-header">Login</div>
        <div class="card-body">
            <c:if test="${not empty param.error}"><div>${param.error}</div></c:if>
            <c:if test="${not empty param.logout}"><div>${param.logout}</div></c:if>
            <form action="<c:url value='/login' />" method="post">
                <input required type="text" class="form-control" id="username" name="username" placeholder='<spring:message code="login.email"/>'>
                <input required type="password" class="form-control" id="password" name="password" placeholder='<spring:message code="login.password"/>'>
                <input type="submit" class="btn btn-primary my-2 my-sm-0"  value='<spring:message code="login.button.sign_in"/>'/>
                <a href="/register"><spring:message code="register"/></a>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
</div>

<%@include file="templates/footer.jsp"%>