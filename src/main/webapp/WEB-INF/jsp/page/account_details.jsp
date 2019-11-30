<div class="card">
    <div class="card-header">Account Details</div>
    <div class="card-body">

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Name</span>
            </div>
            <input type="text" class="form-control" id="Name" placeholder="${param.name}">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Date of Birth</span>
            </div>
            <input type="text" class="form-control" id="date_of_birth" placeholder="${param.birth}">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Account number</span>
            </div>
            <input type="text" class="form-control" id="account_number" placeholder="${param.account_number}">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Currency</span>
            </div>
            <input type="text" class="form-control" id="currency" placeholder="${param.currency}">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Balance</span>
            </div>
            <input type="number" class="form-control" id="balance" placeholder="${param.balance}">
        </div>

        <a href="#" class="btn btn-primary">Save</a>
    </div>
</div>