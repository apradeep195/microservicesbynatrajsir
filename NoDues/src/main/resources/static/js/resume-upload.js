//show hide loader
  function showLoader(flag){
        if(flag){
            document.getElementById("loaderDiv").classList.remove("d-none");
             document.getElementById("loaderDiv").classList.add("d-flex");
        }
        else{
               document.getElementById("loaderDiv").classList.remove("d-flex");
            document.getElementById("loaderDiv").classList.add("d-none");
        }
         document.getElementById("container2").classList.toggle("d-none");
    }

    
$(document).on('submit','#resumeUpload',function(){
       showLoader(true);
});