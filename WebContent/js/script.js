
  $(document).ready(function()
{    
  
  var nameregex = /^[a-zA-Z ]+$/;
   
   $.validator.addMethod("validname", function( value, element ) {
       return this.optional( element ) || nameregex.test( value );
   }); 
  
   $("#loginForm").validate({
     
    rules:
    {
    
    password: {
     required: true,
     minlength: 8,
     maxlength: 15
    },
    confirmpassword: {
     required: true,
     equalTo: '#password'
    },
     },
     messages:
     {
   
    password:{
     required: "Please Enter Password",
     minlength: "Password at least have 8 characters"
     },
    confirmpassword:{
     required: "Please Retype your Password",
     equalTo: "Password Did not Match !"
     }
     },
     
     
     submitHandler: function(form) {
                    form.submit();
     alert('Successfully registered...');
                }
     }); 
  
   $("#action1").click(function(){
       $(".perform1").show();
		$(".perform2").hide();
	
   });

   $("#action2").click(function(){
       $(".perform2").show();
		$(".perform1").hide();
	
   });

   $('.mobile,.aadhar').keypress(function(key) {
       if(key.charCode < 48 || key.charCode > 57) return false;});

   $('.firstname,.lastname').keypress(function(key){
      if(key.charCode==32 && key.charCode>=48 || key.charCode<=57) return false; 
   });
 
 });