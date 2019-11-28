<%@include file="templates/header.jsp"%>
<div class="container">

    <div class="jumbotron">
        <h1 class="display-4 text-center">Welcome to SportsBet!!</h1>
        <p class="lead text-center">Sports betting is the activity of predicting sports results and placing a wager on the outcome.</p>
    </div>

    <div class="card card-login">
        <div class="card-header">Login</div>
        <div class="card-body">
            <input type="text" class="form-control" id="email" placeholder="Email">
            <input type="text" class="form-control" id="password" placeholder="Password">
            <button class="btn btn-primary my-2 my-sm-0" type="submit">Login</button>
        </div>
</div>

<%@include file="templates/footer.jsp"%>