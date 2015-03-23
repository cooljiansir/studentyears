$(".gdropdown").click(function(){
	var isopen = $(this).next().data("isopen");
	console.log("thisnext"+isopen);
	if(typeof(isopen) == "undefined"||isopen == false){
		$(this).next().slideDown(200);
		$(this).next().data("isopen",true);
		$(this).children("span").removeClass("glyphicon-menu-down");
		$(this).children("span").addClass("glyphicon-menu-up");
	}
	else{
		$(this).next().slideUp(200);
		$(this).next().data("isopen",false);
		$(this).children("span").removeClass("glyphicon-menu-up");
		$(this).children("span").addClass("glyphicon-menu-down");
	}
});
/*$(".gdropdown").mouseleave(function(){
	$(this).next().slideUp(200);
});
$(".gdropdown-menu").mouseleave(function(){
	$(this).slideUp(200);
});*/

$("#loginBut").click(function(){
	$('#loginModal').modal('show');
});
$("#registerBut").click(function(){
	$('#registerModal').modal('show');
});
$("#releaseBut").click(function(){
	$('#releaseModal').modal('show');
});
