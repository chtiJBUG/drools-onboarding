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

productManagerModule.controller('productManagerController', function ($scope, $http) {

    var urlBase = "";
    $scope.ticket = {
        "dateTicket": new Date(),
        "amount": 0,
        "loyaltyCard": {
            "number": "",
            "name": "",
            "customer": {
                "customerID": "",
                "surName": "",
                "name": "",
                "maritalName": "",
                "gender": "MR",
                "birthDate": new Date()
            }
        },
        "ticketLines": []
    };
    $scope.ticketResult =[]
    $scope.products = [];
    $scope.selection = [];
    $scope.productSearch = "";
    $http.defaults.headers.post["Content-Type"] = "application/json";

    $scope.deleteline = function (ticketline){
        for (i = 0; i < $scope.ticket.ticketLines.length; i++) {
            var aTicket=$scope.ticket.ticketLines[i];
            if (aTicket.product.id==ticketline.product.id){
                $scope.ticket.ticketLines.splice(i,1);
            }
        };

    };

    $scope.addToShoppingCard = function (product) {
        var productItem = {
            "id": product.id,
            "name": product.productName,
            "price": {
                "price": product.price,
                "currency": "EURO"
            },
            "provider": {
                "name": product.providerName
            }
        }
        var ticketline = {
            "product": productItem,
            "quantity": 1.0,
            "price": product.price.price,
            "lineTotal": 0

        };
        $scope.ticket.ticketLines.push(ticketline);
    };


    $scope.searchProducts = function () {
        var config = {headers: {
            'Accept': 'application/json'
        }
        };
        //get all tasks and display initially
        var searchElement = $scope.productSearch;
        $http.get(urlBase + '/loyalty-web/products/search/findByProductNameStartingWith?name=' + searchElement, config).
                success(function (data) {
                    for (i = 0; i < data._embedded.products.length; i++) {
                        var aProduct = data._embedded.products[i];
                        var myLink = aProduct._links.self.href;
                        var myID = myLink.substr(myLink.lastIndexOf("/") + 1, myLink.length);
                        aProduct.id = myID;
                        $scope.products.push(aProduct);

                    }
                    $scope.products = data._embedded.products;
                });
    };

    $scope.calculateLoyalty = function () {
        var myTicket = $scope.ticket;
        $http.put(urlBase + "/loyalty-web/ticket/calculate", myTicket).success(function (data) {
            $scope.ticketResult = data;
        })
    }


});





