$(document).ready( function() {
	//alert($("#hiddenpicturepackage").val()); 
	document.getElementById("gphotodiv").innerHTML =  "<img  src=\"images/product10.jpg\"/>";
	var target = "";
	for( var i = 0; i < 5; i++) {
		target += "<img src=\"images/product"+i+".jpg\"/>";
	}
	document.getElementById("smallimg").innerHTML = target;
});