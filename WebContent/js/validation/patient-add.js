$(document).ready(function() {
	// validate signup form on keyup and submit
	var validator = $("#addUser").validate({
		rules: {		
			login: {
				required: true,
				minlength: 2				
			},
			password: {
				required: true,
				minlength: 5
			},
			password2: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
			name: {
				required: true,
				minlength: 4
			},
			email: {
				required: true,
				email: true
			}
		},
		messages: {
			
			login: {
				required: "Enter a username",
				minlength: jQuery.format("Enter at least {0} characters")				
			},
			password: {
				required: "Provide a password",
				rangelength: jQuery.format("Enter at least {0} characters")
			},
			password2: {
				required: "Repeat your password",
				minlength: jQuery.format("Enter at least {0} characters"),
				equalTo: "Enter the same password as above"
			},
			email: {
				required: "Please enter a valid email address",
				minlength: "Please enter a valid email address"				
			}
		},
		// the errorPlacement has to take the table layout into account
		errorPlacement: function(error, element) {		
				$("#validation_"+element.attr("id")).append(error);
				
				// element.addClass("validationInputError");
				// error.appendTo( element.next() );
		},
		// specifying a submitHandler prevents the default submit, good for the
		// demo
				// set this class to error-labels to indicate valid fields
		success: function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("validationHelp");
		}
	});
});

