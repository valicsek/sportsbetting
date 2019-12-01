<%@include file="templates/header.jsp"%>
<div class="container">

    <div class="card card-login">
        <div class="card-header"><spring:message code="register"/></div>
        <div class="card-body">
            <c:if test="${not empty param.error}"><div>${param.error}</div></c:if>
            <c:if test="${not empty param.logout}"><div>${param.logout}</div></c:if>
            <form action="<c:url value='/register' />" method="post">
                <input required type="text" class="form-control" id="name" name="name" placeholder='<spring:message code="account.details.name"/>'>
                <input required type="text" class="form-control" id="email" name="email" placeholder='<spring:message code="login.email"/>'>
                <input required type="password" class="form-control" id="password" name="password" placeholder='<spring:message code="login.password"/>'>
                <input required type="password" class="form-control" id="repassword" name="repassword" placeholder='<spring:message code="login.password"/>'>
                <input required type="submit" class="btn btn-primary my-2 my-sm-0"  value='<spring:message code="register"/>'/>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </div>

<%@include file="templates/footer.jsp"%>