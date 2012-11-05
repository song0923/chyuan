var QuickScrollYLast=0;
var OnlineChat=document.getElementById("OnlineChat");
window.setInterval("LoadMenu()",1);

function LoadMenu(){
    var QuickScrollYDefault;
    if(document.documentElement&&document.documentElement.scrollTop){
        QuickScrollYDefault=document.documentElement.scrollTop;
    }else if(document.body){
        QuickScrollYDefault=document.body.scrollTop;
    }else{
    }
    QuickPercent=.1*(QuickScrollYDefault-QuickScrollYLast);
    if(QuickPercent>0){
        QuickPercent=Math.ceil(QuickPercent);
    }else{
        QuickPercent=Math.floor(QuickPercent);
    }
    
    OnlineChat.style.top=parseInt(OnlineChat.style.top)+QuickPercent+"px";
    QuickScrollYLast=QuickScrollYLast+QuickPercent;
}

function ChangeMenu(){
    if(document.getElementById("ChatList").style.display == "none"){
		document.getElementById("ChatList").style.display="block"; 
        document.getElementById("ChatMenu").src=menuimg_path+"chat/Chat_Close.gif";
    }else{
        document.getElementById("ChatMenu").src=menuimg_path+"chat/Chat_Open.gif";
        document.getElementById("ChatList").style.display="none"; 
    }
}