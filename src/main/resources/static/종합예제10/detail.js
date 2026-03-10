const postId = new URLSearchParams(location.search).get("bno"); // URL 쿼리스트링 매개변수 키 "bno"의 값 가져옴

const printPost = async () => {
    const boardBox = document.querySelector("#boardBox");
    let html = ``;

    const response = await axios.get(`/board/detail?postId=${postId}`);
    const data = response.data;
    html = `<div style="padding:10px; border:1px solid black; border-radius: 8px">
                <b> 제목 </b> : <span> ${data.btitle} </span> <br/>
                <b> 작성자/작성일 </b> : <span> ${data.bwriter} / ${data.createDate} </span> <br/>
                <b> 내용 </b> : <span> ${data.bcontent} </span> <br/>
                <button onclick="updatePost()"> 수정 </button>
                <button onclick="deletePost()"> 삭제 </button>
            </div>`;

    boardBox.innerHTML = html;
}

const updatePost = async () => {
    const btitle = prompt("수정할 제목");
    const bcontent = prompt("수정할 내용");
    const bwriter = prompt("수정할 작성자명");

    const obj = {bno: postId, btitle, bcontent, bwriter}

    const response = await axios.put("/board",obj);
    const isSuccess = response.data;
    alert(isSuccess ? "수정 성공!!" : "수정 실패...")
    location.reload();
}

const deletePost = async () => {
    const response = await axios.delete(`/board?postId=${postId}`);
    const isSuccess = response.data;

    if(isSuccess){
        alert("삭제 성공");
        location.href="/종합예제10/index.html";
    }
    else{
        alert("삭제 실패");
    }
}

// ======================================= 댓글

const printComments = async () => {
    const commentBox = document.querySelector("#commentBox");
    let html = ``;
    const response = await axios.get(`/comment?boardId=${postId}`);
    const comments = response.data;
    comments.forEach(comment => {
       html += `<div style="border-bottom:1px solid black; padding-top: 12px">
                    <div> ${comment.ccontent} </div>
                    <div style="font-size: 10px"> ${comment.cwriter} / ${comment.createDate} </div>
                    <button onclick="updateComment(${comment.cno})"> 수정 </button>
                    <button onclick="deleteComment(${comment.cno})"> 삭제 </button>
                    <br/>
                    <br/>
                </div>`
    });
    if(comments.length === 0){
        html += `댓글 아직 없음`;
    }

    commentBox.innerHTML = html;
}

const addComment = async () => {
    const ccontent = document.querySelector("#ccontentInput").value;
    const cwriter = document.querySelector("#cwriterInput").value;

    const obj = {bno: postId, ccontent, cwriter};
    const response = await axios.post("/comment",obj);
    const isSuccess = response.data;
    if(isSuccess){
        alert("댓글 작성 성공!");
        location.reload();
    }
    else{
        alert("댓글 작성 실패...");
    }
}

const updateComment = async (cno) => {
    const ccontent = prompt("수정할 댓글 내용을 입력하세요");
    const cwriter = prompt("수정할 작성자명을 입력하세요");
    const obj = {cno, bno: postId, ccontent, cwriter};
    const response = await axios.put("/comment", obj);
    const isSuccess = response.data;
    if(isSuccess){
        alert("수정 성공");
        location.reload();
    }
    else{
        alert("수정 실패");
    }
}

const deleteComment = async (cno) => {
    const response = await axios.delete(`/comment?commentId=${cno}`);
    const isSuccess = response.data;
    if(isSuccess){
        alert("삭제 성공");
        location.reload();
    }
    else{
        alert("삭제 실패");
    }
}

printPost();
printComments();