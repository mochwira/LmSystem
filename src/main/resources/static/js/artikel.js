$(document).ready(function() {
    $('#artikel').val('true');
});


function editArtikel(param) {
    console.log(param);
    var artikelId = $('#artikelIdText' + param).text();
    var kategoriId = $('#kategoriIdText' + param).text();
    var namaArtikel = $('#namaArtikelText' + param).text();
    var deskripsiArtikel = $('#deskripsiArtikelText' + param).text();
    var bodyArtikel = $('#bodyArtikelText' + param).text();
    var sumberArtikel = $('#sumberArtikelText' + param).text();

    $('.artikelIdEdit').val(artikelId);
    $('.kategoriIdEdit').val(kategoriId);
    $('.namaArtikelEdit').val(namaArtikel);
    $('.deskripsiArtikelEdit').val(deskripsiArtikel);
    $('.bodyArtikelEdit').val(bodyArtikel);
    $('.sumberArtikelEdit').val(sumberArtikel);

    // $('#edit-row-form').attr("action", "/status/edit");
    $('#editArtikel').modal('toggle');
}

function removeArtikel(param) {
    var artikelId = $('#artikelIdText' + param).text();
    var kategoriId = $('#kategoriIdText' + param).text();
    var namaArtikel = $('#namaArtikelText' + param).text();
    var deskripsiArtikel = $('#deskripsiArtikelText' + param).text();
    var bodyArtikel = $('#bodyArtikelText' + param).text();
    var sumberArtikel = $('#sumberArtikelText' + param).text();

    console.log(kategoriId);

    $('.artikelIdRemove').val(artikelId);
    $('.kategoriIdRemove').val(kategoriId);
    $('.namaArtikelRemove').val(namaArtikel);
    $('.deskripsiArtikelRemove').val(deskripsiArtikel);
    $('.bodyArtikelRemove').val(bodyArtikel);
    $('.sumberArtikelRemove').val(sumberArtikel);

//    $('.namaUserRemoveText').text(namaUser);
    // $('#remove-row-form').attr("action", "/status/edit");
    $('#removeArtikel').modal('toggle');
}


$(document).ready(function() {
    $('#kategori').val('true');
});/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


