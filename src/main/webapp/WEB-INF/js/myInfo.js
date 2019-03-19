 $(function(){
     $("#signature_btn").click(function(){
         var signature = $("#signature").val();
         var username = $("#username").val();
         $.ajax({
             url : "/FMusic/updateSignature",
             type : "POST",
             data : 'signature=' + signature.trim() + '&username=' + username,
             success : function(data, textState){
                 alert(data);
             }
         })
     });
 })