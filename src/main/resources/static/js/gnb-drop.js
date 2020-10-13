/**
 * NAME    : 서브메뉴 slideMenu
 * AUTHOR  : 조재청
 * CONTACT : nick2615@naver.com
 */

$(function(){
	//처음로딩시
	//*
	$("#drop-menu").hide();
	var check=true;
	//gnb클릭시 토글처리
	$("#gnb").click(function(){
		if(check){
			$("#drop-menu").stop().slideDown(500);
			check=false;
		}else{
			$("#drop-menu").stop().slideUp(500);
			check=true;
		}
	});
	//*/
});
////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
