$(document).ready(function(){

    $('.nBtn, .table .eBtn').click(function(e){
        e.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Edit') {
            $.getJSON(href, function(response){
            //$('.myForm #kategoriId').val(response.kategoriId).hide(); ini aslinya
                $('.myForm #artikelId').val(response.userId);
                //Kayanya ini dah
                $('.myForm #kategoriId').val(response.kategoriId);
                $('.myForm #userId').val(response.userId);
                $('.myForm #namaArtikel').val(response.namaArtikel);
                $('.myForm #deskripsiArtikel').val(response.deskripsiArtikel);
                $('.myForm #bodyArtikel').val(response.bodyArtikel);
                $('.myForm #sumberArtikel').val(response.sumberArtikel);

            });
            $('.myForm #artikelModal').modal();
        } else {
//         $('.myForm #kategoriId').val('0').hide(); ini aslinya

               $('.myForm #artikelId').val('0');
               $('.myForm #kategoriId').val('0');
               $('.myForm #userId').val('0');
               $('.myForm #namaArtikel').val('');
               $('.myForm #deskripsiArtikel').val('');
               $('.myForm #bodyArtikel').val('');
               $('.myForm #sumberArtikel').val('');


            $('.myForm #artikelModal').modal();
        }

    });

    $('.rBtn').click(function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        //mungkin di dBtn
        $(".myRemoveArtikel .dBtn").attr('href',href);
        $('.myRemoveArtikel #artikelModal').modal();

    });

});