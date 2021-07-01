$(document).ready(function(){

    $('.nBtn, .table .eBtn').click(function(e){
        e.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Edit') {
            $.getJSON(href, function(response){
            //$('.myForm #kategoriId').val(response.kategoriId).hide(); ini aslinya
                $('.myForm #approvalStatusId').val(response.approvalStatusId);
                $('.myForm #statusApproval').val(response.statusApproval);
            });
            $('.myForm #approvalModal').modal();
        } else {
//         $('.myForm #kategoriId').val('0').hide(); ini aslinya
            $('.myForm #approvalStatusId').val('0');
            $('.myForm #statusApproval').val('');

            $('.myForm #approvalModal').modal();
        }

    });

    $('.rBtn').click(function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        //mungkin di dBtn
        $(".myRemoveApproval .dBtn").attr('href',href);
        $('.myRemoveApproval #approvalModal').modal();

    });

});