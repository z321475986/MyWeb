    var app = new Vue(
        {
            el: '#app',
            data: {
                name: ''
                , birthday: ''
                , addres: ''
                , phone: ''
                ,password: ''
                , sex: ''
                , height: ''
                , weight: ''
                , contactname: ''
                , contactphone: ''
                , primarycaregiversname: ''
                , primarycaregiversphone: ''
                , pastmedicalhistory: ''
                , chronicmedicalhistory: ''
                , cmslevel: ''
                , dementialevel: ''
                , medicationprofile: ''
                , allergy: ''
                , financialsituation: ''
                , note: '',
                result:
                {
                    name: ''
                    , birthday: ''
                    , phone: ''
                    ,password: ''
                    , addres: ''
                    , sex: ''
                    , height: ''
                    , weight: ''
                    , contactname: ''
                    , contactphone: ''
                    , primarycaregiversname: ''
                    , primarycaregiversphone: ''
                    , pastmedicalhistory: ''
                    , chronicmedicalhistory: ''
                    , cmslevel: ''
                    , dementialevel: ''
                    , medicationprofile: ''
                    , allergy: ''
                    , financialsituation: ''
                    , note: ''
                },
                isShow: false,
            },
            methods: {
                query: function (phone, password) {
                    var xhr = new XMLHttpRequest();
                    var urlString = '/company/findm?n=' + phone + '&p=' + password;
                    xhr.onreadystatechange = function (e) {
                        console.log(xhr.readyState);
                        if (xhr.readyState == 4 && xhr.status == 200) {
                            app.isShow = true;
                            var len=0;
                            app.result = JSON.parse(xhr.responseText);
                            len=app.result.length;
                            console.log("長度"+app.result.length);
                            if (len==1)
                            {
								alert("登入成功");
							}
							else if (len==0)
							{
								alert("登入失敗,帳號密碼輸入錯誤");
							}
                            console.log(xhr.responseText);
                            

                        }
                        else if (xhr.readyState == 4 && xhr.status == 400) {
                            app.isShow = false;
                            var errorObject = JSON.parse(xhr.responseText);

                            alert(errorObject.msg);
                        }
                    }
                    xhr.open('GET', urlString);
                    xhr.send();
                }
            }
        }
    );