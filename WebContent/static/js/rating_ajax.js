$(document).ready(function () {
    $("input[name=star]:radio").change(function () {
        if ($("#r1").attr("checked")) {
            /*$('#r1edit:input').removeAttr('disabled');*/

            //GET TO ENDPOINT
            reqest (user_id,artist_id,rating)
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