var canvas = document.getElementById("mazecanvas");
var context = canvas.getContext("2d");
var currentPlayerX = 420;
var currentPlayerY = 10;
var finishX = 533;
var finishY = 114;
var mazeWidth = 556;
var mazeHeight = 556;
var squareSide = 20;
var movingStep = 1;
var intervalVar;

var monster = {
    name:"Rahul",
    x:423,
    y:100,
    movingStep:1,
    size:20,
    colour:"#FF0000",
    draw:draw,
    move:move,
    currentDirection:0,
    possibleDirections:findPossibleDirections
}
function drawMazeAndRectangle() {
    makeWhite(0, 0, canvas.width, canvas.height);
    var mazeImg = new Image();
    mazeImg.onload = function () {
        context.drawImage(mazeImg, 0, 0);
        drawPlayer(currentPlayerX, currentPlayerY);
        drawFinish();
        addMonster();
    };
    mazeImg.src = "/resources/maze.gif";
}
function drawPlayer(x, y) {
    makeWhite(currentPlayerX, currentPlayerY, squareSide, squareSide);
    currentPlayerX = x;
    currentPlayerY = y;
    style = "#0000FF";
    drawRectangle(x, y, style);
}
function drawFinish(){
    style = "#00FF00";
    drawRectangle(finishX, finishY, style);
}
function drawRectangle(x, y, style){
    context.beginPath();
    context.rect(x, y, squareSide, squareSide);
    context.closePath();
    context.fillStyle = style;
    context.fill();
}
function movePlayer(e) {
    var newX;
    var newY;
    e = e || window.event;
    switch (e.keyCode) {
        case 38:   // arrow up key
        case 87: // W key
            newX = currentPlayerX;
            newY = currentPlayerY - movingStep;
            break;
        case 37: // arrow left key
        case 65: // A key
            newX = currentPlayerX - movingStep;
            newY = currentPlayerY;
            break;
        case 40: // arrow down key
        case 83: // S key
            newX = currentPlayerX;
            newY = currentPlayerY + movingStep;
            break;
        case 39: // arrow right key
        case 68: // D key
            newX = currentPlayerX + movingStep;
            newY = currentPlayerY;
            break;
    }
    if(canMove(newX, newY)){
        drawPlayer(newX,newY);
    };
}
function canMove(destX, destY) {
    var imgData = context.getImageData(destX, destY, squareSide, squareSide);
    var data = imgData.data;
    var blocker = false;
    if (destX >= 0 && destX <= mazeWidth - squareSide && destY >= 0 && destY <= mazeHeight - squareSide) {
        for (var i = 0; i < 4 * squareSide * squareSide; i += 4) {
            if(blocker = checkColour(data[i], data[i+1], data[i+2])){
                switch (blocker){
                    case "wall": console.log("wall detected");
                        break;
                    case "monster": console.log("monster detected");
                        break;
                    case "finish": console.log("finish detected");
                        break;
                    default: console.log("default");
                }
                break;
            }
        }
    }
    return !blocker;
}
function checkColour(r, g, b) {
    if(r == 255 && g == 0 && b == 0){
        return "monster";
    }
    if(r == 0 && g == 0 && b == 0){
        return "wall";
    }
    if(r == 0 && g == 255 && b == 0){
        return "finish";
    }
    return false;
}

function makeWhite(x, y, w, h) {
    context.beginPath();
    context.rect(x, y, w, h);
    context.closePath();
    context.fillStyle = "white";
    context.fill();
}
function moveUp(){
    this.y--;
}
function moveRight(){
    this.x++;
}
function moveDown(){
    this.y++;
}
function moveLeft(){
    this.x--;
}
function move(){
    console.log("move() function this = " + this.toString());
    var possibleDirections = findPossibleDirections.call(this);

    var direction = chooseRandomDirection.call(this, possibleDirections);
    this.direction = direction;
    console.log("Current currentDirection: " + this.direction);
    console.log("Random Direction: " + direction);
    makeWhite(this.x, this.y, this.size, this.size);
    switch (direction){
        case 0: moveUp.call(this); break;
        case 1: moveRight.call(this); break;
        case 2: moveDown.call(this); break;
        case 3: moveLeft.call(this); break;
    }
    this.draw();
}
function draw(){
    context.beginPath();
    context.rect(this.x, this.y, this.size, this.size);
    context.closePath();
    context.fillStyle = this.colour;
    context.fill();
}
function findPossibleDirections(){
    var possibleDirections = [];
    //UP
    if(this.y-this.movingStep >= 0){
        var imgDataUp = context.getImageData(this.x, this.y-this.movingStep, this.size, this.movingStep);
        var data = imgDataUp.data;
        if(analyzePixelsRange(data)){
            console.log("can move UP");
            possibleDirections.push(0);
        }
    }
    //RIGHT
    if(this.x+this.movingStep <= mazeWidth){
        var imgDataRight = context.getImageData(this.x+this.size, this.y, this.movingStep, this.size);
        var data = imgDataRight.data;
        if(analyzePixelsRange(data)){
            console.log("can move RIGHT");
            possibleDirections.push(1);
        }
    }
    //DOWN
    if(this.y+this.movingStep <= mazeHeight){
        var imgDataRight = context.getImageData(this.x, this.y+this.size, this.size, this.movingStep);
        var data = imgDataRight.data;
        if(analyzePixelsRange(data)){
            console.log("can move DOWN");
            possibleDirections.push(2);
        }
    }
    //LEFT
    if(this.x-this.movingStep >= 0){
        var imgDataRight = context.getImageData(this.x - this.movingStep, this.y, this.movingStep, this.size);
        var data = imgDataRight.data;
        if(analyzePixelsRange(data)){
            console.log("can move LEFT");
            possibleDirections.push(3);
        }
    }
    console.log("Possible directions Monster: " + possibleDirections.toString());
    return possibleDirections;
}
function chooseRandomDirection(possibleDirections){
    var index = -1;
    if(possibleDirections.length > 1){
        index = (this.currentDirection + 2) < 4 ? (this.currentDirection + 2):(this.currentDirection - 2);
    }
    if(index > -1){
        possibleDirections.splice(index, 1);
    }
    console.log("directions to random choose: " + possibleDirections);
    var randomDirection = Math.floor(Math.random() * possibleDirections.length);

    return possibleDirections[randomDirection];
}
function analyzePixelsRange(pixels){
    var blocker = false;
    for(var i=0; i<pixels.length; i+=4){
        if(pixels[i] == 255 && pixels[i+1] == 255 && pixels[i+2] == 255){
            continue;
        }else{
            blocker = true;
            break;
        }
    }
    return !blocker;
}


function addMonster() {
    console.log("Add monster function");
    setInterval(function(){
        move.call(monster);
    },10);
}
function createTimer(seconds) {
    intervalVar = setInterval(function () {
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

drawMazeAndRectangle();
window.addEventListener("keydown", movePlayer, true);
createTimer(0);