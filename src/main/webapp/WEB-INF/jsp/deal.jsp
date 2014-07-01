<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<!--
<script src="jquery.js"></script>
<script src="jquery.json-2.2.js"></script>
-->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#form").submit(function(e) {

			e.preventDefault();
			var userId, postCode, text, radius;
			userId = $("#userId").val();
			postCode = $("#postCode").val();
			text = $("#text").val();
			radius = $("#radius").val();

			if (postCode.length > 0 && text.length > 0 && radius.length > 0) {
				alert("radius :" + radius);
				//Deal Object		
				var deal = new Object();

				deal.userid = userId;
				deal.postcode = postCode;
				deal.text = text;
				deal.radius = radius;

				//var myObj = {postcode: postCode, text: text, radius : radius};
				//	var jsonfy = $.toJSON(deal);
				// Encodes special characters
				//var encodedata = 'jsondata='+encodeURIComponent(jsonfy);

				// make Ajax Call
				var url = 'http://10.9.98.25:8080/SpringRestExample/deal';
				post_deal_data(url, deal, function(data) {
					alert("Success");
				});

			}

		});

	});

	function post_deal_data(url, deal, success) {
		$.ajax({
			type : "POST",
			url : url,
			data : {
				"postcode" : "TWsadf",
				"text" : "asdf",
				"radius" : 3
			},
			dataType : "json",
			restful : true,
			contentType : 'application/json',
			cache : false,
			timeout : 20000,
			async : true,
			beforeSend : function(data) {
			},
			success : function(data) {
				success.call(this, data);
			},
			error : function(data) {
				alert("Error In Connecting");
			}
		});
	}
</script>
</head>


<body>
	<form method='post' action='' id='form'>
		<input type="hidden" id="userId" name="userId" /> PostCode <input
			type='text' name='postCode' id='postCode' /><br /> Text
		<textarea name="text" id="text" rows="5" cols="20"></textarea>
		<br /> Radius <input type='text' name='radius' id='radius' /><br /> <input
			type='submit' name="Submit" id='submit' />
	</form>
</body>
</html>