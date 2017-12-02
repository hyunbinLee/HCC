/**
 * 
 */
function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}


function showBlamePopup(blame_gubun){
	var blame_code;
	
	blame_code = getParameterByName('seq');
	
	window.open("./blamePopup?code="+blame_code+"&gubun="+blame_gubun,"a","width=400, height=300, left=100,top=50");
}

function insertBlameAction(){
	var blame_code;
	var blame_gubun;
	var blame_type;
	var blame_content;
	
	blame_code = getParameterByName('code');
	blame_gubun = getParameterByName('gubun');
	blame_type = document.getElementById('blame_type').value;
	blame_content = document.all["blame_content"].value;
	
	location.href="./Declaration?code="+blame_code+"&gubun="+blame_gubun+"&type="+blame_type+"&content="+blame_content;
	
}