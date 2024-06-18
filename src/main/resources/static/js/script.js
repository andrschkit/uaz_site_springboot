//Кнопки вкладок Header
let home=document.getElementById('home');
let services=document.getElementById('services');
let objects=document.getElementById('objects');
let licence=document.getElementById('licence');
let licenses=document.getElementById('licenses');
let certificates=document.getElementById('certificates');
let news=document.getElementById('news');
let contacts=document.getElementById('contacts');
let about=document.getElementById('about');
let repair=document.getElementById('repair');
let exploitation=document.getElementById('exploitation');

let locName=window.location.pathname;
let cutLocName=locName.split("/");
console.log(cutLocName);

if(locName==='/'){
    home.classList.add('static_hover');
}

switch (cutLocName[1]) {
    case 'about':
        about.classList.add('static_hover');
        break;
    case 'services':
        services.classList.add('static_hover');
        break;
    case 'projects_repair':
        objects.classList.add('static_hover');
        repair.classList.add('static_hover');
        break;
    case 'projects_exploitation':
        objects.classList.add('static_hover');
        exploitation.classList.add('static_hover');
        break;
    case 'licenses':
        licence.classList.add('static_hover');
        licenses.classList.add('static_hover');
        break;
    case 'certificates':
        certificates.classList.add('static_hover');
        licence.classList.add('static_hover');
        break;
    case 'news':
        news.classList.add('static_hover');
        break;
    case 'singlePost':
        news.classList.add('static_hover');
        break;
    case 'contacts':
        contacts.classList.add('static_hover');
        break;
    default:

}
let dropdownProjects=document.getElementById('dropdown_projects');
let dropdownLicences=document.getElementById('dropdown_licenses');

window.addEventListener('click', function(e){
    if (!document.getElementById('objects').contains(e.target)){
        dropdownProjects.classList.remove("dropdown_checked");
        if (cutLocName[1]!=='projects_repair'){
            if (cutLocName[1]!=='projects_exploitation') {
                objects.classList.remove('static_hover');
            }
        }
    }
    else {
        dropdownProjects.classList.toggle("dropdown_checked");
        objects.classList.add('static_hover');
    }

    if (!document.getElementById('licence').contains(e.target)){
        dropdownLicences.classList.remove("dropdown_checked");
        if (cutLocName[1]!=='licenses'){
            if (cutLocName[1]!=='certificates') {
                licence.classList.remove('static_hover');
            }
        }

    }
    else {
        dropdownLicences.classList.toggle("dropdown_checked");
        licence.classList.add('static_hover');
    }
});


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


