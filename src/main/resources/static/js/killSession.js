function killSession() {
    $.ajax({
        url: "/api/killSession"
    });
}