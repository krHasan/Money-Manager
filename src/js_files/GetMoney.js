function printGetMoney(i, history){
  // post container frame
  $(".div-main").append('<div class="div-gmpost'+i+'-container"></div>')
  $(".div-gmpost"+i+"-container").css({
     "height": "125px",
     "width": "100%",
     "display": "flex",
     "flex-direction": "column",
     "padding": "5px 0px",
     "border-bottom": "1px solid purple",
     "background-color": (i%2 == 0) ? "#ebebeb" : "#f5f5f5" //shade of white
  });

  // frame inside div: container-1
  $(".div-gmpost"+i+"-container").html('<div class="div-gmpost'+i+'-container-2"></div>')
  $(".div-gmpost"+i+"-container-2").css({
     "height": "85px",
     "width": "100%",
     "display": "flex",
     "flex-direction": "row"
    //  "background-color": "#bae1ee"
  });

  // frame inside div: container-1, subcontainer-1
  $(".div-gmpost"+i+"-container-2").append('<div class="div-gmpost'+i+'-subcon-1"></div>')
  $(".div-gmpost"+i+"-subcon-1").css({
     "height": "100%",
     "width": "35%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#fae1ee"
  });

  // frame inside div: container-1, subcontainer-2
  $(".div-gmpost"+i+"-container-2").append('<div class="div-gmpost'+i+'-subcon-2"></div>')
  $(".div-gmpost"+i+"-subcon-2").css({
     "height": "100%",
     "width": "40%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#bae132"
  });

  // frame inside div: container-1, subcontainer-3
  $(".div-gmpost"+i+"-container-2").append('<div class="div-gmpost'+i+'-subcon-3"></div>')
  $(".div-gmpost"+i+"-subcon-3").css({
     "height": "100%",
     "width": "25%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#b001ee"
  });

  // frame insede div: get money description
  $(".div-gmpost"+i+"-container").append('<div class="div-gmdis'+i+'"></div>')
  $(".div-gmdis"+i+"").css({
     "height": "40px",
     "width": "98%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "vertical-align": "middle",
     "line-height": "40px" //the same as div height
    //  "background-color": (i%2 == 0) ? "#f0f0f0" : "#e2e2e2"
  });

  $(".div-gmpost"+i+"-subcon-1").append("<span style='font-weight: bold; color: #00b159; font-size: 20px; line-height: 30px'>"+history.filter+"</span>"+"<br>"+//304FFE
                                        "<span style='font-weight: bold; font-size: 18px; line-height: 30px'>"+history.gmAmount+" TK</span>"+"<br>"+
                                        "<span style='color: #8f8f8f; line-height: 20px'>"+history.gmDate+"   "+history.gmTime+"</span>")

  $(".div-gmpost"+i+"-subcon-2").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 20px'>Source  </span>" + history.gmSource+"<br>"+
                                        "<span style='font-weight: bold; color: #8f8f8f; line-height: 20px'>Method  </span>" + history.gmMethod+"<br>"+
                                        "<span style='font-weight: bold; color: #8f8f8f; line-height: 20px'>Amount Nature  </span>" + history.gmAmountNature+"<br>"+
                                        "<span style='font-weight: bold; color: #8f8f8f; line-height: 20px'>Bank Charge  </span>" + history.gmBankCharge)

  $(".div-gmpost"+i+"-subcon-3").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 30px'>Wallet Balance</span>"+"<br>"+
                                        "<span style='line-height: 23px'>Before  </span>"+history.gmWalletBalanceBefore+" Tk."+"<br>"+
                                        "<span style='line-height: 23px'>After  </span>"+history.gmWalletBalanceAfter+" Tk.")

  $(".div-gmdis"+i+"").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 40px'>Discription  </span>" + history.gmDescription)

}
