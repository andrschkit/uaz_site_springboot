let id=document.getElementsByClassName('post_id');
let currentNews=document.getElementsByClassName('current_news');

id=[].slice.call(id);
currentNews=[].slice.call(currentNews);

currentNews.forEach((item, index)=>{
   if (index>=0) item.onclick = function (event) {
      window.location.href = `/singlePost?postId=${id[index].textContent}`;
   }
});
