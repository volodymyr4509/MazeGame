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
        //if the user select two radios - post a kick and uncheck radios.
        if(checkedRadios.length == 2){
            postKick(checkedRadios);
            setTimeout(function () {
                checkedRadios.filter("[name=attack]").removeAttr("checked");
                checkedRadios.filter("[name=block]").removeAttr("checked");
            }, 500);

        }
    });

    function postKick(checkedRadios) {
        var kickparam = '{"'+ checkedRadios[0].name + '":' + checkedRadios[0].value + ', "' + checkedRadios[1].name + '":' + checkedRadios[1].value + '}';
        console.log("data: "+kickparam);
            $.ajax({
                type:"POST",
                url: "/kick",
                dataType: 'json',
                data: kickparam,
                contentType: 'application/json; charset=utf-8',
                async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
                cache: false,    //This will force requested pages not to be cached by the browser
                processData:false, //To avoid making query String instead of JSON
                success: function (response) {
                    console.log("kick was posted: " + response);
                },
                error: function (e) {
                    console.log('cannt save kick: ' + e);
                }
        });
    }

    function postFight() {
        var myJson = '{"monsterNickname":"bat"}';
        console.log("data: "+myJson);
        $.ajax({
            type:"POST",
            url: "/beginfight",
            dataType: 'json',
            data: myJson,
            contentType: 'application/json; charset=utf-8',
            async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
            cache: false,    //This will force requested pages not to be cached by the browser
            processData:false, //To avoid making query String instead of JSON
            success: function (response) {
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