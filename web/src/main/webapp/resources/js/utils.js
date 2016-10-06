$(document).ready(function(){
    $('#addPerson').click(function () {
        addPerson();
    });
    $('#deletePerson').click(function () {
        deletePerson();
    });
    $('#productAdd').click(function () {
        addProduct();
    });
    $('#productUpdate').click(function () {
        updateProduct();
    });
    $('#productDelete').click(function () {
        deleteProduct();
    });
});


function addPerson() {
    $('#personForm').prop('action', 'add.form');
    $('#personButton').prop('value', 'Add person');
    $('#personForm').show();
}

function deletePerson() {
    $('#personForm').prop('action', 'delete.form');
    $('#personButton').prop('value', 'Delete person');
    $('#personForm').show();
}

function addProduct() {
    var name = $("#name").val();
    var model = $("#model").val();
    var price = $("#price").val();

    var product = {
        name: name,
        model: model,
        price: price
    };
    $.ajax({
        data:product,
        dataType: "json",
        method:"POST",
        url: "../products"
    }).done(function(data) {

    }).fail(function(data){
        if ( console && console.log ) {
            console.log( "Error data:", data.slice( 0, 100 ) );
        }
    });
}

function deleteProduct() {
    var id = $("#id").val();
    var url = "/products/" + id;

    $.ajax({
        headers:"accept: application/json",
        method:"DELETE",
        url: url
    }).done(function(data) {

    }).fail(function(data){
        if ( console && console.log ) {
            console.log( "Error data:", data.slice( 0, 100 ) );
        }
    });
}

