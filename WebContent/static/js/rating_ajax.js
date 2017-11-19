$(document).ready(function () {
    $("input[name=star]:radio").change(function () {
        if ($("#star-1").attr("checked")) {
            /*$('#r1edit:input').removeAttr('disabled');*/
            var artist_id = $.urlParam('artist');
            console.log(artist_id);
            var user_id = $.cookie("user_id")
            console.log(user_id);
            //POST TO ENDPOINT
            //reqest (user_id,artist_id,1)
        }

        if ($("#star-2").attr("checked")) {
            /*$('#r1edit:input').removeAttr('disabled');*/
            var artist_id = $.urlParam('artist');
            console.log(artist_id);
            var user_id = $.cookie("user_id")
            console.log(user_id);
            //POST TO ENDPOINT
            //reqest (user_id,artist_id,rating)
        }
        if ($("#star-3").attr("checked")) {
            /*$('#r1edit:input').removeAttr('disabled');*/
            var artist_id = $.urlParam('artist');
            console.log(artist_id);
            var user_id = $.cookie("user_id")
            console.log(user_id);
            //POST TO ENDPOINT
            reqest (user_id,artist_id,rating)
        }
        if ($("#star-4").attr("checked")) {
            /*$('#r1edit:input').removeAttr('disabled');*/
            var artist_id = $.urlParam('artist');
            console.log(artist_id);
            var user_id = $.cookie("user_id")
            console.log(user_id);
            //POST TO ENDPOINT
            reqest (user_id,artist_id,rating)
        }
        if ($("#star-5").attr("checked")) {
            /*$('#r1edit:input').removeAttr('disabled');*/
            var artist_id = $.urlParam('artist');
            console.log(artist_id);
            var user_id = $.cookie("user_id")
            console.log(user_id);
            //POST TO ENDPOINT
            //reqest (user_id,artist_id,rating)
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