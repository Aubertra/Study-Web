window.onload=function(){
    var audio=document.getElementById('BGmusic');

    document.addEventListener('visibilitychange',function(){
        if(document.visibilityState === 'hidden')
        {
            audio.volume = 0;
        }else if(document.visibilityState === 'visible')
        {
            audio.volume = 1;
        }
    });
};