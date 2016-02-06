/**
 * Created by chelowe4ok on 05.02.16.
 */

var modelPeoples = angular.module("modelPeoples",[]);

modelPeoples.controller("ModelPeoplesCtrl", function($scope){
        $scope.peoples = [{
            "name": "Alex",
            "age": "21",
            "heigh": 1.80,
            "institute": "KPI"
        },
            {
                "name": "Dima",
                "age": "19",
                "heigh": 1.70,
                "institute": "MAU"

            },
            {
                "name": "Rex",
                "age": "23",
                "heigh": 0.50,
                "institute": "DOM"
            }];

        var date = new Date();
        $scope.today = date;
});
