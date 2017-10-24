/**
 * 
 */


	
	function Open() 
    { 
        document.getElementById('test1_1').style.display='none'; 
        document.getElementById('test1_2').style.display=''; 
		document.getElementById('post_bottom_text').innerHTML='<a href="javascript:Close();" >댓글닫기</a>';
    } 
    function Close() 
    { 
        document.getElementById('test1_2').style.display='none'; 
        document.getElementById('test1_1').style.display=''; 
		document.getElementById('post_bottom_text').innerHTML='<a href="javascript:Open();">댓글열기</a>';
    } 
	
	function testInnerHTML(i,comment,seq,register_seq3){

    	var str = "";

    	str +=  '<textarea id="update_text'+i;
    	str +=  '" name="update_text'+i;
    	str +=  '" class="comment" maxlength="250" >';
    	str +=  comment;
    	str +=  '</textarea>';
    	str +=  '<input type="button" id="comment_btn" onClick="javascript:updateComment(';
    	str +=	"'update_text"+i;    
    	str +=	"','"+seq;    
    	str +=	"','"+register_seq3;    
    	str +=  "')";
    	str +=  '" value="Update">';
    	  
    	document.getElementById("inHere"+i).innerHTML = str;

    }
    
    function cencleInnerHTML(i,comment){

    	var str = "";

    	str +=  '<a>';
    	str +=  comment;
    	str +=  '</a>';

    	document.getElementById("inHere"+i).innerHTML = str;
    		
	}