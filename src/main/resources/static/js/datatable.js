$(document).ready( function () {
	 var table = $('#userTable').DataTable({
			"sAjaxSource": "/userdatas",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			        { "mData": "userId"},
		            { "mData": "userName" },
				  { "mData": "namaUser" },
				  { "mData": "email" },
				  { "mData": "tanggalLahir" },
				  { "mData": "gender" }
				  { "mData": "fotoProfil" }
			]
	 })
});