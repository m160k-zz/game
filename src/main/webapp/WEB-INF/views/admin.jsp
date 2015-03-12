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
</script>
</head>
<body>
    <div>
        <form id="addQuestion" action="addQuestion" method="post"> 
		    Question: <input type="text" name="question" />
		    <br><br>
		    Answer 1: <input type="text" name="answer1" /><br>
		    Answer 2: <input type="text" name="answer2" /><br>
		    Answer 3: <input type="text" name="answer3" /><br>
		    Answer 4: <input type="text" name="answer4" /><br>
		    <br>
		    <input type="submit" value="Submit" /> 
		</form>
    </div>
    <button>Show/Hide Questions</button>
    <div id="questions"></div>
</body>
</html>