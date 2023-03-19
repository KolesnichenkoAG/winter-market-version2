angular.module('market').controller('cartController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:5555/cart/';
    const coreContextPath = 'http://localhost:5555/core/';

    $scope.loadCart = function () {
        $http.get(contextPath + 'api/v1/cart/' + $localStorage.winterMarketGuestCartId)
            .then(function (response) {
                $scope.cart = response.data;
            });
    };

    $scope.clearCart = function () {
        console.log("Click-2")
        $http.get(contextPath + 'api/v1/cart/' + $localStorage.winterMarketGuestCartId + '/clear')
            .then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.changeQuantity = function (productId, delta) {
        console.log("Click-33")
        $http({
            url:  contextPath + 'api/v1/cart/' + $localStorage.winterMarketGuestCartId + '/change/' + productId,
            method: 'GET',
            params: {
                delta: delta
            }
        }).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.removeFromCart = function (productId) {
        $http.get(contextPath + 'api/v1/cart/' + $localStorage.winterMarketGuestCartId + '/remove/' + productId)
            .then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.createOrder = function () {
        console.log("Click-555")
        $http.post(coreContextPath + 'api/v1/orders')
            .then(function (response) {
                alert('Заказ оформлен');
                $scope.loadCart();
            });
    }

    $scope.guestCreateOrder = function () {
        alert('Для оформления заказа необходимо войти в учетную запись');
    }

    $scope.loadCart();
});