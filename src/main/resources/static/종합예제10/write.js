const addPost = async () => {
    const bwriter = document.querySelector(".writerInput").value;
    const btitle = document.querySelector(".titleInput").value;
    const bcontent = document.querySelector(".contentInput").value;

    const post = {bwriter, btitle, bcontent};

    const response = await axios.post("/board",post);
    const isSuccess = response.data;
    if(isSuccess){
        alert("등록 성공");
        location.href="/종합예제10/index.html";
    }
    else{
        alert("등록 실패");
    }
}