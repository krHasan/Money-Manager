function printGetMoney(i, history){
  // post container frame
  $(".div-main").append('<div class="div-gmpost'+i+'-container"></div>')
  $(".div-gmpost"+i+"-container").css({
     "height": "145px",
     "width": "100%",
     "display": "flex",
     "flex-direction": "column",
     "border-radius": "10px",
     "margin-bottom": "25px",
     "border-style": "groove",
     "background-color": "white"
  });

  // frame inside div: container-2
  $(".div-gmpost"+i+"-container").append('<div class="div-gmpost'+i+'-container-2"></div>')
  $(".div-gmpost"+i+"-container-2").css({
     "height": "100px",
     "width": "100%",
     "display": "flex",
     "flex-direction": "row"
    //  "background-color": "#bae1ee"
  });

  // frame inside div: container-2, subcontainer-1
  $(".div-gmpost"+i+"-container-2").append('<div class="div-gmpost'+i+'-subcon-1"></div>')
  $(".div-gmpost"+i+"-subcon-1").css({
     "height": "105px",
     "width": "20%",
     "display": "flex",
     "flex-direction": "column"
    //  "background-color": "#fae1ee"
  });

  // frame inside div: container-2, subcontainer-1, holder-1
  $(".div-gmpost"+i+"-subcon-1").append('<div class="div-gmpost'+i+'-subcon-1-1"></div>')
  $(".div-gmpost"+i+"-subcon-1-1").css({
     "height": "50px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "18px",
     "padding-left": "10px",
     "vertical-align": "middle",
     "line-height": "50px" //the same as div height
    //  "background-color": "#fae55e"
  });

  // frame inside div: container-2, subcontainer-1, holder-2
  $(".div-gmpost"+i+"-subcon-1").append('<div class="div-gmpost'+i+'-subcon-1-2"></div>')
  $(".div-gmpost"+i+"-subcon-1-2").css({
     "height": "50px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "padding-left": "10px",
     "vertical-align": "middle",
     "line-height": "50px" //the same as div height
    //  "background-color": "#fa11ee"
  });

  // frame inside div: container-2, subcontainer-2
  $(".div-gmpost"+i+"-container-2").append('<div class="div-gmpost'+i+'-subcon-2"></div>')
  $(".div-gmpost"+i+"-subcon-2").css({
     "height": "105px",
     "width": "30%",
     "display": "flex",
     "flex-direction": "column"
    //  "background-color": "#bae132"
  });

  // frame inside div: container-2, subcontainer-2, holder-1
  $(".div-gmpost"+i+"-subcon-2").append('<div class="div-gmpost'+i+'-subcon-2-1"></div>')
  $(".div-gmpost"+i+"-subcon-2-1").css({
     "height": "50px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "50px" //the same as div height
    //  "background-color": "#20e55e"
  });

  // frame inside div: container-2, subcontainer-2, holder-2
  $(".div-gmpost"+i+"-subcon-2").append('<div class="div-gmpost'+i+'-subcon-2-2"></div>')
  $(".div-gmpost"+i+"-subcon-2-2").css({
     "height": "50px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "50px" //the same as div height
    //  "background-color": "#fbc55e"
  });

  // frame inside div: container-2, subcontainer-3
  $(".div-gmpost"+i+"-container-2").append('<div class="div-gmpost'+i+'-subcon-3"></div>')
  $(".div-gmpost"+i+"-subcon-3").css({
     "height": "105px",
     "width": "50%",
     "display": "flex",
     "flex-direction": "column"
    //  "background-color": "#b001ee"
  });

  // frame inside div: container-2, subcontainer-3, holder-1
  $(".div-gmpost"+i+"-subcon-3").append('<div class="div-gmpost'+i+'-subcon-3-1"></div>')
  $(".div-gmpost"+i+"-subcon-3-1").css({
     "height": "30px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "30px" //the same as div height
    //  "background-color": "#fb775e"
  });

  // frame inside div: container-2, subcontainer-3, holder-2
  $(".div-gmpost"+i+"-subcon-3").append('<div class="div-gmpost'+i+'-subcon-3-2"></div>')
  $(".div-gmpost"+i+"-subcon-3-2").css({
     "height": "25px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "25px" //the same as div height
    //  "background-color": "#01c55e"
  });

  // frame inside div: container-2, subcontainer-3, holder-3
  $(".div-gmpost"+i+"-subcon-3").append('<div class="div-gmpost'+i+'-subcon-3-3"></div>')
  $(".div-gmpost"+i+"-subcon-3-3").css({
     "height": "25px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "25px" //the same as div height
    //  "background-color": "#fb305e"
  });

  // frame inside div: container-2, subcontainer-3, holder-4
  $(".div-gmpost"+i+"-subcon-3").append('<div class="div-gmpost'+i+'-subcon-3-4"></div>')
  $(".div-gmpost"+i+"-subcon-3-4").css({
     "height": "25px",
     "width": "100%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "vertical-align": "middle",
     "line-height": "25px" //the same as div height
    //  "background-color": "#fbc504"
  });

  // frame insede div: get money description
  $(".div-gmpost"+i+"-container").append('<div class="div-gmdis'+i+'"></div>')
  $(".div-gmdis"+i+"").css({
     "height": "40px",
     "width": "98%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "14px",
     "padding-left": "10px",
     "vertical-align": "middle",
     "line-height": "40px" //the same as div height
    //  "background-color": "#bff1ee"
  });

  $(".div-gmpost"+i+"-subcon-1-1").append("<b>"+history.filter+"</b>")
  $(".div-gmpost"+i+"-subcon-1-2").append("Amount : " + "<b>"+history.gmAmount+"</b>")
  $(".div-gmpost"+i+"-subcon-2-1").append(history.gmDate+"   "+history.gmTime)
  $(".div-gmpost"+i+"-subcon-2-2").append("Source : " + history.gmSource)
  $(".div-gmpost"+i+"-subcon-3-1").append("Method : " + history.gmMethod)
  $(".div-gmpost"+i+"-subcon-3-2").append("Amount Nature : " + history.gmAmountNature)
  $(".div-gmpost"+i+"-subcon-3-3").append("Bank Charge : " + history.gmBankCharge)
  $(".div-gmpost"+i+"-subcon-3-4").append("Wallet Balance Before : "+history.gmWalletBalanceBefore+" Tk.   After : "+history.gmWalletBalanceAfter+" Tk.")
  $(".div-gmdis"+i+"").append("Discription: " + history.gmDescription)


}
