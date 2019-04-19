$(document).ready(function () {
	var username;
	$.ajax({
		type: "GET",
		url: "/getUsername",
		// data:{
		// 	username:$("#username").text()
		// },
		dataType: "json",
		success:function (result) {
			username=result["username"];
			$("#username").text(username);
		}
	});
})

    // 这个方法是替换字符，将日期的-替换成/
    function splitwords(classname,splitkey,exchange)
    {
        $(classname).each(function () {
            var  value=$(this).text();
            if (value.indexOf(splitkey)>-1){
                varlue=value.replace(new RegExp(splitkey,"gm"),exchange);
                $(this).text(varlue);
            }

        });
    }
/**
 * @Description 显示文章
 * @Author :ZhengFeiFan
 **/
$(function(){
	$.ajax({
		type:"GET",
		url:"/selArticles",
		dataType:"json",
		success:function(data){
			var $arc=$('.article-list');
			var articleList=data["articleList"];
			for(var p in articleList){
                if (!articleList[p].isDelete){
					$arc.prepend('<div class="item" id="'+articleList[p].id+'"'+'name = "'+articleList[p].username+'"'+'><a href="article.html?id='+articleList[p].id+'" class="title pull-left">'+articleList[p].title+'</a>'+'<button class="pull-right download"><span class="glyphicon glyphicon-download-alt"></span></button><button class="pull-right edit"><span class="glyphicon glyphicon-edit"></span></button><button class="pull-right trash"><span class="glyphicon glyphicon-trash"></span></button>'+'<div class="clearfix"></div>'+'<div class="status">'+articleList[p].updateTime.substring(0,10)+'</div>'+'<div class="content">'+articleList[p].content.substring(0,40)+'...'+'</div><hr></div>');
                    // 调用替换字符
                    splitwords(".status","-","/");
				}
	        }
		}
	});
})

//下载发送请求
$(".article-list").on('click','.download',function (e) {

    var message=confirm("温馨提示：\r你确定下载该文章吗？");
    if(message)
    {
        var v=$(e.target);
        var aa=v.parent();

        if (aa.attr("id")==undefined){
        	aa = aa.parent();
        	url = "/download?id="+parseInt(aa.attr("id"));
		}
        else {
        	url="/download?id="+parseInt(aa.attr("id"));
		}
        open(url,'blank');
    }
});

//删除发送请求
$(".article-list").on('click','.trash',function (e) {
    var message=confirm("温馨提示:\r你确定删除该文章吗？");
    if(message)
    {
        var v=$(e.target);
        // 加了个if语句判断，点击按钮任何位置都可以正确获取标签
        if (v[0].tagName=="BUTTON")
        {
            var aa=v.parent();
        }
        else {
            var aa = v.parent().parent();
        }
        $.ajax({
            type:"GET",
            url:"/insertRecycleAticle",
            data:{
                tTxtId:aa.attr("id"),
                tName:aa.find("a").text(),
                tUserName:aa.attr("name"),
                tNumber:aa.find(".content").text().length,
                tTxtCreateTime:aa.find(".status").text()
            },
            dataType:"json",
            success:function(data){
                //修改isDelete的值
                updateIsDelete(aa.attr("id"));
            }
        });
        $(this).parent().remove();
        $.ajax({
            type:"GET",
            url:"",
            dataType:"json",
            success:function(data){
            }

        });
    }
});
//用来删除文章时改变文章表的isDelete字段
function updateIsDelete(id){
    $.ajax({
        type:"GET",
        url:"/deleteTxtById",
        data:"id="+id,
        dataType:"json",
        success:function(data){
        }

    });
}


$(".article-list").on('click','.edit',function (e) {
	var message=confirm("温馨提示：\r你确定修改该文章吗？");
	if(message){
		var v = $(e.target);
		var aa = v.parent();
		if (aa.attr("id")==undefined){
			aa = aa.parent();
			window.location.href="/update.html?id="+$(aa).attr("id");
		}
		else {
			window.location.href="/update.html?id="+$(aa).attr("id");
		}
	}
});

$("#exit").click(function () {
    var message = confirm("温馨提示：\r你确定退出登录吗？");
    if (message) {
        $.ajax({
            type: "GET",
            url: "/exit",
            dataType: "json",
            success: function (data) {
                window.location.href = "/login.html";
            }
        });
    }
});


/*
@Description 主页数据交互
@Author :ZhengFeiFan
*/

