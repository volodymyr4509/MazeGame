$( document ).ready(function() {

    //begin fight
    $(document).on("fight", beginFight);

    function beginFight(event) {
        enableForm();
        console.log("beginFight: monster " + event.message + " attack you");
        $("#monsterAvatarID").prop("src", "/resources/avavovk.jpg");

    }

    $("input:radio").click(function(){
        var checkedRadios = $("input:radio:checked");
        if(checkedRadios.length == 2){
            postKick();
        }
    });

    function postKick() {
        $.ajax({
            type: "GET",
            url: "/kick",
            data: $("#fightOptionID").serialize(),
            success: function (response) {
                // we have the response
                console.log("Response : " + response);
            },
            error: function (e) {
                console.log(e.toString());
                alert('Error: ' + e);
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