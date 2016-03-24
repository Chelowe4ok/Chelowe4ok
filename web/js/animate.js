    function animate(option){
      
      var startTime = performance.now();
      
      requestAnimationFrame( function animate(time){
        
        var timeFraction = (time - startTime) / option.duration;
        
        if (timeFraction > 1){
          timeFraction = 1;
          option.endAnimate();
        }
        
        var progress = option.timing(timeFraction);
        
        option.drow(progress);
        
        if (timeFraction < 1){
          requestAnimationFrame(animate);
        }
        
      });
      
    };