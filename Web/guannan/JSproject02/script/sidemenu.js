var slideMenu = document.getElementById("slideMenu");
var body = document.getElementsByTagName("body");
var menuButton = document.getElementById("menu");
var clickCount = 1;
function menu() {
	if (clickCount == 1) {
		body[0].style.position = "relative";
		body[0].style.left = "80%";
		clickCount++;
		return clickCount;
	}
	else if (clickCount == 2) {
		body[0].style.position = "static";
		menuButton.blur();
		clickCount = 1;
		return clickCount;
	}
}