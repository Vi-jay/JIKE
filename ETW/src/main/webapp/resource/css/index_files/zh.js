var json;
var ji = 0;
function clvideo(data){if(json==undefined){json=data}if(ji==5){ji=0}try{$("#cloudvideo").html("<a target=\"_blank\" href='"+decodeURI(json[0][ji].url)+"'><img src='"+decodeURI(json[0][ji].apipic)+"' /></a>");ji++}catch(e){}}

function Setvideo() {
    $.getJSON("https://www.etwcloudtv.com/api/newsVideo", function(data) {
        //clvideo(data);
		getplaydata(data);
        //setInterval("clvideo()", 5e3);
    });
}
if($(".video-wrap").length >0)
{
   window.onload = Setvideo();
}

var videoMuteState = true;
var headerVideos_PlayListNitems = 0;
var playlistCounter = 0;
function getplaydata(data) {
    if (json == undefined) {
        json = data
    }
    headerVideos_PlayListNitems = json[1].length;
    if (!$('html').hasClass('lt-ie9')) {
        var w = jQuery(window).width();
        var autoplay = 'autoplay';
        if (w < 768) {
            autoplay = '';
        }
        $('.video-wrap').html("");
        $('.video-wrap').prepend('<video ' + autoplay + ' muted="' + videoMuteState + '" poster="' + json[1][playlistCounter].playpic + '" onended="videoEnded()"><source src="https://www.etwinternational.cn/etwvideo/' + json[1][playlistCounter].video + '-s.webm" type="video/webm"></source><source src="https://www.etwinternational.cn/etwvideo/' + json[1][playlistCounter].video + '-s.mp4"></source></video>');
        if (w >= 992) {
            $(".news-area-play-btn").show();
            $(".news-area-mute-btn").show()
        }
        $(".news-area-play-btn a").attr("href", json[1][playlistCounter].url);
        playlistCounter++
    }
}

function videoEnded() {
	if (playlistCounter == headerVideos_PlayListNitems) {
		playlistCounter = 0
	}
	jQuery('.video-wrap video').attr("poster",json[1][playlistCounter].playpic);
	jQuery('.video-wrap video source').eq(0).attr("src",'https://www.etwinternational.cn/etwvideo/' + json[1][playlistCounter].video + '-s.webm');
	jQuery('.video-wrap video source').eq(1).attr("src",'https://www.etwinternational.cn/etwvideo/' + json[1][playlistCounter].video + '-s.mp4');
	jQuery(".news-area-play-btn a").attr("href", json[1][playlistCounter].url);
    jQuery('.video-wrap video').load();
    jQuery('.video-wrap video').prop('muted', videoMuteState);
	playlistCounter++
}

jQuery(function(){jQuery('.mute-btn').click(function(event){event.preventDefault();if(videoMuteState==false){$('video').prop('muted',true);$('.mute-btn i').removeClass();$('.mute-btn i').addClass('fa fa-volume-off');videoMuteState=true}else{$('video').prop('muted',false);$('.mute-btn i').removeClass();$('.mute-btn i').addClass('fa fa-volume-up');videoMuteState=false}})});

jQuery(window).resize(function() {
    if ($(".video-wrap").length > 0) {
        var w = jQuery(window).width();
        if (w < 992) {
            $(".news-area-play-btn").hide();
            $(".news-area-mute-btn").hide()
        } else {
            $(".news-area-play-btn").show();
            $(".news-area-mute-btn").show()
        }
        if (w < 768) {
            $('video').trigger('pause');
            $('video').prop('muted', true)
        } else {
            $('video').trigger('play');
            $('video').prop('muted', videoMuteState)
        }
    }
});






