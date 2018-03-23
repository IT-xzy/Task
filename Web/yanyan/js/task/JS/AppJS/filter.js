/**
 * Created by MACHENIKE on 2017/8/7.
 */
angular.module("myApp")

    .filter("typesFilter", function (types) {
        return function (value) {
            return types[value].name
        }
    })

    .filter("StatusFilter", function (Status) {
        return function (value) {
            return Status[value-1].name
        }
    })

    .filter("StatusOPFilter", function (StatusOP) {
        return function (value) {
            return StatusOP[value-1].name
        }
    });

