//Кнопки вкладок Header
let nav_item=document.getElementsByClassName('nav-item');

nav_item=[].slice.call(nav_item);

switch (window.location.pathname) {
    case '/':
        nav_item[0].classList.add('static_hover');
        break;
    case '/about':
        nav_item[1].classList.add('static_hover');
        break;
    case '/services':
        nav_item[2].classList.add('static_hover');
        break;
    case '/objects_repair':
        nav_item[3].classList.add('static_hover');
        break;
    case '/objects_exploitation':
        nav_item[3].classList.add('static_hover');
        break;
    case '/licenses':
        nav_item[4].classList.add('static_hover');
        break;
    case '/news':
        nav_item[5].classList.add('static_hover');
        break;
    case '/contacts':
        nav_item[6].classList.add('static_hover');
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


//----------------AjaxPost-----------------------

$('#submitForm').submit(function(e) {
    // reference to form object
    var form = this;
    // for stopping the default action of element
    e.preventDefault();
    // mapthat will hold form data
    // создадим пустой объект
    var data = {};
// переберём все элементы input, textarea и select формы с id="myForm "
    $('#submitForm').find ('input, textarea, select').each(function() {
        // добавим новое свойство к объекту $data
        // имя свойства – значение атрибута name элемента
        // значение свойства – значение свойство value элемента
        data[this.name] = $(this).val();
    });
    $.ajax({
        type: form.getAttribute('method'), // method attribute of form
        url: form.getAttribute('action'),  // action attribute of form
        // convert form data to json format
        data : data,
        success: function(response){

            // we have the response
            if(response.status === "SUCCESS"){
                $('#infoModalLabel').text(response.result.toString());
                $('#infoModal').modal('show');
                resetForm($('#submitForm'));
                console.log("SUCCESS");
            }else{
                console.log("ERROR");
                resetErrorsInForm($('#submitForm'));
                for(i =0 ; i < response.result.length ; i++){
                    var inputId = response.result[i].field;
                    $('#'+inputId).addClass('is-invalid')
                    $('#'+inputId+"_error").text(response.result[i].defaultMessage.toString());
                }
                $('#ModalToggle').modal('show');

            }
        },
        error: function(e){
            alert('Error: ' + e);
        }
    });
});

function resetForm($form) {
    $form.find('input:text, input:password, input:file, select, textarea').val('');
    $form.find('input:radio, input:checkbox')
        .removeAttr('checked').removeAttr('selected');
    resetErrorsInForm($form);
}

function resetErrorsInForm($form) {
    $form.find('input:text, input:password, input:file, select, textarea').removeClass("is-invalid");
}

let img=document.getElementById('title_image');
if (img!=null){
    img.onchange = function () {
        let src = URL.createObjectURL(this.files[0])
        document.getElementById('file_img').src = src
    }
}

/*function doAjaxPost() {
    // get the form values
    var name = $('#name').val();
    var education = $('#education').val();

    $.ajax({
        type: "POST",
        url:
        data: "contexPath + "/AddUser.htm",name=" + name + "&education=" + education,
        success: function(response){
            // we have the response
            if(response.status == "SUCCESS"){
                userInfo = "<ol>";
                for(i =0 ; i < response.result.length ; i++){
                    userInfo += "<br><li><b>Name</b> : " + response.result[i].name +
                        ";<b> Education</b> : " + response.result[i].education;
                }
                userInfo += "</ol>";
                $('#info').html("User has been added to the list successfully. " + userInfo);
                $('#name').val('');
                $('#education').val('');
                $('#error').hide('slow');
                $('#info').show('slow');
            }else{
                errorInfo = "";
                for(i =0 ; i < response.result.length ; i++){
                    errorInfo += "<br>" + (i + 1) +". " + response.result[i].code;
                }
                $('#error').html("Please correct following errors: " + errorInfo);
                $('#info').hide('slow');
                $('#error').show('slow');
            }
        },
        error: function(e){
            alert('Error: ' + e);
        }
    });
}*/


