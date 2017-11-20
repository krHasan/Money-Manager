function printbKash(i, history){
  // post container frame
  $(".div-main").append('<div class="div-bkpost'+i+'-container"></div>')
  $(".div-bkpost"+i+"-container").css({
     "height": "125px",
     "width": "100%",
     "display": "flex",
     "flex-direction": "row",
     "padding": "5px 0px",
     "border-bottom": "1px solid purple",
     "background-color": (i%2 == 0) ? "#ebebeb" : "#f5f5f5" //shade of white
  });

  // frame inside div: container-1
  $(".div-bkpost"+i+"-container").html('<div class="div-bkpost'+i+'-container-1"></div>')
  $(".div-bkpost"+i+"-container-1").css({
     "height": "100%",
     "width": "35%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#bae1ee"
  });

  // frame inside div: container-2
  $(".div-bkpost"+i+"-container").append('<div class="div-bkpost'+i+'-container-2"></div>')
  $(".div-bkpost"+i+"-container-2").css({
     "height": "100%",
     "width": "40%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#bae132"
  });

  // frame inside div: container-3
  $(".div-bkpost"+i+"-container").append('<div class="div-bkpost'+i+'-container-3"></div>')
  $(".div-bkpost"+i+"-container-3").css({
     "height": "100%",
     "width": "25%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#b001ee"
  });

  $(".div-bkpost"+i+"-container-1").append("<span style='font-weight: bold; color: #ff1393; font-size: 20px; line-height: 40px'>"+history.filter+"</span>"+"<br>"+
                                           "<span style='font-weight: bold; font-size: 18px; line-height: 30px'>"+history.bkAmount+" TK</span>"+"<br>"+
                                           "<span style='color: #8f8f8f; line-height: 30px'>"+history.bkDate+"   "+history.bkTime+"</span>")

  $(".div-bkpost"+i+"-container-2").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 30px'>Transaction Type  </span>" + history.bkType+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 30px'>Amount Nature  </span>" + history.bkNature+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 30px'>Bank Charge  </span>" + history.bkBnkCharge)

  $(".div-bkpost"+i+"-container-3").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 30px'>Account Balance</span>"+"<br>"+
                                            "<span style='line-height: 23px'>Before  </span>"+history.bkBalanceBefore+" Tk."+"<br>"+
                                            "<span style='line-height: 23px'>After  </span>"+history.bkBalanceAfter+" Tk.")
  // $(".div-bkpost"+i+"-container-3-2").append("Bank Charge : " + history.bkBnkCharge)
  // $(".div-bkpost"+i+"-container-3-3").append("Account Balance - Before : "+history.bkBalanceBefore+" Tk.   After : "+history.bkBalanceAfter+" Tk.")

}
