<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
</head>
<body>
<input type="file" id="myFile" />
<input type="button" id="upload" value="Upload" onclick = "csvJSON()" />
<p id="demo"></p>
<script>
function csvJSON(){
    var x = document.getElementById("myFile");
    var txt = "";
    if ('files' in x) {
        if (x.files.length == 0) {
            txt = "Select one or more files.";
        } else {
            for (var i = 0; i < x.files.length; i++) {
            txt = "Inside If";
				var lines=x.files[i].split("\n");
			txt = "Inside If";
  				var result = [];
			txt = "Inside If";
  				var headers=lines[0].split(",");
  				txt = "Inside If";
  				for(var k=1;k<lines.length;k++){

	  				var obj = {};
	  				var currentline=lines[k].split(",");

	  				for(var j=0;j<headers.length;j++){
		  			obj[headers[j]] = currentline[j];
	  				}

	  				result.push(obj);
	  			}
	  			txt = "Inside If";
            }
            txt = "Inside If";
        }
    } 
    else {
        if (x.value == "") {
            txt += "Select one or more files.";
        } else {
            txt += "The files property is not supported by your browser!";
            txt  += "<br>The path of the selected file: " + x.value; // If the browser does not support the files property, it will return the path of the selected file instead. 
        }
    }
    document.getElementById("demo").innerHTML = txt;
    }
</script>
</body>
</html>