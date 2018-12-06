<#import "parts/common.ftl" as c>

<@c.page>
    <form method="post" class="form-horizontal" action="/add">
        <div class="form-group">
            <label class="control-label col-sm-3" for="login">Login:</label>
            <div class="col-sm-6">
                <input type="text"
                       class="form-control"
                       id="login"
                       placeholder="Enter login"
                       name="login"
                       pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
                       title="Uppercase and lowercase letter. Must be 2-20 characters. Without specifically characters #,$,% and so on. For example SuttyRead"
                       aria-describedby="loginHelpInline"
                       required>
                <small id="loginHelpInline" class="text-muted">
                    Must be 2-20 characters long.
                </small>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-3"
                   for="password">Password:</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" id="password"
                       placeholder="Enter password" name="password"
                       aria-describedby="passwordHelpInline"
                       pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"
                       title="Password must be have lowercase and uppercase Latin letters, number. Minimum 8 characters"
                       required>
                <small id="passwordHelpInline" class="text-muted">
                    Lowercase and uppercase Latin letters, numbers, special characters. Minimum 8 characters
                </small>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-3"
                   for="confirmPassword">Confirm Password:</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" id="confirmPassword"
                       placeholder="Confirm password" name="confirmPassword"
                       pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"
                       title="Password must be have lowercase and uppercase Latin letters, number. Minimum 8 characters"
                       required>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-3"
                   for="email">Email:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="email"
                       placeholder="Enter email" name="email" aria-describedby="emailHelpInline"
                       pattern="\w+([\.-]?\w+)*@\w+([\.-]?\w+)*\.\w{2,4}"
                       title="Enter correct email. Email must be have @. For example SuttyRead@gmail.com" required>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-3"
                   for="First Name">First Name:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="First Name"
                       placeholder="Enter first name" name="firstName" aria-describedby=firstNameHelpInline"
                       pattern="^[A-Z]{1}[a-z]{1,25}"
                       title=" Only latin letter. First letter must be uppercase. For example Sutty" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3"
                   for="Last Name">Last Name:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="Last Name"
                       placeholder="Enter last name" name="lastName" aria-describedby=lastNameHelpInline"
                       title=" Only latin letter. First letter must be uppercase. For example Read"
                       pattern="^[A-Z]{1}[a-z]{1,25}" required>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3"
                   for="Birthday">Birthday:</label>
            <div class="col-sm-6">
                <input type="date" class="form-control" id="Birthday"
                       placeholder="Enter birthday" name="birthday" required>
            </div>

        </div>

        <div class="form-group">
            <label class="control-label col-sm-3"
                   for="Role">Role:</label>
            <div class="col-sm-6">
                <select class="form-control" id="Role" name="role">
                    <option value="2">User</option>
                    <option value="1">Admin</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-1 col-sm-offset-4">
                <button type="submit" class="btn btn-success">OK</button>
            </div>
            <div class="col-sm-1">
                <a href="/home"
                   class="btn btn-primary"
                   role="button"
                   aria-pressed="true">Cancel</a>
            </div>
        </div>
    </form>
</@c.page>