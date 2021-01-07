$(document).ready(function() {

    $("#query").click(function(event){

      var id = $("#id").val();

      /*
       * Check if the Id field is not empty.
       */
      if (id.trim()=== "") {

          alert("Please, type an Id!");

          $( "#id" ).focus();
          return;
      }

      $.ajax({
          url: '/users/' + id,
          data: {
              /*id: id*/
          },
          type: 'GET',
          success: function(data) {

              $('#first').val(data.firstName);
              $('#last').val(data.lastName);
              $('#username').val(data.username);
              $('#birth').val(data.birth);
              $('#status').val(data.status);
          },
          error: function() {
              alert("Error while retrieving Data!!!");
          }
      });
    });

    $("#save").click(function(event){

        /*
         * Check if all the text fields contain information before saving it.
         */
        var empty = $(this).parent().find("input").filter(function() {
            return this.value === "";
        });

        if (empty.length) {
            alert("Please, fill out all the fields!");
            return;
        }

        /*
         * Proceed if all the fields are complete.
         */

        var id = $("#id").val();
        var birth = $("#birth").val();
        var first = $("#first").val();
        var last = $("#last").val();
        var username = $("#username").val();

        $.ajax({
            url: '/users/' + id,
            /*
             * Create a JSON Object with the information of the Form.
             */
            data: JSON.stringify({
                   'idUser': id,
                   'birth': birth,
                   'firstName': first,
                   'lastName': last,
                   'username': username
            }),
            type: 'PUT', /* Use the HTTP verb PUT to update information in the server. */
            contentType: 'application/json', /* Tell Spring the information comes in JSON format. */
            success: function(data) {
                alert("The information was updated successfully!");
                $("input[type='text']").val(''); /* Clean up the text-box fields of the form. */
            },
            error: function() {
                alert("Error while updating data!!!");
            }
        });
    });

    /*
     * Clean the HTML form.
     */
    $("#clear").click(function(event){
        $("input[type='text']").val('');
    });
 });
