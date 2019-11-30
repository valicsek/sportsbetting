<%@include file="templates/header.jsp"%>
<div class="container">

    <div class="jumbotron">
        <h1 class="display-4 text-center"><spring:message code="login.welcome"/></h1>
        <p class="lead text-center"><spring:message code="login.welcome.sub"/></p>
    </div>

    <div class="card card-login">
        <div class="card-header">Login</div>
        <div class="card-body">
            <c:if test="${not empty error}"><div>${error}</div></c:if>
            <c:if test="${not empty message}"><div>${message}</div></c:if>
            <form action="<c:url value='/login' />" method="post">
                <input type="text" class="form-control" id="username" placeholder='<spring:message code="login.email"/>'>
                <input type="password" class="form-control" id="password" placeholder='<spring:message code="login.password"/>'>
                <input type="submit" class="btn btn-primary my-2 my-sm-0"  value='<spring:message code="login.button.sign_in"/>'/>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
</div>

<%@include file="templates/footer.jsp"%>