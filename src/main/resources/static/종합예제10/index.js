const printPostAll = async () => {
    // 어디에
    const tbody = document.querySelector("#boardTable");
    // 무엇을
    let html = ``;

    const response = await axios.get("/board");
    const data = response.data;
    data.forEach( post => {
        let createDate = post.createDate; // TODO : 2020-01-01T01:12:23.123456 꼴의 포맷을 보기 좋게 바꿔야 함
        html += `<tr>
                    <td> ${post.bno} </td>
                    <td><a href="/종합예제10/detail.html?bno=${post.bno}"> ${post.btitle} </a></td>
                    <td> ${post.bwriter} </td>
                    <td> ${createDate} </td>
                </tr>`
    })

    // 출력
    tbody.innerHTML = html;
}
printPostAll();