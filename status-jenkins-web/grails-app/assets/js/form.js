$(function() {
    debugger;
     $("button#iniciar").click(function(){
            $.ajax({
            type: "POST",
            url: "http://localhost:8080/status/teste/teste.json",
            data: $('form.contact').serialize(),
                    success: function(msg){
                    alert("tessss"); 
             },
     error: function(){
     alert("failure");
     }
           });
     });
});