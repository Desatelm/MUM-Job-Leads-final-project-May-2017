
currentpage = 1;
$(function() {
	$("#jobOfferBtn").click(displayJobOffer);
	$("#jobSeekBtn").click(displayJobSeek);
	$("#weatherInfoBtn").click(displayWeatherInfo);	
	$("#postSubmit").click(uploadPost);
    
	postJob(currentpage);
	$(window).scroll(function(){
		if($(window).scrollTop() == $(document).height()-$(window).height()){
			currentpage += 1;
			postJob();
		}	
		});

});


function displayJobOffer() {

	document.getElementById("jobOffer").style.display = "block";
	document.getElementById("jobSeek").style.display = "none";
	document.getElementById("weatherInfo").style.display = "none";
}
function displayJobSeek() {

	document.getElementById("jobOffer").style.display = "none";
	document.getElementById("jobSeek").style.display = "block";
	document.getElementById("weatherInfo").style.display = "none";
}
function displayWeatherInfo() {
	document.getElementById("jobOffer").style.display = "none";
	document.getElementById("jobSeek").style.display = "none";
	document.getElementById("weatherInfo").style.display = "block";

}

function uploadPost() {	
	$.ajax( "CreatePost", {
		    "type" : "post",
		    "data" : {
		    "postlead" : $("#offersTextArea").val()
		   /// "location" : last
		}
	}).done(addPost);

}

function postJob() {
	var root = 'http://jsonplaceholder.typicode.com';
	var userID = $('#locationSearch').val();
	
	$.ajax(root + '/posts/', {

		/*data : {
			userId : 3,	
			
		}*/
		 "type" : "Get"

	}).done(displayPost);

}
function displayPost(data) {
	var pageNum = currentpage*15;	
	var post = $('<div>');
	for (var i = 0; i < pageNum; i++) {
		post.append($('<p>', {
			'attr' : {
				class : 'form-inline'
			},
			'html' : data[i].body,
			'css' : {
				'font-size' : '16px'
			}
		}));

		post
				.append($(
						'<a>',
						{
							'attr' : {
								class : 'form-inline,form-inline, glyphicon glyphicon-thumbs-up'
							},
							'html' : 'Like',
							'css' : {
								'margin-bottom' : '10px'
							}

						}));

		post.append($('<a>', {
			'attr' : {
				class : 'form-inline,form-inline, glyphicon glyphicon-comment '
			},
			'html' : 'Comments',
			'css' : {
				'margin-left' : '10px',
				'margin-bottom' : '10px'
			}

		}));
		post
				.append($(
						'<a>',
						{
							'attr' : {
								class : 'form-inline, pull-right btn-default, glyphicon glyphicon-map-marker',
								'aria-hidden' : "true"
							},
							'html' : $("#locationSearch").val(),
							'css' : {
								'margin-bottom' : '10px'
							}
						}));
		post.append($('<p>'));
		post.append($('<input>', {
			'attr' : {
				class : 'form-control'
			},
			'type' : 'text',
			'placeholder' : 'write Comment...',
			'css' : {
				'margin-bottom' : '10px'
			}
		}));

	}

	$("#divPost").html(post);

}
function addPost(data) {
		
	var post = $('<div>');	
	post.append($('<p>', {		'attr' : {
			class : 'form-inline'
		},
		'html' : data.post,
		'css' : {
			'font-size' : '16px'
		}
	}));

	post.append($('<a>', {
		'attr' : {
			class : 'form-inline,form-inline, glyphicon glyphicon-thumbs-up'
		},
		'html' : 'Like ' + data.noOfLIkes,
		'css' : {
			'margin-bottom' : '10px'
		}

	}));

	post.append($('<a>', {
		'attr' : {
			class : 'form-inline,form-inline, glyphicon glyphicon-comment '
		},
		'html' : 'Comments ' + data.noOfComments,
		'css' : {
			'margin-left' : '10px',
			'margin-bottom' : '10px'
		},
		'click' : function(){
			var post = $('<ul>');
			for(var i = 0; i < data.comments.length; i++){
									
					post.append($('<li>', {
						'html': data.comments[i].comment
					}));		
								
					post.append($('<br>'));
				}
				$("#comments").html(post);
			}
	  }));
	post.append($('<span>', {
		'attr' : {
			class : 'form-inline'
		},
		'html' : data.postDate,
		'css' : {
			'margin-left' : '10px',
			'margin-bottom' : '10px'
		}

	}));
	
	post.append($('<button>', {
		'attr' : {
			class : 'form-inline, pull-right btn-default'
		},
		'html' : 'delet',
		'click' : function(){
			$("#addPost").empty();
		},
		'css' : {
			'margin-bottom' : '10px',
			'margin-left' : '10px'	
		}
	}));

	post.append($(
					'<a>',
					{
						'attr' : {
							class : 'form-inline, pull-right btn-default, glyphicon glyphicon-map-marker',
							'aria-hidden' : "true"
						},
						'html' : data.location,
						'css' : {
							'margin-bottom' : '10px'
						}
					}));
	post.append($('<p>'));
	post.append($('<input>', {
		'attr' : {
			class : 'form-control'
		},
		'type' : 'text',
		'placeholder' : 'write Comment...',
		'css' : {
			'margin-bottom' : '10px'
		}
	}));

	//}

	$("#addPost").html(post);

}
function postJobScroll() {
	while ($(window).scrollTop() + $(window).height() >= $(document).height()) {
		$(document.body).append($('<div>').addClass('divPost'));
	}
}