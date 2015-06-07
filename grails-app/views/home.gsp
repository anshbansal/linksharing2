<html>
<head>
    <meta name="layout" content="main"/>
    <title>Linksharing</title>
</head>

<body>

<div ng-controller="LoginController as loginCtrl">
    <form name="loginForm" novalidate>
        Email: <input type="email" ng-model="loginCtrl.email" name="loginEmail" required>
        <div ng-show="loginForm.$submitted || loginForm.loginEmail.$touched">
            <span ng-show="loginForm.loginEmail.$error.required">Tell us your email.</span>
            <span ng-show="loginForm.loginEmail.$error.email">This is not a valid email.</span>
        </div>
        <br/>

        Password: <input type="password" ng-model="loginCtrl.password" name="loginPassword"
                         required="" minlength="6">
        <div ng-show="form.$submitted || form.loginPassword.$touched">
            <span ng-show="loginForm.loginPassword.$error.required">Enter your password.</span>
            <span ng-show="loginForm.loginPassword.$error.minlength">Minimum Length of password should be 6.</span>
        </div>
        <br/>

        <button type="submit" ng-click="loginForm.$valid && loginCtrl.login()">Login</button>
    </form>
</div>

</body>
</html>