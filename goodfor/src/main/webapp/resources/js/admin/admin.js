"use strick"
var admin = admin || {}

admin = (()=>{
	
	const WHEN_ERR = '호출하는 JS파일을 찾지 못했습니다.'
		
	let _, js, css, img, brd_vue_js, navi_vue_js
	
	let init = ()=>{
		_=$.ctx()
		js=$.js()
		css=$.css()
		img=$.img()
		brd_vue_js = js+'/vue/brd_vue.js'
		navi_vue_js = js+'/vue/navi_vue.js'
		
	}
	
	let onCreate = ()=>{
		alert('관리자 화면으로 이동합니다.')
		init()
		$.when(
			$.getScript(brd_vue_js),
			$.getScript(navi_vue_js)
		).done(()=>{
			setContentView()
			//navi.onCreate()
		}).fail(()=>{
			alert(WHEN_ERR)
		})
	}
	
	let setContentView = ()=>{
		
		/*$('head').html('<head>'+
				'<meta charset="utf-8">'+
			    '<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">'+
				'    <meta name="description" content="">'+
				'    <meta name="author" content="">'+
			    '<link rel="icon" href="https://getbootstrap.com/docs/4.0/assets/img/favicons/favicon.ico">'+
				'    <title>Offcanvas template for Bootstrap</title>'+
				'    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/offcanvas/">'+
				'    <!-- Bootstrap core CSS -->'+
			    '<link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">'+
				'    <!-- Custom styles for this template -->'+
				'    <link href="https://getbootstrap.com/docs/4.0/examples/offcanvas/offcanvas.css" rel="stylesheet">'+
				'<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">'+
				'  </head>')*/
				
		//$('head').html(brd_vue.brd_head({css: $.css(), img: $.img()}))		

		//$('body').html(navi_vue.navi_body({cxt: '/web', css: $.css(), img: $.img()}))
				
		$('body').empty()
		$(navi_vue.navi_body()).appendTo('body')
						
		$('<table id="tab"><tr></tr></table>')
			.css({ border: '1px solid black', width: '80%', height : '90%', margin : '0 auto'})
			.appendTo('body')
			
		//let arr1 = [{id : 'left',width : '20%'},{id : 'right', width : '80%'}]
		
		//let arr2 = ['15%','85%']
		
		$.each([{id : 'left',width : '20%'},{id : 'right', width : '80%'}], (i,j)=>{
			$('<td id="'+j.id+'"></td>')
			.css({border: '2px solid black', width: j.width, 'vertical-align':'top'})
			.appendTo('#tab tr')
		})
			
		$.each([{txt : '웹크롤링', name : 'web_crawl'},
				{txt : '고객관리', name : 'cusmgt'},
				{txt : '커뮤니티 관리', name : 'cummgt'},
				{txt : '상품조회', name : 'itemsrch'},
				{txt : '상품관리', name : 'itemmgt'},
				{txt : '상품삭제', name : 'itemdel'}],
			(i,j)=>{
				$('<div name="'+j.name+'">'+j.txt+'</div>')
				.css({border: '2px solid blue', margin : '0 auto', 'line-height':'50px'})
				.appendTo('#left')
				.click(function(){
					$(this).addClass('active')
					$(this).siblings().removeClass('active')
					switch($(this).attr('name')){
					case 'web_crawl':
						web_crawl()
						break;
					case 'cusmgt':
						cusmgt()
						break;
					case 'cummgt':
						cummgt()
						break;
					case 'itemsrch':
						itemsrch()
						break;
					case 'itemmgt':
						itemmgt()
						break;
					case 'itemdel':
						itemdel()
						break;
					}
					
				})
			})

		let web_crawl=()=>{
			
			$('<form id="crawl_form" class="form-inline my-2 my-lg-0" action="/action_page.php">'+
			'  <select name="site" size="1">'+
			'  </select>'+
			'  <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">	'+
			'</form>')
			.appendTo('#right')
			
			$.each([ {name : 'naver', nick : '네이버'},
					 {name : 'google', nick : '구글'},
					 {name : 'daum', nick : '다음'},
					 {name : 'youtube', nick : '유투브'} ],
					(i,j)=>{
						$('<option value="'+j.name+'">'+j.nick+'</option>')
						.appendTo('#crawl_form select')
					})
					
			$('<button>',{
				type : "submit",
				text : "Search"
			})
			.addClass('btn btn-outline-success my-2 my-sm-0')
			.appendTo('#crawl_form')
			.click(e=>{
				e.preventDefault()
				alert($('#crawl_form select').val()+' , '+ $('#crawl_form input').val())
				let arr = [$('#crawl_form select').val(), $('#crawl_form input').val()]
				if(!$.fn.nullChecker(arr)
				){
					$.getJSON(_+'/txctrls/'+arr[0]+'/'+arr[1],
						d=>{
							alert('AJAX 성공'+d.msg)
						})
				} //if end
				
				/*$.ajax({
					url : _+'/txctrls/'+$('#crawl_form input').val(),
					contentType : 'application/json',
					success : d => {
						alert('AJAX 성공')
					},
					error : e => {
						alert('AJAX 실패')
					}
				})*/
			})
			
		}	
			
		let cusmgt=()=>{

			alert('cusmgt 화면 들어옴')
			$('#right').empty()
			
			$('</br></br><a>DB 생성</a></br></br>')
			.appendTo('#right')
			.click(e=>{
				e.preventDefault()
				$.getJSON(_+'/cmm/create/db/', d=>{
					alert('DB 생성여부 : '+d.msg)
					})
			})
			$('<a>Customer Table 생성</a></br></br>')
			.appendTo('#right')
			.click(e=>{
				e.preventDefault()
				$.getJSON(_+'/customer/create/table/', d=>{
					alert('Table 생성여부 : '+d.msg)
					})
			})
			$('<a>Customer Table 삭제</a></br></br>')
			.appendTo('#right')
			.click(e=>{
				e.preventDefault()
				$.getJSON(_+'/customer/drop/table/', d=>{
					alert('Table 삭제여부 : '+d.msg)
					})
			})
			$('<a>고객명단 대량 등록</a></br></br>')
			.appendTo('#right')
			.click(e=>{
				e.preventDefault()
				$.getJSON(_+'/txctrls/register/users/', d=>{
					alert('고객명단 등록 고객수 : '+d.userCount)
				})
			})
			$('<a>Admin Table 생성</a></br></br>')
			.appendTo('#right')
			.click(e=>{
				e.preventDefault()
				$.getJSON(_+'/admins/create/table/', d=>{
					alert('Table 생성여부 : '+d.msg)
					})
			})
			$('<a>Admin Table 삭제</a></br></br>')
			.appendTo('#right')
			.click(e=>{
				e.preventDefault()
				$.getJSON(_+'/admins/drop/table/', d=>{
					alert('Table 삭제여부 : '+d.msg)
					})
			})
			$('<a>Admin 대량 등록</a></br></br>')
			.appendTo('#right')
			.click(e=>{
				e.preventDefault()
				$.getJSON(_+'/txctrls/register/admins/', d=>{
					alert('admin 등록 수 : '+d.userCount)
				})
			})
			
			/*$(brd_vue.customer_mgt()).appendTo('#right')*/
			
		}
		
		let cummgt=()=>{
			alert('cummgt 화면 들어옴')
			$('#right').empty()
			
			$('</br></br><a>커뮤니티 테이블 생성</a></br></br>')
			.appendTo('#right')
			.click(e=>{
				e.preventDefault()
				$.getJSON(_+'/community/create/table/', d=>{
					alert('커뮤니티 테이블 생성여부 : '+d.msg)
					})
			})
			$('</br></br><a>커뮤니티 테이블 삭제</a></br></br>')
			.appendTo('#right')
			.click(e=>{
				e.preventDefault()
				$.getJSON(_+'/community/drop/table/', d=>{
					alert('커뮤니티 테이블 삭제여부 : '+d.msg)
					})
			})
			$('<a>Community 대량 등록</a></br></br>')
			.appendTo('#right')
			.click(e=>{
				e.preventDefault()
				$.getJSON(_+'/txctrls/register/commt/', d=>{
					alert('commt 등록 수 : '+d.userCount)
				})
			})
		}
		
		let itemsrch=()=>{
			alert('itemsrch 화면 들어옴')
		}
		
		let itemmgt=()=>{
			alert('itemmgt 화면 들어옴')
		}
		
		let itemdel=()=>{
			alert('itemdel 화면 들어옴')
		}
		
		// $('#left').css({border: '2px solid black', width: '20%', 'vertical-align':'top'})	
			
		//$('#left div').css({border: '2px solid blue', margin : '0 auto', 'line-height':'50px'})
			
		
		/*$('<div id="adminclick1">고객관리</div>')
			.css({ border: '1px solid black', width: '100%', 'background-color': '#e3ffe0' , 
				   height : '50px', 'line-height':'50px' })
			.appendTo('#left')
			
		$('<div>상품관리</div>')
			.css({ border: '1px solid black', width: '100%',  'background-color': '#e3ffe0' , 
				   height : '50px', 'line-height':'50px'})
			.appendTo('#left')
		
		$('<div>수정</div>')
			.css({ border: '1px solid black', width: '100%',  'background-color': '#e3ffe0' , 
				   height : '50px', 'line-height':'50px'})
			.appendTo('#left')
			
		$('<div>추가</div>')
			.css({ border: '1px solid black', width: '100%',  'background-color': '#e3ffe0' , 
				   height : '50px', 'line-height':'50px'})
			.appendTo('#left')
		
		$('<div>삭제</div>')
			.css({ border: '1px solid black', width: '100%',  'background-color': '#e3ffe0' , 
				   height : '50px', 'line-height':'50px'})
			.appendTo('#left')*/
			
	}
	
	return {onCreate}
	
})();