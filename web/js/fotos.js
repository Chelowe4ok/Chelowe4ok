
var photosDiv = document.getElementById('fotos');

var photo ={ 
	photos : ['../1.jpg','../2.jpg','../3.jpg','../4.jpg','../5.jpg','../6.jpg'],
	photosTitle : ['../1.jpg','../2.jpg','../3.jpg','../4.jpg','../5.jpg','../6.jpg'],
	currentPhotos : 0,
	
	add : function(){
		
		for (var index = 0; index < this.currentPhotos; index++){
			var a = document.createElement('a');
			a.href = '#';
			a.title = this.photosTitle[index];
			var img = document.createElement('img');
			img.src = this.photos[index];
			img.alt = this.photosTitle[index];			
			a.appendChild(img);
			photosDiv.appendChild(a);	
		} 
	}
}

var calculationCurrentPhotos = function(){
	var widthDiv = photosDiv.offsetWidth;
	var temp = 0;
	for (var index = 0; index < photo.photos.length; index++){
		var widthImg = calculationWidthFoto(photo.photos[index]);
		
		temp = temp + widthImg;
		
		if (temp < widthDiv){
			photo.currentPhotos++;
			
		}else{
			break;
		}
	};
	
};

var calculationWidthFoto = function(photoSrc){
	var width1 = photosDiv.offsetWidth;
	var height1 = photosDiv.offsetHeight;

	var img1 = imgSize(photoSrc);
	
	var widthImg1 = img1[0];
	var heightImg1 = img1[1];
	
	var procentChangeHeight = (1 - height1 / heightImg1) * 100;
	
	var widthAfterChangeHeight = widthImg1 * (1 - procentChangeHeight / 100);
	
	return widthAfterChangeHeight;
}



var imgSize = function(href){
	var img = new Image();
	
	var size = [];
	img.onload = function(){
		
	};
	
	img.src = href;
	size.push(img.width);
	size.push(img.width);
	return size;
	
}


window.onload = function(){
	photo.currentPhotos = 6;
	photo.add();
};

