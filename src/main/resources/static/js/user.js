$(document).ready(function() {
    $('#user').val('true');
});


function editUser(param) {
    console.log(param);
    var userId = $('#userIdText' + param).text();
    var roleId = $('#roleIdText' + param).text();
    var username = $('#usernameText' + param).text();
    var namaUser = $('#namaUserText' + param).text();
    var email = $('#emailText' + param).text();
    var password = $('#passwordText' + param).text();

    $('.userIdEdit').val(userId);
    $('.roleIdEdit').val(roleId);
    $('.usernameEdit').val(username);
    $('.namaUserEdit').val(namaUser);
    $('.emailEdit').val(email);
    $('.passwordEdit').val(password);

    // $('#edit-row-form').attr("action", "/status/edit");
    $('#editUser').modal('toggle');
}

function removeUser(param) {
    var userId = $('#userIdText' + param).text();
    var roleId = $('#roleIdText' + param).text();
    var username = $('#usernameText' + param).text();
    var namaUser = $('#namaUserText' + param).text();
    var email = $('#emailText' + param).text();
    var password = $('#passwordText' + param).text();

    console.log(roleId);

    $('.userIdRemove').val(userId);
    $('.roleIdRemove').val(roleId);
    $('.usernameRemove').val(username);
    $('.namaUserRemove').val(namaUser);
    $('.emailRemove').val(email);
    $('.passwordRemove').val(password);

    $('.namaUserRemoveText').text(namaUser);
    // $('#remove-row-form').attr("action", "/status/edit");
    $('#removeUser').modal('toggle');
}


$(document).ready(function() {
    $('#user').val('true');
});/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


