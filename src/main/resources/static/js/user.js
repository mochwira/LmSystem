$(document).ready(function(){

    $('.nBtn, .table .eBtn').click(function(e){
        e.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Edit') {
            $.getJSON(href, function(response){
            //$('.myForm #kategoriId').val(response.kategoriId).hide(); ini aslinya
                $('.myForm #userId').val(response.userId);
                //Kayanya ini dah
                $('.myForm #roleId').val(response.roleId);
                $('.myForm #namaRole').val(response.namaRole);
                $('.myForm #username').val(response.username);
                $('.myForm #namaUser').val(response.namaUser);
                $('.myForm #email').val(response.email);
                $('.myForm #password').val(response.password);


            });
            $('.myForm #userModal').modal();
        } else {
//         $('.myForm #kategoriId').val('0').hide(); ini aslinya

               $('.myForm #userId').val('0');
               $('.myForm #roleId').val('0');
               $('.myForm #namaRole').val('');
               $('.myForm #username').val('');
               $('.myForm #namaUser').val('');
               $('.myForm #email').val('');
               $('.myForm #password').val('');


            $('.myForm #userModal').modal();
        }

    });

    $('.rBtn').click(function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        //mungkin di dBtn
        $(".myRemoveUser .dBtn").attr('href',href);
        $('.myRemoveUser #userModal').modal();

    });

});