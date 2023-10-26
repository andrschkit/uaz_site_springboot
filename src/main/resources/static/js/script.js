//Кнопки вкладок Header
let nav_item=document.getElementsByClassName('nav-butt');
let nav_house=document.getElementById("nav_house");

nav_item=[].slice.call(nav_item);

switch (window.location.pathname) {
    case '/':
        nav_item[0].classList.add('static_hover');
        nav_house.src="/images/house_white.svg"
        break;
    case '/projects':
        nav_item[1].classList.add('static_hover');
        break;
    case '/media':
        nav_item[2].classList.add('static_hover');
        break;
    case '/vacancies':
        nav_item[3].classList.add('static_hover');
        break;
    case '/providers':
        nav_item[4].classList.add('static_hover');
        break;
    case '/history':
        nav_item[5].classList.add('static_hover');
        break;
    default:

}
// кнопка наверх страницы
const btnUp = {
    el: document.querySelector('.btn-up'),
    show() {
      // удалим у кнопки класс btn-up_hide
      this.el.classList.remove('btn-up_hide');
    },
    hide() {
      // добавим к кнопке класс btn-up_hide
      this.el.classList.add('btn-up_hide');
    },
    addEventListener() {
      // при прокрутке содержимого страницы
      window.addEventListener('scroll', () => {
        // определяем величину прокрутки
        const scrollY = window.scrollY || document.documentElement.scrollTop;
        // если страница прокручена больше чем на 400px, то делаем кнопку видимой, иначе скрываем
        scrollY > 400 ? this.show() : this.hide();
      });
      // при нажатии на кнопку .btn-up
      document.querySelector('.btn-up').onclick = () => {
        // переместим в начало страницы
        window.scrollTo({
          top: 0,
          left: 0,
          behavior: 'smooth'
        });
      }
    }
  }
  btnUp.addEventListener();
//скрипт лоадера
const loading_elem = document.getElementById("myDiv");

window.onload = function () {
  document.body.classList.add('loaded_hiding');
  window.setTimeout(function () {
    document.body.classList.add('loaded');
    document.body.classList.remove('loaded_hiding');
    if(loading_elem!==null){
      loading_elem.style.display = "block";
    }
  }, 500);
}