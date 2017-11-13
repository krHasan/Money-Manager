function printPersonal(i, history){
  // post container frame
  $(".div-main").append('<div class="div-perpost'+i+'-container"></div>')
  $(".div-perpost"+i+"-container").css({
     "height": "120px",
     "width": "100%",
     "display": "flex",
     "flex-direction": "row",
     "border-radius": "10px",
     "margin-bottom": "25px",
     "border-style": "groove",
     "background-color": "rgba(150,200,90,0.1)" //Blue
  });

  // frame inside div: container-1
  $(".div-perpost"+i+"-container").append('<div class="div-perpost'+i+'-container-1"></div>')
  $(".div-perpost"+i+"-container-1").css({
     "height": "100%",
     "width": "40%",
     "display": "flex",
     "flex-direction": "column"
    //  "background-color": "#bae1ee"
  });

  // frame inside div: container-1, subcontainer-1
  $(".div-perpost"+i+"-container-1").append('<div class="div-perpost'+i+'-container-1-1"></div>')
  $(".div-perpost"+i+"-container-1-1").css({
     "height": "40px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "18px",
     "padding-left": "10px",
     "vertical-align": "middle",
     "line-height": "40px" //the same as div height
    //  "background-color": "#fae1ee"
  });

  // frame inside div: container-1, subcontainer-2
  $(".div-perpost"+i+"-container-1").append('<div class="div-perpost'+i+'-container-1-2"></div>')
  $(".div-perpost"+i+"-container-1-2").css({
     "height": "40px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "padding-left": "10px",
     "vertical-align": "middle",
     "line-height": "40px" //the same as div height
    //  "background-color": "#00e1ee"
  });

  // frame inside div: container-1, subcontainer-3
  $(".div-perpost"+i+"-container-1").append('<div class="div-perpost'+i+'-container-1-3"></div>')
  $(".div-perpost"+i+"-container-1-3").css({
     "height": "40px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "padding-left": "10px",
     "vertical-align": "middle",
     "line-height": "40px" //the same as div height
    //  "background-color": "#fa11ee"
  });

  // frame inside div: container-2
  $(".div-perpost"+i+"-container").append('<div class="div-perpost'+i+'-container-2"></div>')
  $(".div-perpost"+i+"-container-2").css({
     "height": "100%",
     "width": "60%",
     "display": "flex",
     "flex-direction": "column"
    //  "background-color": "#bae132"
  });

  // frame inside div: container-2, subcontainer-1
  $(".div-perpost"+i+"-container-2").append('<div class="div-perpost'+i+'-container-2-1"></div>')
  $(".div-perpost"+i+"-container-2-1").css({
     "height": "40px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "40px" //the same as div height
    //  "background-color": "#fae85e"
  });

  // frame inside div: container-2, subcontainer-2
  $(".div-perpost"+i+"-container-2").append('<div class="div-perpost'+i+'-container-2-2"></div>')
  $(".div-perpost"+i+"-container-2-2").css({
     "height": "40px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "40px" //the same as div height
    //  "background-color": "#0ff1ee"
  });

  // frame inside div: container-2, subcontainer-3
  $(".div-perpost"+i+"-container-2").append('<div class="div-perpost'+i+'-container-2-3"></div>')
  $(".div-perpost"+i+"-container-2-3").css({
     "height": "40px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "40px" //the same as div height
    //  "background-color": "#fa11bb"
  });

  $(".div-perpost"+i+"-container-1-1").append("<b>"+history.filter+"</b>")
  $(".div-perpost"+i+"-container-1-2").append("Amount : " + "<b>"+history.perAmount+"</b>")
  $(".div-perpost"+i+"-container-2-1").append(history.perDate+"   "+history.perTime)
  $(".div-perpost"+i+"-container-2-2").append("Amount Nature : " + history.perNature)
  $(".div-perpost"+i+"-container-2-3").append("Account Balance - Before : "+history.perBalanceBefore+" Tk.   After : "+history.perBalanceAfter+" Tk.")

}
