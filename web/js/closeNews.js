 
window.onload = function(){
    
    var news = document.querySelector('.news');;
        
    news.onclick = function(event){
        
        var event = event || window.event;
        var target = event.target || event.srcElement;
        
        if (target.nodeName != 'STRONG')
            return;
        
        var targetNews = target.parentElement.parentElement;
        
        animate ({
          duration : 3000,
          timing :  bounce,

          drow : function(progress){
            var div = document.getElementById('move');
            
            var heightHeaders = document.querySelector('.header').offsetHeight;
            var heightHr = document.querySelector('.partition').offsetHeight;
            var heightLargePhoto = document.querySelector('.largePhoto').style.height;
              
            var marginTop = targetNews.style.marginTop;
              
            var awys = window.innerHeight - targetNews.offsetHeight - 25 - 150 - heightHeaders - heightHr;
            
            
              
            targetNews.style.left = progress * awys * 5 + 'px';
          },
            
          endAnimate : function(){
                  setTimeout(function(){targetNews.remove();},1000);
          }    
        });
        

           
            
    };
        
     function makeEaseOut(timing) {
      return function(timeFraction) {
        return 1 - timing(1 - timeFraction);
      }
    };

    function bounce(timeFraction) {
      for (var a = 0, b = 1, result; 1; a += b, b /= 2) {
        if (timeFraction >= (7 - 4 * a) / 11) {
          return -Math.pow((11 - 6 * a - 11 * timeFraction) / 4, 2) + Math.pow(b, 2);
        }
      }
    };

    var bounceEaseOut = makeEaseOut(bounce);
    
    
}; 
 

