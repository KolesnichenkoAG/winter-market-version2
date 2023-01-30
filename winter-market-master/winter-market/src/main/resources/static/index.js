angular.module('market', []).controller('indexController', function ($scope, $http) {

    $scope.fillTable = function () {
        $http.get('http://localhost:8189/winter/api/v1/products')
            .then(function (response) {
                $scope.productsList = response.data;
                // console.log(response);
            });
    };

    $scope.showProductInfo = function (productId) {
        $http.get('http://localhost:8189/winter/api/v1/products/' + productId)
            .then(function (response) {
                alert(response.data.title);
            });
    }

    $scope.deleteProduct = function (productId) {
        $http.delete('http://localhost:8189/winter/api/v1/products/' + productId)
            .then(function (response) {
                $scope.fillTable();
            });
    }

    $scope.createNewProduct = function () {
        // console.log($scope.newProduct);
        $http.post('http://localhost:8189/market/api/v1/products', $scope.newProduct)
            .then(function (response) {
                $scope.newProduct = null;
                $scope.fillTable();
            });
    }

    $scope.addToCart = function (productId) {
        console.log("Click-1")
        $http.get('http://localhost:8189/winter/api/v1/cart/add/' + productId)
            .then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.changeQuantity = function (productId, delta) {
        console.log("Click-33")
        $http({
            url: 'http://localhost:8189/winter/api/v1/cart/change/' + productId,
            method: 'GET',
            params: {
                delta: delta
            }
        }).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.loadCart = function () {
        $http.get('http://localhost:8189/winter/api/v1/cart')
            .then(function (response) {
                $scope.cart = response.data;
            });
    }

    $scope.clearCart = function () {
        console.log("Click-2")
        $http.get('http://localhost:8189/winter/api/v1/cart/clear')
            .then(function (response) {
                $scope.cart = response.data;
            });
    }


    $scope.fillTable();
    $scope.loadCart();
});