const postAttendance = async () => {
    try{
        console.log("postAttendance");

        const obj = {"ano": 1, "studentName" : "홍길동", "date" : "2026-02-26", "status" : "출석" };
        const response = await axios.post("/attendance", obj)
        console.log(response.data);
    }catch(e){
        console.log(e);
    }
}

const getAttendanceAll = async () => {
    try{
        console.log("getAttendanceAll");
        const response = await axios.get("/attendance")
        console.log(response.data);
    }catch(e){
        console.log(e);
    }
}

const getAttendance = async () => {
    try{
        console.log("getAttendance");
        const response = await axios.get("/attendance/detail")
        console.log(response.data);
    }catch(e){
        console.log(e);
    }
}

const deleteAttendance = async () => {
    try{
        console.log("deleteAttendance");
        const response = await axios.delete("/attendance?ano=1")
        console.log(response.data);
    }catch(e){
        console.log(e);
    }
}
const updateAttendance = async () => {
    try{
        console.log("updateAttendance");

        const obj = {"ano" : 1, "studentName" : "홍길동", "date" : "2026-02-26", "status" : "출석" };
        const response = await axios.put("/attendance", obj)
        console.log(response.data);
    }catch(e){
        console.log(e);
    }
}