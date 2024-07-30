function swapBtnValues(selfObj){
 if(selfObj.value==='Yes'){
    selfObj.className="btn btn-danger w-25";
    selfObj.value="No";
 }else{
    selfObj.className="btn btn-success w-25";
    selfObj.value="Yes";
 }
}