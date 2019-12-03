<%@include file="templates/header.jsp"%>

<%@include file="components/navbar.jsp" %>


<div class="advertisement"></div>

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
        <div class="card-header"><spring:message code="wagers"/></div>
        <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col">#</th>
                        <th scope="col"><spring:message code="wagers.event_title"/></th>
                        <th scope="col"><spring:message code="wagers.event_type"/></th>
                        <th scope="col"><spring:message code="wagers.bet_type"/></th>
                        <th scope="col"><spring:message code="wagers.outcome_value"/></th>
                        <th scope="col"><spring:message code="wagers.outcome_odd"/></th>
                        <th scope="col"><spring:message code="wagers.amount"/></th>
                        <th scope="col"><spring:message code="wagers.winner"/></th>
                        <th scope="col"><spring:message code="wagers.processed"/><th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${wagers}" var="wager">
                        <tr>
                            <td>
                                <c:if test="${!wager.isProcessed()}">
                                    <input type="button" onclick="removeWager(${wager.getId()})" class="btn btn-primary" value='<spring:message code="button.remove"/>'>
                                </c:if>
                            </td>
                            <td>${wager.getId()}</td>
                            <td>${wager.getOdd().getOutcome().getBet().getEvent().getTitle()}</td>
                            <td>${wager.getOdd().getOutcome().getBet().getEvent().getClass().toString()}</td>
                            <td>${wager.getOdd().getOutcome().getBet().getType().name()}</td>
                            <td>${wager.getOdd().getValue()}</td>
                            <td>${wager.getOdd().getOutcome()}</td>
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

<script c:inline="javascript">
    function removeWager(wager_id) {
        if(confirm("Are you sure about to delete the Wager?") == true) {
            const body = new FormData();
            body.append("wager_id", wager_id);

            const headers = new Headers({
                // 'Content-Type': 'x-www-form-urlencoded',
                'X-CSRF-TOKEN': "${_csrf.token}"
            });

            fetch('/removeWager',
                {
                    method: "POST",
                    headers,
                    credentials: 'include',
                    body
                }
            ).then((res) => location.reload())
            .catch((err) => alert("ERR"));
        }
    }
</script>

<%@include file="templates/footer.jsp"%>