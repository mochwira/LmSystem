$(document).ready(function(){

    $('.nBtn, .table .eBtn').click(function(e){
        e.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Edit') {
            $.getJSON(href, function(response){
            //$('.myForm #kategoriId').val(response.kategoriId).hide(); ini aslinya
                $('.myForm #roleId').val(response.roleId).hide();
                $('.myForm #namaRole').val(response.namaRole);
                $('.myForm #statusRole').val(response.statusRole);
            });
            $('.myForm #roleModal').modal();
        } else {
//         $('.myForm #kategoriId').val('0').hide(); ini aslinya
            $('.myForm #roleId').val('0').hide();

            $('.myForm #namaRole').val('');
            $('.myForm #statusRole').val('');

            $('.myForm #roleModal').modal();
        }

    });

    $('.rBtn').click(function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        //mungkin di dBtn
        $(".myRemoveRole .dBtn").attr('href',href);
        $('.myRemoveRole #roleModal').modal();

    });

});