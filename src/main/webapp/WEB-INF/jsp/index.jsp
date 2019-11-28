<%@include file="templates/header.jsp"%>

<%@include file="components/navbar.jsp" %>

<!-- Main Content -->
<div class="container">
    
    <jsp:include page="page/account_details.jsp">
        <jsp:param name="firstname" value="Something" />
    </jsp:include>

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
                        <td></td>
                        <td>#</td>
                        <td>Event Title</td>
                        <td>Event Type</td>
                        <td>Bet Type</td>
                        <td>Outcome value</td>
                        <td>Outcome odd</td>
                        <td>${wager.getAmount()}</td>
                        <td>${wager.isWin()}</td>
                        <td>${wager.isProcessed()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="templates/footer.jsp"%>