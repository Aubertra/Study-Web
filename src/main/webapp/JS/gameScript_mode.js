window.onload=function(){
    var audio = document.getElementById('BGmusic');
    var audioparent = audio.parentNode;
    
    document.addEventListener('visibilitychange',function(){
        if(document.visibilityState === "hidden")
        {
            audioparent.removeChild(audio);
        }else{
            audioparent.appendChild(audio);
        }
    });
};