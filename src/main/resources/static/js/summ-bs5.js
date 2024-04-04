$('#content').summernote({
        lang:"ru-RU",
        placeholder: 'Тело статьи',
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'italic', 'underline', 'clear']],
            ['fontname', ['fontname']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
            ['table', ['table']],
            ['insert', ['link', 'picture','video','hr']],
            ['view', ['fullscreen', 'codeview']],
            ['help', ['help']]
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