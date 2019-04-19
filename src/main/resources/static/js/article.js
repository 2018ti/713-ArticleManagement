var id;
$(function(){
	id = window.location.search.substring(1);
	$.ajax({
		url:"/show?"+id,
		type:"get",
		success: function(data){
			var article =data["article"];
			$(".txt-words").html(article.content);
			$(".author").text(article.author);
			$(".time").text(article.updateTime.substring(0,10));
			$(".title").text(article.title);
		}
	})
})

$(document).ready(function() {
	$(".out").on("click", function() {
		alert("退出成功");
		location.href="login.html";
	})
});
