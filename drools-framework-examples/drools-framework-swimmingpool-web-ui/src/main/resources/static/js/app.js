/*
 * Copyright 2014 Pymma Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
var productManagerModule = angular.module('productManagerApp', ['ngAnimate']);

productManagerModule.controller('quoteManagerController', function ($scope, $http) {

    var urlBase = "";
    var aPerson1 = {
        "name": "",
        "surname": "",
        "gender": "male",
        "birthdate": new Date()
    }
    var aPerson2 = {
        "name": "",
        "surname": "",
        "gender": "male",
        "birthdate": new Date()
    }
    var aPerson3 = {
        "name": "",
        "surname": "",
        "gender": "male",
        "birthdate": new Date()
    }
    $scope.quote = {
        "quoteDate": new Date(),
        "validUntil": new Date(),
        "period": {
            "desidedStartDate": new Date(),
            "seasonType": "day"
        },
        "personList": [aPerson1, aPerson2, aPerson3],
        "priceList": []
    };
    $scope.quoteResult = []
    $scope.products = [];
    $scope.selection = [];
    $scope.productSearch = "";
    $http.defaults.headers.post["Content-Type"] = "application/json";

    $scope.deleteline = function (personline) {
        for (i = 0; i < $scope.quote.personList.length; i++) {
            var aPerson = $scope.quote.personList[i];
            if (aPerson.name == personline.name && aPerson.surname == personline.surname) {
                $scope.quote.personList.splice(i, 1);
            }
        }
        ;

    };
    $scope.addPerson = function () {
        var aPerson = {
            "name": "",
            "surname": "",
            "gender": "male",
            "birthdate": new Date()
        }
        $scope.quote.personList.push(aPerson);


    };


    $scope.calculatePrice = function () {
        var myQuote = $scope.quote;
        $http.put(urlBase + "/swimmingpool-web/quote/calculate", myQuote).success(function (data) {
            $scope.quoteResult = data;
        })
    }


});





