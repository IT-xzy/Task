app.factory('saveSession', function () {
  let service = {
    save: function (key, value) {
      if (sessionStorage[key]) {
        sessionStorage[key] = JSON.stringify(value);
      } else {
        sessionStorage.setItem(key, JSON.stringify(value));
      }
    },
    get: function (key) {
      if (sessionStorage[key]) {
        let object = JSON.parse(sessionStorage[key]);
        for (let i in object) {
          // console.log(object[i]);

          if (object[i] == 'NaN' || object[i] == null) {
            object[i] = ''
          }
        }
        // console.log(object);
        return object;
      } else {
        return null
      }
    }
  }
  return service;
})

app.factory('myHttp', function ($http,$q) {
  let getArticleUrl = '/carrots-admin-ajax/a/article/search/';
  let getSingleArticleUrl = '/carrots-admin-ajax/a/article/';
  let updateArticleUrl = '/carrots-admin-ajax/a/u/article/';
  let deleteUrl = '/carrots-admin-ajax/a/u/article/';
  let uploadArticleUrl = '/carrots-admin-ajax/a/u/article';
  let uploadPictureUrl = '/carrots-admin-ajax/a/u/img/task';
  let modifyStatusUrl = '/carrots-admin-ajax/a/u/article/status';
  let service = {
    getArticle: function (params) {
      return $http({
        method: 'GET',
        params: params,
        url: getArticleUrl
      })
    },
    modifyStatus: function (id, status) {
      let feedback;
      if (status == 1) {
        feedback = confirm('确定上架吗？');
      } else if (status == 2) {
        feedback = confirm('确定下架吗？')
      }
      if (feedback) {
        switch (status) {
          case 1:
            status = 2;
            break;
          case 2:
            status = 1;
            break;
          default:
            break;
        }
        return $http({
          method: 'PUT',
          url: modifyStatusUrl,
          params: {
            id: id,
            status: status
          },
        });
      }
    },

    delete: function (id) {
      let feedback = confirm('确定删除吗？');
      if (feedback) {
        return $http({
          method: 'DELETE',
          url: deleteUrl + id,
          headers: {
            'Content-Type': undefined
          }
        })
      } else {
        return;
      }
    },
    updateArticle: function (id, params) {
      return $http({
        method: 'PUT',
        url: updateArticleUrl + id,
        // params: params,
        data: $.param(params),
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
        },
      });
    },
    getSingleArticle: function (id) {
      return $http({
        method: 'GET',
        url: getSingleArticleUrl + id,
      })
    },
    uploadPicture: function (pic) {
      return $http({
        method: 'POST',
        url: uploadPictureUrl,
        data: pic,
        headers: {
          'Content-Type': undefined
        }
      });
    },
    uploadArticle: function (form) {
      return $http({
        method: 'POST',
        url: uploadArticleUrl,
        data: form,
        headers: {
          'Content-Type': undefined,
        }
      });
    },
  }
  return service;
})

app.factory('pageService', function () {
  let service;
  service = {
    getDisplayPages: function (totalPage) {
      let displayPages = [];
      if (totalPage > 5) {
        displayPages = [1, 2, 3, 4, 5];
      } else {
        displayPages = [];
        for (let i = 0; i < totalPage; i++) {
          displayPages.push(i + 1);
        }
      }
      return displayPages;
    }
  };
  return service;
})