<%@include file="templates/header.jsp"%>

<%@include file="components/navbar.jsp" %>

<!-- Main Content -->
<div class="container">

    <jsp:include page="page/account_details.jsp">
        <jsp:param name="name" value="${player.getName()}" />
        <jsp:param name="birth" value="${player.getBirth()}" />
        <jsp:param name="account_number" value="${player.getAccountNumber()}" />
        <jsp:param name="currency" value="${player.getCurrency()}" />
        <jsp:param name="balance" value="${player.getBalance()}" />
    </jsp:include>

    <div class="card">
        <div class="card-header"><spring:message code="wages"/></div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">#</th>
                    <th scope="col"><spring:message code="wages.event_title"/></th>
                    <th scope="col"><spring:message code="wages.event_type"/></th>
                    <th scope="col"><spring:message code="wages.bet_type"/></th>
                    <th scope="col"><spring:message code="wages.outcome_value"/></th>
                    <th scope="col"><spring:message code="wages.outcome_odd"/></th>
                    <th scope="col"><spring:message code="wages.amount"/></th>
                    <th scope="col"><spring:message code="wages.winner"/></th>
                    <th scope="col"><spring:message code="wages.processed"/><th>
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