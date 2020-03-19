/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var xhr;
function init() {
    useridField = document.getElementById("userid");
    statusField = document.getElementById("status");
}
function doChecking() {
    var url = "checkuserid?userid=" + escape(useridField.value);
    console.log(url);
    xhr = createXHRObject();
    xhr.open("GET", url, true);
    xhr.onreadystatechange = callback;
    xhr.send(null);

}
function callback() {
    if (xhr.readyState === 4) {
        if (xhr.status === 200) {
            setMessage(xhr.responseXML);
        }
    }
}
function setMessage(message) {
    var x = message.getElementsByTagName("status")[0];
    var mdiv = document.getElementById("status");
    if (x.childNodes[0].nodeValue === "NotAvailable") {
        mdiv.innerHTML = "<div style=\"color:red\">Invalid User Id</ div>";
    } else {
        mdiv.innerHTML = "<div style=\"color:green\">Valid User Id</ div>";
    }
}
function createXHRObject() {
    var xhrObject;
    try {
        // Opera 8.0+, Firefox, Safari
        xhrObject = new XMLHttpRequest();
    } catch (e) {
        // Internet Explorer Browsers
        try {
            xhrObject = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                xhrObject = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                // Something went wrong
                alert("Your browser broke!");
                return false;
            }
        }
    }
    return xhrObject;
}
