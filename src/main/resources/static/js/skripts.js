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
// Простые анимации фейда и появления сверху
  const tl_fade = gsap.timeline({ 
    paused: true, 
    defaults: { duration: 1.3 }
  })
  .from("#fadeanim", { opacity: 0 })
  .to("#fadeanim", { opacity: 1 }, "+=1")
 
  function doFade() {
    tl_fade.restart();
  }
  
  document.addEventListener("DOMContentLoaded", doFade);

const tl_anim_up = gsap.timeline({ 
  paused: true, 
})
gsap.fromTo("#anim_up", {x:0, y:-30}, {x:0, y:0, duration: 0.5, ease: "power2"});
 
  function doUp() {
    tl_anim_up.restart();
  }
  
  document.addEventListener("DOMContentLoaded", doUp);
const tl_anim_logo = gsap.timeline({ 
  paused: true
})
gsap.fromTo("#anim_logo", {x:0, y:0}, {x:0, y:0, rotation:360, duration: 20, ease:Linear.easeNone, repeat:-1});
 
  function doLogo() {
    tl_anim_logo.restart();
  }
  
  document.addEventListener("DOMContentLoaded", doLogo);
  
const tl_anim_soon = gsap.timeline({ 
  paused: true
})
gsap.fromTo("#anim_soon", {rotation:-3}, { rotation:3, transformOrigin: 'center top', duration: 2,ease:Power1.easeInOut, yoyoEase:true, repeat:-1});
  function doSoon() {
      tl_anim_soon.play();
  }

  document.addEventListener("DOMContentLoaded", doSoon);

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