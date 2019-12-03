<%@include file="templates/header.jsp"%>
<%@include file="components/navbar.jsp" %>
<div class="container">
    <div class="card">
        <div class="card-header"><spring:message code="navbar.events"/></div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">#</th>
                    <th scope="col"><spring:message code="wagers.event_title"/></th>
                    <th scope="col"><spring:message code="wagers.event_type"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${events}" var="event">
                    <tr>
                        <td>
                            <input type="button" disabled onclick="removeWager(${event.getId()})" class="btn btn-primary" value='<spring:message code="button.remove"/>'>
                        </td>
                        <td>${event.getId()}</td>
                        <td>${event.getTitle()}</td>
                        <td>${event.getClass().toString()}</td>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="templates/footer.jsp"%>