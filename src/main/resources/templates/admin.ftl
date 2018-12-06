<#import "parts/common.ftl" as c>

<@c.page>
    Hello, Admin

    <table class="table table-hover table-bordered">
    <thead>
    <tr>
        <th>#</th>
        <th>Login</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>Role</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <#assign count = 0>
    <#list users as user>
        <#assign count = count + 1>
        <tr>
        <th>${count}</th>
        <td>${user.login}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.lastName}</td>
        <td>${user.role.name}</td>
        <td><a href="/edit/${user.id}">Edit</a>
        <a href="/delete/${user.id}" onclick="return confirm('Are you sure?')">Delete</a></td>
        </tr>
    </#list>
    </tbody>
    </table>

</@c.page>