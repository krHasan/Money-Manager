function printExpense(i, history){
  // post container frame
  $(".div-main").append('<div class="div-expost'+i+'-container"></div>')
  $(".div-expost"+i+"-container").css({
     "height": "120px",
     "width": "100%",
     "display": "flex",
     "flex-direction": "column",
     "border-radius": "10px",
     "margin-bottom": "25px",
     "border-style": "groove",
     "background-color": "rgba(255,0,255,0.1)"  //Cerise
  });

  // frame inside div: container-2
  $(".div-expost"+i+"-container").append('<div class="div-expost'+i+'-container-2"></div>')
  $(".div-expost"+i+"-container-2").css({
     "height": "85px",
     "width": "100%",
     "display": "flex",
     "flex-direction": "row"
    //  "background-color": "#bae1ee"
  });

  // frame inside div: container-2, subcontainer-1
  $(".div-expost"+i+"-container-2").append('<div class="div-expost'+i+'-subcon-1"></div>')
  $(".div-expost"+i+"-subcon-1").css({
     "height": "100%",
     "width": "20%",
     "display": "flex",
     "flex-direction": "column"
    //  "background-color": "#fae1ee"
  });

  // frame inside div: container-2, subcontainer-1, holder-1
  $(".div-expost"+i+"-subcon-1").append('<div class="div-expost'+i+'-subcon-1-1"></div>')
  $(".div-expost"+i+"-subcon-1-1").css({
     "height": "45px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "18px",
     "padding-left": "10px",
     "vertical-align": "middle",
     "line-height": "45px" //the same as div height
    //  "background-color": "#fae55e"
  });

  // frame inside div: container-2, subcontainer-1, holder-2
  $(".div-expost"+i+"-subcon-1").append('<div class="div-expost'+i+'-subcon-1-2"></div>')
  $(".div-expost"+i+"-subcon-1-2").css({
     "height": "40px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "padding-left": "10px",
     "vertical-align": "middle",
     "line-height": "40px" //the same as div height
    //  "background-color": "#fa11ee"
  });

  // frame inside div: container-2, subcontainer-2
  $(".div-expost"+i+"-container-2").append('<div class="div-expost'+i+'-subcon-2"></div>')
  $(".div-expost"+i+"-subcon-2").css({
     "height": "100%",
     "width": "30%",
     "display": "flex",
     "flex-direction": "column"
    //  "background-color": "#bae132"
  });

  // frame inside div: container-2, subcontainer-2, holder-1
  $(".div-expost"+i+"-subcon-2").append('<div class="div-expost'+i+'-subcon-2-1"></div>')
  $(".div-expost"+i+"-subcon-2-1").css({
     "height": "45px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "45px" //the same as div height
    //  "background-color": "#20e55e"
  });

  // frame inside div: container-2, subcontainer-2, holder-2
  $(".div-expost"+i+"-subcon-2").append('<div class="div-expost'+i+'-subcon-2-2"></div>')
  $(".div-expost"+i+"-subcon-2-2").css({
     "height": "40px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "40px" //the same as div height
    //  "background-color": "#fbc55e"
  });

  // frame inside div: container-2, subcontainer-3
  $(".div-expost"+i+"-container-2").append('<div class="div-expost'+i+'-subcon-3"></div>')
  $(".div-expost"+i+"-subcon-3").css({
     "height": "100%",
     "width": "50%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "85px" //the same as div height
    //  "background-color": "#b001ee"
  });

  // frame insede div: get money description
  $(".div-expost"+i+"-container").append('<div class="div-exdis'+i+'"></div>')
  $(".div-exdis"+i+"").css({
     "height": "35px",
     "width": "98%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "padding-left": "10px",
     "vertical-align": "middle",
     "line-height": "35px" //the same as div height
    //  "background-color": "#bff1ee"
  });

  $(".div-expost"+i+"-subcon-1-1").append("<b>"+history.filter+"</b>")
  $(".div-expost"+i+"-subcon-1-2").append("Amount : " + "<b>"+history.exAmount+"</b>")
  $(".div-expost"+i+"-subcon-2-1").append(history.exDate+"   "+history.exTime)
  $(".div-expost"+i+"-subcon-2-2").append("Sector : " + history.exSector)
  $(".div-expost"+i+"-subcon-3").append("Wallet Balance Before : "+history.exWalletBalanceBefore+" Tk.   After : "+history.exWalletBalanceAfter+" Tk.")
  $(".div-exdis"+i+"").append("Discription: " + history.exDescription)

}
