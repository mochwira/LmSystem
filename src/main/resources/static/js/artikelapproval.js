$(document).ready(function(){

    $('.nBtn, .table .eBtn').click(function(e){
        e.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Edit') {
            $.getJSON(href, function(response){
            //$('.myForm #kategoriId').val(response.kategoriId).hide(); ini aslinya
                $('.myForm #artikelApprovalId').val(response.artikelApprovalId);
                //Kayanya ini dah
                $('.myForm #artikelId').val(response.artikelId);
                $('.myForm #approvalStatusId').val(response.approvalStatusId);
                $('.myForm #keteranganApproval').val(response.keteranganApproval);


            });
            $('.myForm #artikelApprovalModal').modal();
        } else {
//         $('.myForm #kategoriId').val('0').hide(); ini aslinya

               $('.myForm #artikelApprovalId').val('0');
               $('.myForm #artikelId').val('0');
               $('.myForm #approvalStatusId').val('0');
               $('.myForm #keteranganApproval').val('');

            $('.myForm #artikelApprovalModal').modal();
        }

    });

    $('.rBtn').click(function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        //mungkin di dBtn
        $(".myRemoveArtikelApproval .dBtn").attr('href',href);
        $('.myRemoveArtikelApproval #artikelApprovalModal').modal();

    });

});