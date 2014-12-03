var canvas = document.getElementById("mazecanvas");
var context = canvas.getContext("2d");
var currRectX = 100;
var currRectY = 3;
var mazeWidth = 556;
var mazeHeight = 556;
var intervalVar;
function drawMazeAndRectangle(rectX, rectY) {
    makeWhite(0, 0, canvas.width, canvas.height);
    var mazeImg = new Image();
    mazeImg.onload = function () {
        context.drawImage(mazeImg, 0, 0);
        drawRectangle(rectX, rectY, "#0000FF");
        context.beginPath();
        context.arc(542, 122, 7, 0, 2 * Math.PI, false);
        context.closePath();
        context.fillStyle = '#00FF00';
        context.fill();
    };
    mazeImg.src = "/resources/maze.gif";
}
function drawRectangle(x, y, style) {
    makeWhite(currRectX, currRectY, 15, 15);
    currRectX = x;
    currRectY = y;
    context.beginPath();
    context.rect(x, y, 15, 15);
    context.closePath();
    context.fillStyle = style;
    context.fill();
}
function moveRect(e) {
    var newX;
    var newY;
    var movingAllowed;
    e = e || window.event;
    switch (e.keyCode) {
        case 38:   // arrow up key
        case 87: // W key
            newX = currRectX;
            newY = currRectY - 3;
            break;
        case 37: // arrow left key
        case 65: // A key
            newX = currRectX - 3;
            newY = currRectY;
            break;
        case 40: // arrow down key
        case 83: // S key
            newX = currRectX;
            newY = currRectY + 3;
            break;
        case 39: // arrow right key
        case 68: // D key
            newX = currRectX + 3;
            newY = currRectY;
            break;
    }
    movingAllowed = canMoveTo(newX, newY);
    if (movingAllowed === 1) {      // 1 means 'the rectangle can move'
        drawRectangle(newX, newY, "#0000FF");
        currRectX = newX;
        currRectY = newY;
    }
    else if (movingAllowed === 2) { // 2 means 'the rectangle reached the end point'
        clearInterval(intervalVar);
        makeWhite(0, 0, canvas.width, canvas.height);
        context.font = "40px Arial";
        context.fillStyle = "blue";
        context.textAlign = "center";
        context.textBaseline = "middle";
        context.fillText("Congratulations!", canvas.width / 2, canvas.height / 2);
        window.removeEventListener("keydown", moveRect, true);
    }
}
function canMoveTo(destX, destY) {
    var imgData = context.getImageData(destX, destY, 15, 15);
    var data = imgData.data;
    var canMove = 1; // 1 means: the rectangle can move
    if (destX >= 0 && destX <= mazeWidth - 15 && destY >= 0 && destY <= mazeHeight - 15) {
        for (var i = 0; i < 4 * 15 * 15; i += 4) {
            if (data[i] === 0 && data[i + 1] === 0 && data[i + 2] === 0) { // black
                canMove = 0; // 0 means: the rectangle can't move
                break;
            }
            else if (data[i] === 0 && data[i + 1] === 255 && data[i + 2] === 0) { // #00FF00
                canMove = 2; // 2 means: the end point is reached
                break;
            }
        }
    }
    else {
        canMove = 0;
    }
    return canMove;
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
function makeWhite(x, y, w, h) {
    context.beginPath();
    context.rect(x, y, w, h);
    context.closePath();
    context.fillStyle = "white";
    context.fill();
}
drawMazeAndRectangle(420, 10);
window.addEventListener("keydown", moveRect, true);
createTimer(0); // 2 minutes