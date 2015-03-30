<html>
<head>
<style type="text/css">
body {
    background-image:
        url('http://cdn3.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script>
var showQuestions;

$(document).ready(function() {
	showQuestions = 0;
	$("button").click(function(event) {
		if(showQuestions == 0) {
			$('#questions').show();
			showQuestions = 1;
		} else {
			$('#questions').hide();
			showQuestions = 0;
		}
		getQuestions();
	}); 
	
});

function getQuestions() {
    $.ajax({
        url : 'getQuestions',
        dataType: 'json',
        success : function(data) {
            $('#questions').html(JSON.stringify(data));
        }
    });
}

$(document).ready(function() {
	$(".ans1").click(validate);
    $('#submit').prop('disabled','disabled');
    $('.ans').keyup(validate);
    // $('#submit') instead of $('input[type="submit"]')
});

function validate() {
	if(isValid()) {
		$('#submit').removeAttr('disabled');
	} else {
		$('#submit').prop('disabled', 'disabled');
	}
}

function isValid() {
	if(isBtnValid() && isTxtValid()) {
		return true;           
    }
	return false;
}

function isBtnValid() {
	if($('#radio1').is(':checked') || $('#radio2').is(':checked') ||  $('#radio3').is(':checked') ||  $('#radio4').is(':checked')) {
		return true;
	} 
	return false;
}

function isTxtValid() {
	if($('#ans1').val() != '' && $('#ans2').val() != '' && $('#ans3').val() != '' && $('#ans4').val() != '' && $('#quest').val() != '') {
		return true;
	}
	return false;
}

</script>
</head>
<body>
    <div>
        <form id="addQuestion" action="addQuestion" method="post"> 
		    <label for="quest">Question: </label><input type="text" name="question" id="quest" class="ans" />
		    <br><br>
		    <label for="ans1">Answer 1: </label>
		    <input type="text" class="ans" name="answer1" id="ans1" />
		    <input type="radio" class="ans1" value="1" name="answer" id="radio1" /><br>
		    <label for="ans2">Answer 2: </label>
		    <input type="text" class="ans" name="answer2" id="ans2" />
		    <input type="radio" class="ans1" value="2" name="answer" id="radio2" /><br>
		    <label for="ans3">Answer 3: </label>
		    <input type="text" class="ans" name="answer3" id="ans3" />
		    <input type="radio" class="ans1" value="3" name="answer" id="radio3" /><br>
		    <label for="ans4">Answer 4: </label>
		    <input type="text" class="ans" name="answer4" id="ans4" />
		    <input type="radio" class="ans1" value="4" name="answer" id="radio4" /><br>
		    <br>
		    <input type="submit" value="Submit" id="submit" /> 
		</form>
    </div>
    <div>
        <form id="addUser" action="addUser" method="post"> 
		    <label for="username">Username: </label><input type="text" name="user" id="username" class="users" />
		    <br><br>
		    <label for="pass">Password: </label>
		    <input type="password" class="users" name="password" id="pass" />
		    <input type="submit" value="Submit" id="submit2" />		    
		</form>
    </div>
    <button>Show/Hide Questions</button>
    <div id="questions"></div>
</body>
</html>