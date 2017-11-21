function noResultFound() {
  $(".div-main").append('<div class="div-noResult-container"></div>')
  $(".div-noResult-container").css({
     "height": "450px",
     "width": "100%",
     "display": "flex",
     "background-color": "#f5f5f5" //shade of white
  });

  // frame inside div: container-1
  $(".div-noResult-container").html('<div class="div-noResult-container-1"></div>')
  $(".div-noResult-container-1").css({
     "height": "100%",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "18px",
     "font-weight": "bold",
     "color": "#8f8f8f",
     "text-align": "center",
     "vertical-align": "middle",
     "line-height": "350px"
    //  "background-color": "#bae1ee"
  });

  $(".div-noResult-container-1").append("Sorry, No Result Found!")
}
