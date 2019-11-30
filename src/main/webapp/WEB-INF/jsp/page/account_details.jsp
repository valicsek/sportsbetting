<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="card">
    <div class="card-header">
        <spring:message code="account.details"/>
    </div>
    <div class="card-body">

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">
                    <spring:message code="account.details.name"/>
                </span>
            </div>
            <input type="text" class="form-control" id="name" placeholder="${param.name}">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">
                    <spring:message code="account.details.date_of_birth"/>
                </span>
            </div>
            <input type="text" class="form-control" id="date_of_birth" placeholder="${param.birth}">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">
                    <spring:message code="account.account_number"/>
                </span>
            </div>
            <input type="text" class="form-control" id="account_number" placeholder="${param.account_number}">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">
                    <spring:message code="account.currency"/>
                </span>
            </div>
            <input type="text" class="form-control" id="currency" placeholder="${param.currency}">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">
                    <spring:message code="account.balance"/>
                </span>
            </div>
            <input type="number" class="form-control" id="balance" placeholder="${param.balance}">
        </div>

        <a href="#" class="btn btn-primary">
            <spring:message code="button.save"/>
        </a>
    </div>
</div>