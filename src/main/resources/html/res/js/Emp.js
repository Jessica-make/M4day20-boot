var app=new Vue({
    el:'.addEmp',
    data:{
        role:'',
        username:'',
        uname:'',
        passwd:'',
        status:'',
        others:''
    },
    methods: {
        add:function () {
            var role=this.role;
            var username=this.username;
            var uname = this.uname;
            var passwd = this.passwd;
            var status=this.status;
            var others=this.others;
            if(role===''){
                alert('职位不能为空!');
                return;
            }
            if(username===''){
                alert('职位不能为空!');
                return;
            }
            if(uname===''){
                alert('用户名不能为空!');
                return;
            }
            if(passwd===''){
                alert('密码不能为空!');
                return;
            }
            if(status===''){
                alert('状态不能为空!');
                return;
            }

            $.ajax({
                url: '/do-addEmp.ajax',
                type:'POST',
                data:{
                    //后端对应前端的数据;
                    role:role,
                    username:username,
                    uname:uname,
                    passwd:passwd,
                    status:status,
                    others:others
                },
                dataType:'JSON',
                success:function (resp,data) {
                    if (resp.code===0){
                        alert('新增成功!');
                        window.location.href="main.html";
                    }else {
                        alert('新增错误!');
                    }
                },
                error:function () {
                    alert('系统异常，请与管理员取得联系!');
                }
            });
        }
    }
});
//这里又没有表格，你显示到哪里去;