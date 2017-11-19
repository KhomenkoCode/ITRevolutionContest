$(document).ready(function () {
    $("input[name=star]:radio").change(function () {
        console.log(
            "here 1"
        );
        if ($("#star-1").attr("checked","checked")) {
            console.log(
                "star 1"
            );
            /*$('#r1edit:input').removeAttr('disabled');*/
            var artist_id = $.urlParam('artist');
            console.log("artist"+artist_id);
            var user_id = getCookie("user_id");
            console.log("user"+user_id);
            //POST TO ENDPOINT
            //reqest (user_id,artist_id,1)
        }

        if ($("#star-2").attr("checked","checked")) {
            console.log(
                "star 2"
            );
            /*$('#r1edit:input').removeAttr('disabled');*/
            var artist_id = $.urlParam('artist');
            console.log("artist"+artist_id);
            var user_id = $.cookie("user_id");
            console.log("user"+user_id);
            //POST TO ENDPOINT
            //reqest (user_id,artist_id,1)
        }
        if ($("#star-3").attr("checked")) {
            console.log(
                "star 3"
            );
            /*$('#r1edit:input').removeAttr('disabled');*/
            var artist_id = $.urlParam('artist');
            console.log("artist"+artist_id);
            var user_id = $.cookie("user_id");
            console.log("user"+user_id);
            //POST TO ENDPOINT
            //reqest (user_id,artist_id,1)
        }
        if ($("#star-4").attr("checked")) {
            console.log(
                "star 4"
            );
            /*$('#r1edit:input').removeAttr('disabled');*/
            var artist_id = $.urlParam('artist');
            console.log("artist"+artist_id);
            var user_id = $.cookie("user_id");
            console.log("user"+user_id);
            //POST TO ENDPOINT
            //reqest (user_id,artist_id,1)
        }
        if ($("#star-5").attr("checked")) {
            console.log(
                "star 5"
            );
            /*$('#r1edit:input').removeAttr('disabled');*/
            var artist_id = $.urlParam('artist');
            console.log("artist"+artist_id);
            var user_id = $.cookie("user_id");
            console.log("user"+user_id);
            //POST TO ENDPOINT
            //reqest (user_id,artist_id,1)
        }

        /*if ($("#r1").attr("checked")) {
            $('#r1edit:input').removeAttr('disabled');
        }
        else {
            $('#r1edit:input').attr('disabled', 'disabled');
        }
        $('#log').val($('#log').val()+ $(this).val() + '|');*/
    })
});

$.urlParam = function(name){
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    return results[1] || 0;
}
function getCookie(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=");
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1;
            c_end = document.cookie.indexOf(";", c_start);
            if (c_end == -1) {
                c_end = document.cookie.length;
            }
            return unescape(document.cookie.substring(c_start, c_end));
        }
    }
    return "";
}