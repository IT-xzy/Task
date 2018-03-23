angular.module('myApp')
    //一。banner图服务
    .factory('myBannerService',function ($http,project_path) {
        return{
            getBannerList:function (params) {
                return $http.get(project_path.getBannerList(),{
                    params:params
                })
            },
            delBannerItem:function (id) {
                return $http.delete(project_path.delBannerItem(id))
            }
        }
    }).factory('project_path',function () {
    return{
        getBannerList:function () {
            return '/carrots-admin-ajax/a/article/search'
        },
        delBannerItem:function (id) {
          return '/carrots-admin-ajax/a/u/article/'+id
        }
    }
})