'use strict';

describe('linksharing test', function () {
    var $httpBackend, $rootScope, mainCtrl, authRequestHandler;

    beforeEach(module('linksharing'));

    beforeEach(inject(function ($injector) {
        $httpBackend = $injector.get('$httpBackend');

        authRequestHandler = $httpBackend.when('GET', serverConfig.ajaxLinks.auth.login)
            .respond("200");

        $rootScope = $injector.get('$rootScope');
    }));

    afterEach(function() {
        $httpBackend.verifyNoOutstandingExpectation();
        $httpBackend.verifyNoOutstandingRequest();
    });

    describe('LoginController test', function () {

        beforeEach(inject(function ($controller) {
            mainCtrl = $controller("LoginController", {$scope: $rootScope});
        }));

        it("should authenticate", function () {
            $httpBackend.expectGET(serverConfig.ajaxLinks.auth.login);
            mainCtrl.login();
            $httpBackend.flush();

            expect(mainCtrl.status).toBe('Pass...');
        });

        it("should fail authentication", function() {
            authRequestHandler.respond(401, '');

            $httpBackend.expectGET(serverConfig.ajaxLinks.auth.login);
            mainCtrl.login();
            $httpBackend.flush();

            expect(mainCtrl.status).toBe('Failed...');
        });
    })
});
