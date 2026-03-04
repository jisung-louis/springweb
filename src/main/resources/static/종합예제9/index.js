// 1] 전체 조회, 실행조건 : JS가 열렸을 때, 수정/등록/삭제 성공했을 때
const onFindAll = async () => {
    // [1] 어디에
    const tbody = document.querySelector("#boardTable");
    // [2] 무엇을
    let html = "";

    // 동기화 axios : 1. 현재 함수명 앞에 async 키워드 붙인다.
    //              2. axios 앞에 await 키워드 붙인다.
    const response = await axios.get("/board");
    const data = response.data;
    for (let i = 0; i < data.length; i++) {
        const board = data[i];
        html += `<tr>
                    <td> ${board.bno} </td>
                    <td> ${board.bcontent} </td>
                    <td> ${board.bwriter} </td>
                    <td> ${board.bdate} </td>
                    <td>
                        <button onclick="onDelete(${board.bno})"> 삭제 </button> 
                        <button onclick="onUpdate( ${board.bno} , '${board.bcontent}' )"> 내용수정 </button>
                    </td>
                </tr>`;
    }
    // [3] 출력 (innerHTML)
    tbody.innerHTML = html;
}
onFindAll();

const onWrite = async () => {
    // [1] 입력값 받아오기
    const bcontent = document.querySelector("#bcontent").value;
    const bwriter = document.querySelector("#bwriter").value;

    const obj = {
        "bcontent" : bcontent, "bwriter" :bwriter
    };

    const result = await axios.post("/board",obj);
    if (result.data){
        alert("입력 성공!")
    }
    onFindAll();
}

const onDelete = async (bno) =>{
    const result = await axios.delete(`/board?bno=${bno}`);
    console.log(result);
    if(result.data){
        alert("삭제 성공!")
    }
    onFindAll();
}

const onUpdate = async (bno, beforeBcontent) => {
    const bcontent =  prompt("수정할 내용을 입력하세요.", beforeBcontent);
    if(bcontent == null) {
        alert("수정이 취소되었습니다");
        return;
    }

    const obj = {"bno" : bno, "bcontent" : bcontent};
    const result = await axios.put("/board",obj);
    console.log(result);
    if(result.data){
        alert("수정 성공!");
    }
    onFindAll();
}