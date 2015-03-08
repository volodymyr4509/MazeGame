$( document ).ready(function() {

    var canvas = document.getElementById("mazecanvas");
    var context = canvas.getContext("2d");
    var mazeWidth = 556;
    var mazeHeight = 556;
    var lastKeyDown;
    var players = [];

    function Dummy(x,y,name,speed,colour){
        this.x = x;
        this.y = y;
        this.size = 20;
        this.name = name;
        this.speed = speed;
        this.colour = colour;
        this.currentDirection = -1;
        this.backDirection = -1;


        this.draw = function (){
            context.beginPath();
            context.rect(this.x, this.y, this.size, this.size);
            context.closePath();
            context.fillStyle = this.colour;
            context.fill();
        };
        this.possibleDirections = function(){
            var possibleDirections = [];
            //UP
            if(this.y-this.speed >= 0){
                var imgDataUp = context.getImageData(this.x, this.y-this.speed, this.size, this.speed);
                var data = imgDataUp.data;
                if(analyzePixelsRange(data)){
                     //console.log("can move UP");
                    possibleDirections.push(0);
                }
            }
            //RIGHT
            if(this.x+this.speed <= mazeWidth){
                var imgDataRight = context.getImageData(this.x+this.size, this.y, this.speed, this.size);
                var data = imgDataRight.data;
                if(analyzePixelsRange(data)){
                    //console.log("can move RIGHT");
                    possibleDirections.push(1);
                }
            }
            //DOWN
            if(this.y+this.speed <= mazeHeight){
                var imgDataRight = context.getImageData(this.x, this.y+this.size, this.size, this.speed);
                var data = imgDataRight.data;
                if(analyzePixelsRange(data)){
                        //console.log("can move DOWN");
                        possibleDirections.push(2);
                }
            }
            //LEFT
            if(this.x-this.speed >= 0){
                var imgDataRight = context.getImageData(this.x - this.speed, this.y, this.speed, this.size);
                var data = imgDataRight.data;
                if(analyzePixelsRange(data)){
                        //console.log("can move LEFT");
                        possibleDirections.push(3);
                }
            }
            //console.log("Possible directions Monster: " + this.name + " : " + possibleDirections.toString());
            return possibleDirections;
        }
        this.setCurrentDirection = function(){
            var possibleDirs = this.possibleDirections();

            //console.log("possibleDirs: " + possibleDirs);
            if(possibleDirs.length > 1){
                var index = possibleDirs.indexOf(this.backDirection);
                possibleDirs.splice(index, 1);
            }
            this.currentDirection = possibleDirs[Math.floor(Math.random() * possibleDirs.length)];
        };
        this.getCurrentDirection = function(){
            return this.currentDirection;
        }
        this.setBackDirection = function(){
            var curDir = this.getCurrentDirection();
            this.backDirection = (curDir + 2 < 4) ? (curDir + 2) : (curDir - 2);
        }
        this.getBackDirection = function(){
            return this.backDirection;
        }

        this.takeStepForward = function(){
            this.setCurrentDirection();
            this.setBackDirection();
            makeWhite(this.x, this.y, this.size, this.size);
            if($.inArray(this.getCurrentDirection(), this.possibleDirections())>-1){
                switch (this.getCurrentDirection()){
                    case 0: this.y--; break;
                    case 1: this.x++; break;
                    case 2: this.y++; break;
                    case 3: this.x--; break;
                }
            }
            this.draw();
        }
        this.toString = function(){
            return "--- " +this.name+ "---" + "\nPossible Direction: " + this.possibleDirections() + "\nCurrentDirection: "+ this.getCurrentDirection()
            + "\nBack Direction: " + this.getBackDirection() + "\nPosition: x = " + this.x + ", y = "+ this.y + "\nSpeed: " + this.speed
                + "\nColour: " + this.colour;
        }
    }

    function drawMaze() {
        makeWhite(0, 0, canvas.width, canvas.height);
        var mazeImg = new Image();
        mazeImg.onload = function () {
            context.drawImage(mazeImg, 0, 0);
        };
        mazeImg.src = "/resources/maze.gif";
    }

    function makeWhite(x, y, w, h) {
        context.beginPath();
        context.rect(x, y, w, h);
        context.closePath();
        context.fillStyle = "white";
        context.fill();
    }

    function analyzePixelsRange(pixels){
        var blocker = false;
        for(var i=0; i<pixels.length; i+=4){
            if(pixels[i] == 255 && pixels[i+1] == 255 && pixels[i+2] == 255){ //white == can move
                continue;
            }else{
                if(pixels[i] == 255 && pixels[i+1] == 0 && pixels[i+2] == 0){ //red = hero
                     prepareFight();
                }
                blocker = true;
                break;
            }
        }
        return !blocker;
    }

    function setPlayerCurrentDirection (){
        switch (lastKeyDown) {
            case 38: // arrow up key
            case 87: // W key
                this.currentDirection = 0;
                break;
            case 37: // arrow left key
            case 65: // A key
                this.currentDirection = 3;
                break;
            case 40: // arrow down key
            case 83: // S key
                this.currentDirection = 2;
                break;
            case 39: // arrow right key
            case 68: // D key
                this.currentDirection = 1;
                break;
        }
    }
    window.addEventListener("keydown", function(){
        lastKeyDown = window.event.keyCode;
        hero.setCurrentDirection = setPlayerCurrentDirection;
        console.log("lastKeyDown: " + lastKeyDown);
    }, true);

    drawMaze();
    createTimer(0);
    disableForm();

    var hero = new Dummy(410,10,$("#currentPlayerNickName").text(),1,"#FF0000");
    hero.setCurrentDirection = setPlayerCurrentDirection;
    var ork = new Dummy(415,50, "ork", 1, "#0000FF");
    var goblin = new Dummy(415,100, "goblin", 1, "#0000FF");
    players.push(hero,ork,goblin);

    setInterval(
        function(){
            for(var i=0; i<players.length; i++){
                players[i].takeStepForward();
                //console.log(players[i].toString());
            }
        },150);

    ///////////////////////////////////////////////////////////////////////////
                                 //TIMER//
    //////////////////////////////////////////////////////////////////////////
    function createTimer(seconds) {
        setInterval(function () {
            var clock = document.getElementById("clock");
            var clockContext = clock.getContext("2d");
            clockContext.beginPath();
            clockContext.rect(0, 0, clock.width, clock.height);
            clockContext.closePath();
            clockContext.fillStyle = "white";
            clockContext.fill();
            clockContext.font = "20px Arial";
            clockContext.fillStyle = "green";
            clockContext.textAlign = "center";
            clockContext.textBaseline = "middle";
            var minutes = Math.floor(seconds / 60);
            var secondsToShow = (seconds - minutes * 60).toString();
            if (secondsToShow.length === 1) {
                secondsToShow = "0" + secondsToShow; // if the number of seconds is '5' for example, make sure that it is shown as '05'
            }
            clockContext.fillText(minutes.toString() + ":" + secondsToShow, clock.width / 2, clock.height / 2, clock.width);
            seconds++;
        }, 1000);
    }

    ///////////////////////////////////////////////////////////////////////////
                                    //PROCESS FIGHT//
    //////////////////////////////////////////////////////////////////////////
    function prepareFight() {
        var hero, monsterInFight;
        hero = $.grep(players, function(n,i){
            return n.name == $("#currentPlayerNickName").text();
        })[0];
        //remove players-in-fight from array
        //monster is "in fight" if he is as far as one size from hero
        if(hero){
            monsterInFight = $.grep(players, function(n,i){
                return Math.abs(n.x - hero.x) == hero.size || Math.abs(n.y - hero.y) == hero.size;
            })[0];
            players.splice(players.indexOf(hero),1);
            players.splice(players.indexOf(monsterInFight),1);
        }

        if(monsterInFight) {
            console.log("create new fight call. monster: " + monsterInFight.name);
            postAction("POST", "/savefight", monsterInFight.name);
            $("#monsterAvatarID").prop("src", "/resources/kazan.svg");
            enableForm();
        }
    }

    $("input:radio").click(function(){
        var checkedRadios = $("input:radio:checked");
        var kickParams = {};
        console.log("you checked radio buttonID: " + checkedRadios);
        //if the user select two radios - post a kick and uncheck radios.
        if(checkedRadios.length == 2){
            kickParams[checkedRadios[0].name] = checkedRadios[0].value;
            kickParams[checkedRadios[1].name] = checkedRadios[1].value;
            postAction("POST", "/kick", kickParams);
            setTimeout(function () {
                checkedRadios.filter("[name=attack]").removeAttr("checked");
                checkedRadios.filter("[name=block]").removeAttr("checked");
            }, 1500);
        }
    });
    function disableForm() {
        $("#fightOptionID :input").prop("disabled", true);
    }

    function enableForm() {
        $("#fightOptionID :input").prop("disabled", false);
    }

    function postAction(type, url, data) {
        $.ajax({
            type:type,
            url: url,
            dataType: 'json',
            data: JSON.stringify(data),
            contentType: 'application/json; charset=utf-8',
            async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
            cache: false,    //This will force requested pages not to be cached by the browser
            processData:false, //To avoid making query String instead of JSON
            success: function (data, textStatus, jqXHR) {
                console.log("AJAX SUCCESS: \ndata: " + data + "\ntextStatus: "+ textStatus + "\njqXHR: " + jqXHR);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log("AJAX FAIL: \njqXHR: " + jqXHR + "\ntextStatus: "+ textStatus + "\nerrorThrown: " + errorThrown);
            }
        });
    }
});
