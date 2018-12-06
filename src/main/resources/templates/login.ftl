<#import "parts/common.ftl" as c>

<@c.page>
    <#if error??>
        <div class="alert alert-danger" role="alert">Логин или пароль введены неверно</div>
    </#if>
    <div>
        <form action="/login" method="post">
            <div class="form-group">
                <label for="exampleInputLogin">Login</label>
                <input type="text" class="form-control" id="exampleInputLogin" aria-describedby="emailHelp"
                       placeholder="Enter login" name="login" required>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Enter password"
                       name="password" required>
            </div>
            <label for="remember-me">
                <input type="checkbox" id="remember-me" name="remember-me">Remember me</label>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</@c.page>