'use strict';

describe('linksharing test', function () {

    beforeEach(module('linksharing'));

    var scope, mainCtrl;
    beforeEach(inject(function ($compile, $rootScope) {
        scope = $rootScope.$new();
    }));

    describe('LoginController test', function () {
        beforeEach(inject(function ($controller) {
            mainCtrl = $controller("LoginController", {$scope: scope});
        }));

        it("should set hello text", function () {
            var helloText = 'Hello Angular Demo!';
            expect(scope.helloText).toEqual(helloText);
        });
    })
});
