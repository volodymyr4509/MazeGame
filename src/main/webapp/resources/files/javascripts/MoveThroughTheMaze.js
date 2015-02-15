$( document ).ready(function() {

    var canvas = document.getElementById("mazecanvas");
    var context = canvas.getContext("2d");
    var intervalID;
    var mazeWidth = 556;
    var mazeHeight = 556;


    function Dummy(x,y,name,speed,colour){
        this.x = x;
        this.y = y;
        this.size = 20;
        this.name = name;
        this.speed = speed;
        this.colour = colour;
        this.currentDirection = setRandomDirection.call(this);

        this.backDirection = (this.currentDirection + 2)<4?(this.currentDirection + 2):(this.currentDirection - 2);
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
        this.takeStepForward = function(){
            makeWhite(this.x, this.y, this.size, this.size);
            console.log("for " + this.name + " current direction = " + this.currentDirection() + " and possibleDirecitons: " + this.possibleDirections());
            if($.inArray(this.currentDirection, this.possibleDirections())>-1){
                switch (this.currentDirection){
                    case 0: this.y--; break;
                    case 1: this.x++; break;
                    case 2: this.y++; break;
                    case 3: this.x--; break;
                }
            }
            this.draw();
        }
    }
    function setRandomDirection(){
        if(this.possibleDirections.length > 1){
            var index = this.possibleDirections.indexOf(this.backDirection);
            this.possibleDirections.splice(index, 1);
        }
        return this.possibleDirections()[Math.floor(Math.random() * this.possibleDirections().length)];
    };
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

    function setPlayerCurrentDirection(e) {
        e = e || window.event;
        switch (e.keyCode) {
            case 38:   // arrow up key
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

    function analyzePixelsRange(pixels){
        var blocker = false;
        for(var i=0; i<pixels.length; i+=4){
            if(pixels[i] == 255 && pixels[i+1] == 255 && pixels[i+2] == 255){ //white == can move
                continue;
            }else{
                if(pixels[i] == 0 && pixels[i+1] == 0 && pixels[i+2] == 255){ //blue == player
                    beginFight();
                }
                blocker = true;
                break;
            }
        }
        return !blocker;
    }

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

    function beginFight() {
        clearInterval(intervalID); //stop monster
        console.log("begin fight");
        $.event.trigger({
            type: "fight",
            message: "vovk"
        });
    }

    window.addEventListener("keydown", function(){
        setPlayerCurrentDirection.call(hobbit);
    }, true);

    drawMaze();
    createTimer(0);
    var players = [];
    var hobbit = new Dummy(420,10,"hobbit",1,"#FF0000");
    var ork = new Dummy(300,200, "ork", 1, "#0000FF");

    players.push(hobbit,ork);

    setInterval(
        function(){
            for(var i=0; i<players.length; i++){
                players[i].takeStepForward();
            }
        },100);
});