jQuery(function() {
    var phpcountry = getCookie("phpcountry");
    if (phpcountry == "") {
        var jsonp = document.createElement("script");
        jsonp.type = "text/javascript";
        jsonp.src = "http://jsq.etwservice.com/index.php?index";
        document.getElementsByTagName("head")[0].appendChild(jsonp);
    }
    else {
        urljson(phpcountry);
    }


    $("body").on("change", "#selectlang", function() {
        var val = $(this).val();
        setCookie("phpcountry", val, 24);
        location.reload();
    });
    $("body").on("click", "#closeselectlang", function() {
        $("body").find(".showlang").remove();
        //setCookie("phpcountry", "cn", 1);
    });

    $("body").on("click",".btnlogininfo",function(){var username=$("#username").val();var password=$("#password").val();if(username==""&&password==""){$(".logintips").html("用户名或密码不能为空!")}else{$(".btnlogininfo").attr("disabled",true);$(".logintips").html('<img height="22" width="22" src="content/etwuser/img/loadding.gif" alt=""/> 正在登陆，请稍等。。。');var Parameter="username="+username+"&password="+password;$.ajax({type:"POST",url:"/?index/login",cache:false,async:false,data:Parameter,datatype:"html",success:function(data){$(".logintips").html("");var arr=data.split("|");if(arr.length==3){$(".btnlogincode").attr("data-val",data);$("#tel").val(arr[2]);$(".logininfo").hide();$(".logincode").fadeIn(100)}else if(arr.length==3){$(".logintips").html(arr[1]+",手机号码："+arr[2])}else if(data=="000000"){$(".logintips").html("用户名或密码不能为空!")}else if(data=="222222"){$(".logintips").html("用户名或密码错误")}else{window.location.href=data}$(".btnlogininfo").attr("disabled",false)}})}}),$(document).keyup(function(e){var username=$("#username").val();var password=$("#password").val();if(e.keyCode==13&&username!=""&&password!=""){if($(".logininfo").is(":visible")){$(".btnlogininfo").trigger("click")}}});

    $("body").on("click",".btnlogincode",function(){var tel=$("#tel").val();var code=$("#code").val();var val=$(this).attr("data-val");if(code==""){$(".logintips").html("验证码不能为空!")}if(tel==''){$(".logintips").html('请输入手机号码')}else if(tel.length!=11){$(".logintips").html('手机号码格式不正确!')}else{$(".btnlogincode").attr("disabled",true);$(".logintips").html('<img height="22" width="22" src="content/etwuser/img/loadding.gif" alt=""/> 正在验证，请稍等。。。');var Parameter="tel="+tel+"&code="+code+"&val="+val;$.ajax({type:"POST",url:"/?index/logincode",cache:false,async:false,data:Parameter,datatype:"html",success:function(data){$(".logintips").html("");if(data=="000000"){$(".logintips").html("验证码不能为空!")}else if(data=="222222"){$(".logintips").html("验证码错误")}else if(data=="444444"){$(".logintips").html("您输入的手机号码未绑定!")}else if(data=="555555"){$(".logintips").html("请先发送验证码!")}else if(data=="333333"){$(".logintips").html("验证码已经过期，请重新发送!")}else{window.location.href=data}$(".btnlogincode").attr("disabled",false)}})}});

    $("body").on("click",".btntelsend",function(){var tel=$("#tel").val();if(tel==''){$(".logintips").html('请输入手机号码')}else if(tel.length!=11){$(".logintips").html('手机号码格式不正确!')}else{var val=$(".btnlogincode").attr("data-val");$(".logintips").html('<img height="22" width="22" src="content/etwuser/img/loadding.gif" alt=""/> 正在发送验证码，请稍等。。。');var Parameter="tel="+tel+"&val="+val;$.ajax({type:"POST",url:"/?index/againcode",cache:false,async:false,data:Parameter,datatype:"html",success:function(data){$(".logintips").html("");var arr=data.split("|");if(data=="000000"){$(".logintips").html("未知客户")}else if(data=="222222"){$(".logintips").html("您输入的手机号码未绑定！")}else if(arr.length==3){$(".logintips").html(arr[1]+",手机号码："+arr[2])}else if(data=="111111"){settime()}}})}});

});
var countdown=60;
function settime(){if(countdown==0){$(".btntelsend").attr("disabled",false);$(".btntelsend").html("发送");countdown=60;return}else{$(".btntelsend").attr("disabled",true);$(".btntelsend").html("重发("+countdown+")");countdown--}setTimeout(function(){settime()},1000)}


function urljson(data) {
    var php_country = getCookie("php_country");
    if ((data.country == "" || data.country == "cn" || data.country == "unkown address") && php_country == '') {
        setCookie("phpcountry", "cn", 24);
    }
    else if (data.country == "tw" || php_country == "tw") {
        if (data.country == "tw") {
            setCookie("phpcountry", "tw", 24);
            setCookie("php_country", "tw", 24);
        }
        var selected = '';
        if (data == 'tw') {
            selected = 'selected="selected"';
        }
        var html = "<div style='float:right;'>网页语言：<select style='font-size:12px;' id='selectlang'><option value='cn'>简体中文</option><option value='tw' " + selected + ">繁体中文</option></select><span style='font-size:16px; padding-left:10px;cursor:pointer;' id='closeselectlang'>×</span></div>";
        jQuery(document.body).append("<div class='showlang' style='width:auto;max-width:200px;height:auto; padding:5px 10px; border-top:1px #a1a294 solid; border-bottom:1px #a1a294 solid;background:#ffffe1;position:fixed; top:2px; right:15px; z-index:9999;'>" + html + "</div>");
    }
}


//设置Cookie
function setCookie(c_name, value, expireh) {
    var exdate = new Date();
    exdate.setTime(exdate.getTime() + expireh*60*60*1000);
    document.cookie = c_name + "=" + escape(value) + (expireh == null ? "" :";expires=" + exdate.toGMTString());
}

//获取cookie
function getCookie(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=");
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1;
            c_end = document.cookie.indexOf(";", c_start);
            if (c_end == -1) c_end = document.cookie.length;
            return unescape(document.cookie.substring(c_start, c_end));
        }
    }
    return "";
}

function delCookie(name)
{
   var exp = new Date();
   exp.setTime(exp.getTime() - 1);
   var cval=getCookie(name);
   if(cval!=null)
   document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}

