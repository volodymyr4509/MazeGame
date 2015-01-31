/**
 * Created by Home on 31.01.2015.
 */
$( document ).ready(function() {
    function loadProfileInfo(){
        $.ajax({
            type:"GET",
            url: "/profile",
            dataType: 'json',
            data: myJson,
            contentType: 'application/json; charset=utf-8',
            async: true,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
            cache: false,    //This will force requested pages not to be cached by the browser
            processData:false, //To avoid making query String instead of JSON
            success: function (playerInfo) {
                console.log("Player: " + playerInfo);
            },
            error: function (e) {
                console.log('error during loading player: ' + e);
            }
        });
    }


});