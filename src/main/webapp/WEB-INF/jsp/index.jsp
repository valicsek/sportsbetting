<%@include file="templates/header.jsp"%>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg">
    <div class="container">
        <a class="navbar-brand" href="#">Sportsbetting</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Events</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Language
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">English</a>
                        <a class="dropdown-item" href="#">Magyar</a>
                    </div>
                </li>
            </ul>
            <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Login</button>
        </div>
    </div>
</nav>
<!-- Main Content -->
<div class="container">
    <div class="card">
        <div class="card-header">Login</div>
        <div class="card-body">
            <input type="text" class="form-control" id="email" placeholder="Email">
            <input type="text" class="form-control" id="password" placeholder="Password">
            <button class="btn btn-primary my-2 my-sm-0" type="submit">Login</button>
        </div>
    </div>

    <div class="card">
        <div class="card-header">Account Details</div>
        <div class="card-body">

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Name</span>
                </div>
                <input type="text" class="form-control" id="Name">
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Date of Birth</span>
                </div>
                <input type="text" class="form-control" id="date_of_birth">
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Account number</span>
                </div>
                <input type="text" class="form-control" id="account_number">
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Currency</span>
                </div>
                <input type="text" class="form-control" id="account_number">
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Balance</span>
                </div>
                <input type="number" class="form-control" id="balance">
            </div>

            <a href="#" class="btn btn-primary">Save</a>
        </div>
    </div>

    <div class="card">
        <div class="card-header">Wages</div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">#</th>
                    <th scope="col">Event Title</th>
                    <th scope="col">Event Type</th>
                    <th scope="col">Bet Type</th>
                    <th scope="col">Outcome value</th>
                    <th scope="col">Outcome odd</th>
                    <th scope="col">Wager amount</th>
                    <th scope="col">Winner</th>
                    <th scope="col">Processed</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${wagers}" var="wager">
                    <tr>
                        <td>${wager}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="templates/footer.jsp"%>