$ ->
  $.get "/products", (products) ->
    $.each products, (index, product) ->
      $('#products').append $("<li>").text product.name