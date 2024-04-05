$('#content').summernote({
        lang:"ru-RU",
        placeholder: 'Тело статьи',
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'italic', 'underline', 'clear']],
            ['fontname', ['fontname']],
            ['fontsize', ['fontsize']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph','hr']],
            ['height', ['height']],
            ['table', ['table']],
            ['insert', ['link', 'picture','video']],
            ['view', ['fullscreen', 'codeview', 'undo', 'redo']],
        ],
        height: 600,
 });
$('body').click(function (event)
{
    if($(event.target).is('.note-modal')) {
         $(".note-modal").hide();
         $(".note-modal-backdrop").hide();

    }
});