/**
 * Created by Home on 31.01.2015.
 */
$( document ).ready(function() {
    //TODO: get current player from backend/not from html div;
    var currentPlayerNickname = $("#currentPlayerNickName").text();

    loadProfileInfo(currentPlayerNickname);

    function loadProfileInfo(nickname){
        $.ajax({
            type:"GET",
            url: "/profile/"+nickname,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            async: true,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
            cache: false,    //This will force requested pages not to be cached by the browser
            processData:false, //To avoid making query String instead of JSON
            success: function (playerInfo) {
                fillPlayerDetails(playerInfo.playerDetails);
                fillCurrentPlayerState(playerInfo.currentPlayerState);
            },
            error: function (e) {
                console.log('error during loading player: ' + e.toString());
            }
        });
    }

    function fillPlayerDetails(playerDetails){
        $("#playerhealth").append(playerDetails.health);
        $("#playermuscle").append(playerDetails.muscle);
        $("#playerwins").append(playerDetails.win);
        $("#playerloses").append(playerDetails.lose);
    }
    function fillCurrentPlayerState(currentPlayerState){
        $("#currentplayerhealth").append(currentPlayerState.currentPlayerHealth);
        $("#currentplayermuscle").append(currentPlayerState.currentPlayerMuscle);
        $("#infight").append(currentPlayerState.inFight);
    }

});