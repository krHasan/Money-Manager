function printBorrow(i, history){
  // post container frame
  $(".div-main").append('<div class="div-bopost'+i+'-container"></div>')
  $(".div-bopost"+i+"-container").css({
     "height": "120px",
     "width": "100%",
     "display": "flex",
     "flex-direction": "row",
     "border-radius": "10px",
     "margin-bottom": "25px",
     "border-style": "groove",
     "background-color": "rgba(255,255,0,0.1)" //Yellow
  });

  // frame inside div: container-1
  $(".div-bopost"+i+"-container").html('<div class="div-bopost'+i+'-container-1"></div>')
  $(".div-bopost"+i+"-container-1").css({
     "height": "100%",
     "width": "22%",
     "display": "flex",
     "flex-direction": "column"
    //  "background-color": "#bae1ee"
  });

  // frame inside div: container-1, subcontainer-1
  $(".div-bopost"+i+"-container-1").append('<div class="div-bopost'+i+'-container-1-1"></div>')
  $(".div-bopost"+i+"-container-1-1").css({
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
  $(".div-bopost"+i+"-container-1").append('<div class="div-bopost'+i+'-container-1-2"></div>')
  $(".div-bopost"+i+"-container-1-2").css({
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
  $(".div-bopost"+i+"-container-1").append('<div class="div-bopost'+i+'-container-1-3"></div>')
  $(".div-bopost"+i+"-container-1-3").css({
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
  $(".div-bopost"+i+"-container").append('<div class="div-bopost'+i+'-container-2"></div>')
  $(".div-bopost"+i+"-container-2").css({
     "height": "100%",
     "width": "33%",
     "display": "flex",
     "flex-direction": "column"
    //  "background-color": "#bae132"
  });

  // frame inside div: container-2, subcontainer-1
  $(".div-bopost"+i+"-container-2").append('<div class="div-bopost'+i+'-container-2-1"></div>')
  $(".div-bopost"+i+"-container-2-1").css({
     "height": "40px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "40px" //the same as div height
    //  "background-color": "#fae85e"
  });

  // frame inside div: container-2, subcontainer-2
  $(".div-bopost"+i+"-container-2").append('<div class="div-bopost'+i+'-container-2-2"></div>')
  $(".div-bopost"+i+"-container-2-2").css({
     "height": "40px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "40px" //the same as div height
    //  "background-color": "#0ff1ee"
  });

  // frame inside div: container-2, subcontainer-3
  $(".div-bopost"+i+"-container-2").append('<div class="div-bopost'+i+'-container-2-3"></div>')
  $(".div-bopost"+i+"-container-2-3").css({
     "height": "40px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "40px" //the same as div height
    //  "background-color": "#fa11bb"
  });

  // frame inside div: container-3
  $(".div-bopost"+i+"-container").append('<div class="div-bopost'+i+'-container-3"></div>')
  $(".div-bopost"+i+"-container-3").css({
     "height": "100%",
     "width": "45%",
     "display": "flex",
     "flex-direction": "column"
    //  "background-color": "#b001ee"
  });

  // frame inside div: container-3, subcontainer-1
  $(".div-bopost"+i+"-container-3").append('<div class="div-bopost'+i+'-container-3-1"></div>')
  $(".div-bopost"+i+"-container-3-1").css({
     "height": "30px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "30px" //the same as div height
    //  "background-color": "#fb775e"
  });

  // frame inside div: container-3, subcontainer-2
  $(".div-bopost"+i+"-container-3").append('<div class="div-bopost'+i+'-container-3-2"></div>')
  $(".div-bopost"+i+"-container-3-2").css({
     "height": "30px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "30px" //the same as div height
    //  "background-color": "#01c55e"
  });

  // frame inside div: container-3, subcontainer-3
  $(".div-bopost"+i+"-container-3").append('<div class="div-bopost'+i+'-container-3-3"></div>')
  $(".div-bopost"+i+"-container-3-3").css({
     "height": "30px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "30px" //the same as div height
    //  "background-color": "#fb305e"
  });

  // frame inside div: container-3, subcontainer-4
  $(".div-bopost"+i+"-container-3").append('<div class="div-bopost'+i+'-container-3-4"></div>')
  $(".div-bopost"+i+"-container-3-4").css({
     "height": "30px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "30px" //the same as div height
    //  "background-color": "#fbc504"
  });

  $(".div-bopost"+i+"-container-1-1").append("<b>"+history.filter+"</b>")
  $(".div-bopost"+i+"-container-1-2").append("Amount : " + "<b>"+history.boTk+"</b>")
  $(".div-bopost"+i+"-container-1-3").append("Exact Amount : " + "<b>"+history.boExactTk+"</b>")
  $(".div-bopost"+i+"-container-2-1").append(history.boDate+"   "+history.boTime)
  $(".div-bopost"+i+"-container-2-2").append("Type : " + history.boType)
  $(".div-bopost"+i+"-container-2-3").append("Borrow Transaction With : " + history.boWhom)
  $(".div-bopost"+i+"-container-3-1").append("Method : " + history.boMethod)
  $(".div-bopost"+i+"-container-3-2").append("Amount Nature : "+history.boNature)
  $(".div-bopost"+i+"-container-3-3").append("Bank Charge : " + history.boBnkCharge)
  $(".div-bopost"+i+"-container-3-4").append("Total Borrow Tk. Before : "+history.boBalanceBefore+" Tk.   After : "+history.boBalanceAfter+" Tk.")

}
