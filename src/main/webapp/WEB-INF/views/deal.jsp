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
			var dealId, postcode, longitude, latitude, dealDescription, radius, expiryTime;
			dealId = $("#dealId").val();
			postcode = $("#postcode").val();
			longitude =  $("#longitude").val();
			latitude =  $("#latitude").val();
			dealDescription = $("#dealDescription").val();
			radius = $("#radius").val();
			expiryTime = $("#expiryTime").val();

			if (longitude.length > 0 && longitude.length > 0 && dealDescription.length > 0 
					&& radius.length > 0 && expiryTime.length > 0) {
				//Deal Object		
				var deal = new Object();

				if (dealId != "" || dealId != null) {
					deal.dealId = dealId;
				}
				deal.postcode = postcode;
				deal.dealDescription = dealDescription;
				deal.radius = radius;
				deal.expiryTime = expiryTime;
				
				var locationArray = [];
				locationArray[0] = parseFloat(longitude);
				locationArray[1] = parseFloat(latitude);
				
				deal.location = locationArray;

				// make Ajax Call
				var url = "http://localhost:8080/dealsmessanger/deal";
				post_deal_data(url, deal, function(data) {
				});

			}

		});

	});

	function post_deal_data(url, deal, success) {
		$.ajax({
		    contentType : "application/json",
		    type : "POST",
			url : url,
			data : JSON.stringify(deal),
			dataType : "json",
			restful : true,
			cache : false,
			timeout : 20000,
			async : false,
			success : function(data) {
				document.getElementById("dealId").value = data.dealId;
				$(this).html("Success!");
				success.call(this, data);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				$(this).html("Error!");
				alert("Error In Connecting"+errorThrown);
			}
		});
	};
</script>
</head>


<body>
	<form method='post' action='' id='form'>
		<input type="hidden" id="dealId" name="dealId" />
		longitude <input type='text' name='longitude' id='longitude' /><br />
		latitude <input	type='text' name='latitude' id='latitude' /><br />
		Postcode <input	type='text' name='postcode' id='postcode' /><br /> 
		Deal Description <textarea name="dealDescription" id="dealDescription" rows="5" cols="20"></textarea>
		<br /> Radius <input type='text' name='radius' id='radius' /><br />
		Expiry in minutes <input type='text' name='expiryTime' id='expiryTime' /><br />
		<input type='submit' name="Submit" id='submit' />
	</form>
</body>
</html>