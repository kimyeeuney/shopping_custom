<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Draggable - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <style>
  #draggable { width: 150px; height: 150px; padding: 0.5em; }
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
   $( function() {  
    $( "#draggable" ).draggable();
  } ); 
    
  </script>  
</head> 
<body> 
 
<div id="draggable" class="ui-widget-content">
  <p><% String scan=null; %></p><!-- 여기서 텍스트를 받아서 펑션에 전달...-> 박스에 데이터담아서이동?  -->
</div>
 
 
</body>
</html>