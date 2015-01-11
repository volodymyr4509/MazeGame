$( document ).ready(function() {

    //begin fight
    $(document).on("fight", processFight);

    function processFight(event){
        console.log("begin processfight");
        postFight();
        beginFight(event);
        enableForm();

    }

    function beginFight(event) {
        console.log("beginFight: monster " + event.message + " attack you");
        $("#monsterAvatarID").prop("src", "/resources/avavovk.jpg");

    }

    $("input:radio").click(function(){
        console.log("you checked radio buttonID: " + $("input:radio:checked"));
        var checkedRadios = $("input:radio:checked");
        if(checkedRadios.length == 2){
            postKick();
        }
    });

    function postKick() {
        $.ajax({
            type: "POST",
            url: "/kick",
            data: $("#fightOptionID").serialize(),
            success: function (response) {
                // we have the response
                console.log("Response : " + response);
            },
            error: function (e) {
                console.log("Kick failed: " + e.toString());
            }
        });
    }

    function postFight() {
        $.ajax({
            type: "POST",
            url: "/createNewFight",
            data: "vkret, vovk",
            success: function (response) {
                // we have the response
                console.log("fight was saved: " + response);
            },
            error: function (e) {
                console.log('cannt save fight: ' + e);
            }
        });
    }

    function disableForm() {
        $("#fightOptionID :input").prop("disabled", true);
    }

    function enableForm() {
        $("#fightOptionID :input").prop("disabled", false);
    }



    disableForm();

});