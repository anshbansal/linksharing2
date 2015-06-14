// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require serverConfig
//= require jquery/dist/jquery
//= require angular/angular
//= require_self

if (typeof jQuery !== 'undefined') {
    (function ($) {
        $('#spinner').ajaxStart(function () {
            $(this).fadeIn();
        }).ajaxStop(function () {
            $(this).fadeOut();
        });
    })(jQuery);
}

var myApp = angular.module('linksharing', []);

myApp.controller('LoginController', ['$http', function ($http) {
    var self = this;

    self.login = function () {
        $http({
            url: serverConfig.ajaxLinks.auth.login,
            method: "GET",
            params: {
                email: self.email,
                password: self.password
            }

        }).success(function (data) {
            self.status = 'Pass...';

        }).error(function () {
            self.status = "Failed...";
        });
    }

}]);