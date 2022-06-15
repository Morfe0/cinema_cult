var menu = document.querySelector('.menu');
var menuList = document.querySelector('.menu-items');

var menuOpened = false;

//hover over the menu icon -- opens the mini menu
menu.addEventListener('mouseover', function(){
  menuList.style.left = '0';
});
//meave the menu-icon hides mini-icons
menu.addEventListener('mouseleave', function(){
  menuList.style.left = '-81px';
});

menuList.addEventListener('mouseover', function(){
  menuList.style.width = '300px';
  menuList.style.left = '0';
});

menuList.addEventListener('mouseleave', function(){
  menuList.style.width = '80px';
  menuList.style.left = '-81px';
});
const actorsContainer = document.querySelector(".actors");
const btn = document.querySelector(".btn");

btn.addEventListener("click", function (e) {
  const newActor = `<input style="display: block;" type="text" name="actor" value="attore nuovo" />`;
  actorsContainer.insertAdjacentHTML("beforeend", newActor);
});
