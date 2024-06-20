const id=document.getElementById('post_id');
const btnEdit=document.getElementById("btn_edit")

btnEdit.onclick = function (event) {
    window.location.href = `/editPost?postId=${id.textContent}`;
};

