$(function(){
	$("#jobOfferBtn").click(displayJobOffer);
	$("#jobSeekBtn").click(displayJobSeek);
	$("#weatherInfoBtn").click(displayWeatherInfo);
	alert("hi");
});

function displayJobOffer(){
	
	document.getElementById("jobOffer").style.display = "block";
	document.getElementById("jobSeek").style.display = "none";
}
function displayJobSeek(){
	
	document.getElementById("jobOffer").style.display = "none";
	document.getElementById("jobSeek").style.display = "block";
}