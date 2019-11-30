<%@include file="templates/header.jsp"%>
<div class="container">

    <div class="jumbotron">
        <h1 class="display-4 text-center">Welcome to SportsBet!!</h1>
        <p class="lead text-center">Sports betting is the activity of predicting sports results and placing a wager on the outcome.</p>
    </div>

    <div class="card card-login">
        <div class="card-header">Login</div>
        <div class="card-body">
            <c:if test="${not empty error}"><div>${error}</div></c:if>
            <c:if test="${not empty message}"><div>${message}</div></c:if>
            <form action="<c:url value='/login' />" method="post">
                <input type="text" class="form-control" id="username" placeholder="Email">
                <input type="password" class="form-control" id="password" placeholder="Password">
                <input type="submit" class="btn btn-primary my-2 my-sm-0"  value="Sign In"/>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
</div>

<%@include file="templates/footer.jsp"%>