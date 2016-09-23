angular.module('AngularChatApp', [])
    .controller('ChatController', function($scope, $http) {

        $scope.message;

        $scope.newMessage = {};

        $scope.getMessages = function () {
            console.log("About to get messages!");

            $http.get("/messages.json")
            .then(
                function successCallBack(response) {
                    console.log(response.data);
                    console.log("Adding message to scope");
                    $scope.message = response.data;
                },
                function errorCallBack (response) {
                    console.log("Unable to send message");
                });
            console.log("Done with the callback");
        };

        $scope.sendMessage = function () {
            console.log("About to send message " + JSON.stringify($scope.newMessage));

            $http.get("/sendMessage.json", $scope.newMessage)
            .then(
                function successCallBack(response) {
                    console.log(response.data);
                    console.log("Adding message to scope");
                    $scope.message = response.data;
                },
                function errorCallBack (response) {
                    console.log("Unable to send message");
                });
            console.log("Done with the callback");
        };


        $scope.getMessages();





});