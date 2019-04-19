$("#returnlogin").click(function () {
	window.location.href="/login.html";
});

//对输入进行判断，并显示提示文字
$(function(){
	$(".input input").blur(function(){
		var $parent=$(this).parent();
		$parent.find(".help-block").remove();
		$parent.find("#first").remove();
		if ($parent.is('.has-error')) {
			$parent.removeClass('has-error')
		}
		else if ($parent.is('.hasSuccess')) {
			$parent.removeClass('has-success')
		}
		if($(this).is('#usernameInput')){
			if (this.value==""||this.value.length<6) {
				var errorMsg='请至少输入6位的用户名';
				$("#first").removeClass("hidden");
				$parent.append('<span class="glyphicon glyphicon-remove form-control-feedback" id="first"></span>');
				$parent.append('<span id="helpBlock" class="help-block">'+errorMsg+'</span>');
				$parent.addClass('has-error');
			}
			else{
				var okMsg="输入正确";
				$parent.append('<span class="glyphicon glyphicon-ok form-control-feedback" id="first"></span>');
				$parent.append('<span id="helpBlock" class="help-block">'+okMsg+'</span>');
				$parent.addClass('has-success');
			}
		}
		if($(this).is('#passwordInput')){
			if (this.value==""||this.value.length<6) {
				var errorMsg='您的密码过于简单，请重新设置';
				$("#first").removeClass("hidden");
				$parent.append('<span class="glyphicon glyphicon-remove form-control-feedback" id="first"></span>');
				$parent.append('<span id="helpBlock" class="help-block">'+errorMsg+'</span>');
				$parent.addClass('has-error');
			}
			else{
				var okMsg="输入正确";
				$parent.append('<span class="glyphicon glyphicon-ok form-control-feedback" id="first"></span>');
				$parent.append('<span id="helpBlock" class="help-block">'+okMsg+'</span>');
				$parent.addClass('has-success');
			}
		}
		if($(this).is('#telInput')){
			if (this.value==""||this.value.length<11) {
				var errorMsg='请输入正确的电话号码';
				$("#first").removeClass("hidden");
				$parent.append('<span class="glyphicon glyphicon-remove form-control-feedback" id="first"></span>');
				$parent.append('<span id="helpBlock" class="help-block">'+errorMsg+'</span>');
				$parent.addClass('has-error');
			}
			else{
				var okMsg="输入正确";
				$parent.append('<span class="glyphicon glyphicon-ok form-control-feedback" id="first"></span>');
				$parent.append('<span id="helpBlock" class="help-block">'+okMsg+'</span>');
				$parent.addClass('has-success');
			}
		}
		if($(this).is('#ageInput')){
			if (this.value==""||this.value.length>3) {
				var errorMsg='请输入正确的年龄';
				$("#first").removeClass("hidden");
				$parent.append('<span class="glyphicon glyphicon-remove form-control-feedback" id="first"></span>');
				$parent.append('<span id="helpBlock" class="help-block">'+errorMsg+'</span>');
				$parent.addClass('has-error');
			}
			else{
				var okMsg="输入正确";
				$parent.append('<span class="glyphicon glyphicon-ok form-control-feedback" id="first"></span>');
				$parent.append('<span id="helpBlock" class="help-block">'+okMsg+'</span>');
				$parent.addClass('has-success');
			}
		}
	}).keyup(function(){
	$(this).triggerHandler("blur");
}).focus(function(){
	$(this).triggerHandler("blur");
});
})
//向后端请求，传入数据
$("#load").click(function(){
	$.ajax({
		type:"POST",
		url:"/userRegist",
		data:
		{
			username:$("#usernameInput").val(),
			password:$("#passwordInput").val(),
			telephone:$("#telInput").val(),
			age:$("#ageInput").val()
		},
		dataType:"json",
		success:function(data,textStatus){
			if (data["msg"]==0){
                alert("用户名已经存在");
			}else {
				alert("注册成功");
                window.location.href="/login.html";
			}

		}
	});
})

//背景变换
setInterval(function(){
	imgs=$('#div1 img');

	imgs.eq(2).stop().fadeOut(500,function(){
		$(this).show().prependTo('#div1');
	});
},3000);


/**
 * @Description 注册页面数据交互
 * @Author :ZhengFeiFan
 **/