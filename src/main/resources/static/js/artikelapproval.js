$(document).ready(function() {
    $('#artikelapproval').val('true');
});


function editArtikelApproval(param) {
    console.log(param);
    var artikelApprovalId = $('#artikelApprovalIdText' + param).text();
    var artikelId = $('#artikelIdText' + param).text();
    var approvalStatusId = $('#approvalStatusIdText' + param).text();
    var keteranganApproval = $('#keteranganApprovalText' + param).text();


    $('.artikelApprovalIdEdit').val(artikelApprovalId);
    $('.artikelIdEdit').val(artikelId);
    $('.approvalStatusIdEdit').val(approvalStatusId);
    $('.keteranganApprovalEdit').val(keteranganApproval);


    // $('#edit-row-form').attr("action", "/status/edit");
    $('#editArtikelApproval').modal('toggle');
}

function removeArtikelApproval(param) {
     var artikelApprovalId = $('#artikelApprovalIdText' + param).text();
     var artikelId = $('#artikelIdText' + param).text();
     var approvalStatusId = $('#approvalStatusIdText' + param).text();
     var keteranganApproval = $('#keteranganApprovalText' + param).text();

    console.log(approvalStatusId);

    $('.artikelApprovalIdRemove').val(artikelApprovalId);
    $('.artikelIdRemove').val(artikelId);
    $('.approvalStatusIdRemove').val(approvalStatusId);
    $('.keteranganApprovalRemove').val(keteranganApproval);

//    $('.namaUserRemoveText').text(namaUser);
    // $('#remove-row-form').attr("action", "/status/edit");
    $('#removeArtikelApproval').modal('toggle');
}


$(document).ready(function() {
    $('#approvalstatus').val('true');
});/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


