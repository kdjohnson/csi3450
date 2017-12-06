
$(document).ready(function() {
    $('.button-collapse').sideNav();
    $('select').material_select();
    $('#limit-count').change(function() {
        $('#get-table').removeAttr('disabled');
    });

    $('#get-table').click(function() {
        $('#data-table').empty();
        $('#clear-table').removeAttr('disabled');
        $.ajax({
            type: 'POST',
            url: '/api/v1/' + $('#table-name-select').val(),
            dataType: 'json',
            data: {
                limit: $('#limit-count').val(),
                table: $('#table-name-select').val()
            },
            success: function(data) {
                if (data.length !== 0) {
                    headers = Object.keys(data[0]);
                    $('#data-table').append('<thead></thead>');
                    $('#data-table thead').append('<tr></tr>');
                    for (var i = 0; i < headers.length; i++) {
                        $('#data-table thead tr')
                            .append('<td>' + headers[i] + '</td>');
                    }
                    $('#data-table').append('<tbody></tbody>');

                    for (var i = 1; i < data.length; i++) {
                        $('#data-table tbody').append('<tr></tr>');
                        for (var j = 0; j < headers.length; j++) {
                            $('#data-table tbody')
                                .append(
                                    '<td>' + data[i]['' + headers[j] + ''] +
                                    '</td>');
                        }
                    }
                }
            },
            error: function(xhr) {
                console.error(xhr);
                console.error('Error retrieving data with ajax call');
            }
        });
    });


    $('#clear-table').click(function() {
        $('#data-table').empty();
    });

    $('#table-name-select-add').change(function() {
        $('#form-area-add').empty();
        $.ajax({
            type: 'POST',
            url: '/api/v1/describeTable',
            dataType: 'json',
            data: {table: this.value},
            success: function(data) {
                $('#insert-table').removeAttr('disabled');
                for (var i = 1; i < data['names'].length; i++) {
                    $('#form-area-add')
                        .append(
                            '<div class="row">' +
                            '<div class="input-field col s12"> ' +
                            '<input id="' + data['names'][i] +
                            '" type="text" class="validate"> ' +
                            ' <label for="' + data['names'][i] + '">' +
                            data['names'][i] + '</label> ' +
                            ' </div></div> ');
                }
            },
            error: function(xhr) {
                console.error(xhr);
                console.error('Error retrieving data with ajax call');
            }
        });

    });

    $('#insert-table').click(function() {
        var data = new Object();
        $('#form-area-add input').each(function() {
            var tmp = $(this).attr('id');
            data[tmp] = $(this).val();
        });

        $.ajax({
            type: 'POST',
            url: '/api/v1/insert/' + $('#table-name-select-add').val(),
            dataType: 'json',
            data: data,
            success: function(data) {
                console.log(data);
                if (data === 1) {
                    Materialize.toast(
                        'Inserted successfully',
                        4000)  // 4000 is the duration of the toast
                } else {
                    Materialize.toast(
                        'Insert failed',
                        4000)  // 4000 is the duration of the toast
                }
            },
            error: function(xhr) {
                console.error(xhr);
                console.error('Error retrieving data with ajax call');
            }
        });
    });

    $('#table-name-select-update').change(function() {
        $('#form-area-update').empty();
        $.ajax({
            type: 'POST',
            url: '/api/v1/describeTable',
            dataType: 'json',
            data: {table: this.value},
            success: function(data) {
                $('#update-table').removeAttr('disabled');
                for (var i = 0; i < data['names'].length; i++) {
                    $('#form-area-update')
                        .append(
                            '<div class="row">' +
                            '<div class="input-field col s12"> ' +
                            '<input id="' + data['names'][i] +
                            '" type="text" class="validate"> ' +
                            ' <label for="' + data['names'][i] + '">' +
                            data['names'][i] + '</label> ' +
                            ' </div></div> ');
                }
            },
            error: function(xhr) {
                console.error(xhr);
                console.error('Error retrieving data with ajax call');
            }
        });
    });

    $('#update-table').click(function() {
        var data = new Object();
        $('#form-area-update input').each(function() {
            var tmp = $(this).attr('id');
            data[tmp] = $(this).val();
        });

        $.ajax({
            type: 'POST',
            url: '/api/v1/update/' + $('#table-name-select-update').val(),
            dataType: 'json',
            data: data,
            success: function(data) {
                console.log(data);
                if (data === 1) {
                    Materialize.toast(
                        'Updated successfully',
                        4000)  // 4000 is the duration of the toast
                } else {
                    Materialize.toast(
                        'Update failed',
                        4000)  // 4000 is the duration of the toast
                }
            },
            error: function(xhr) {
                console.error(xhr);
                console.error('Error retrieving data with ajax call');
            }
        });
    });


    $('#table-name-select-delete').change(function() {
        $('#delete-table').removeAttr('disabled');
    });

    $('#delete-table').click(function() {
        console.log($('#primary-key').val());
        $.ajax({
            type: 'POST',
            url: '/api/v1/delete/' + $('#table-name-select-delete').val(),
            dataType: 'json',
            data: {key: $('#primary-key').val()},
            success: function(data) {
                console.log(data);
                if (data === 1) {
                    Materialize.toast(
                        'Deleted successfully',
                        4000)  // 4000 is the duration of the toast
                } else {
                    Materialize.toast(
                        'Delete failed',
                        4000)  // 4000 is the duration of the toast
                }
            },
            error: function(xhr) {
                console.error(xhr);
                console.error('Error retrieving data with ajax call');
            }
        });

    });

});
