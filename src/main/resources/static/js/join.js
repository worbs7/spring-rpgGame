
					var idResult_1=false;//패턴일치
					var idResult_2=false;//중복체크
					var pwResult_1=false;//패턴일치
					$(function(){
						//비밀번호 체크
						$(".guide-msg").hide();
						$("#pw").keyup(function(){
							var in_str=$("#pw").val().trim();
							$(".guide-msg").show();
							pwResult_1 = engNumMixCheck(in_str);
							if( pwResult_1 ){
								$(".guide-msg").removeClass("bad");
								$(".guide-msg").addClass("good");
							}else{
								$(".guide-msg").removeClass("good");
								$(".guide-msg").addClass("bad");
							}
						});
						///////////////////
						//비밀번호 확인////////
						$(".pw2-guide").hide();
						$("#pw2").focusout(function(){
							$(".pw2-guide").show();
							var in_str1=$("#pw").val().trim();
							var in_str2=$("#pw2").val().trim();
							if(in_str1!="" && in_str1==in_str2){
								$(".pw2-guide .case1").removeClass("bad");
								$(".pw2-guide .case1").addClass("good");
							}else{
								$(".pw2-guide .case1").removeClass("good");
								$(".pw2-guide .case1").addClass("bad");
							}
						});
						////////////////
						$(".name-guide").hide();
						$("#name").focusout(function(){
							$(".name-guide").show();
							var in_str=$("#name").val().trim();
							
							if(in_str.length>0){
								$(".name-guide .case1").removeClass("bad");
								$(".name-guide .case1").addClass("good");
							}else{
								$(".name-guide .case1").removeClass("good");
								$(".name-guide .case1").addClass("bad");
							}
						});
						
						///////이메일체크/////////
						$(".email-guide").hide();
						$("#email").focusout(function(){
							var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
							$(".email-guide").show();
							var in_str=$("#email").val().trim();
							
							if( regExp.test(in_str) ){
								$(".email-guide .case1").removeClass("bad");
								$(".email-guide .case1").addClass("good");
							}else{
								$(".email-guide .case1").removeClass("good");
								$(".email-guide .case1").addClass("bad");
							}
						});
						


					});
					
					function engNumMixCheck( in_str ){
						if(in_str.length>=6){
							var checkNumber=/[0-9]/g;
							var checkEnglish=/[A-Za-z]/ig;
							var checkSpecial=/[^A-Za-z0-9]/ig;
							var checkAscii=/[^a-zA-Z0-9~`!>@?/<#"'\$;:\]%\.\^,&\[*()_\+\-=|\\{}]/ig;
							var result1=in_str.search( checkNumber );//0~ :숫자포함
							var result2=in_str.search( checkEnglish );//0~ :영문자포함
							var result3=in_str.search( checkSpecial );//-1 :특수문자체크
							var result4=in_str.search( checkAscii );//-1 :아스키체크
							//alert(result1 +":"+ result2 +":"+ result3 +":"+result4);
							if(result1 >=0 && result2>=0 && result3 ===-1 && result4 ===-1){
								return true;//허용하는 문자열
							}else{
								return false;//규칙위반
							}
						}else{
							return false;//자리수부족
						}
					}
					
				</script>