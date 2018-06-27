function printRocket(i, history){
  // post container frame
  $(".div-main").append('<div class="div-rocpost'+i+'-container"></div>')
  $(".div-rocpost"+i+"-container").css({
     "height": "125px",
     "width": "100%",
     "display": "flex",
     "flex-direction": "row",
     "padding": "5px 0px",
     "border-bottom": "1px solid purple",
     "background-color": (i%2 == 0) ? "#ebebeb" : "#f5f5f5" //shade of white
  });

  // frame inside div: container-1
  $(".div-rocpost"+i+"-container").html('<div class="div-rocpost'+i+'-container-1"></div>')
  $(".div-rocpost"+i+"-container-1").css({
     "height": "100%",
     "width": "35%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#bae1ee"
  });

  // frame inside div: container-2
  $(".div-rocpost"+i+"-container").append('<div class="div-rocpost'+i+'-container-2"></div>')
  $(".div-rocpost"+i+"-container-2").css({
     "height": "100%",
     "width": "40%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#bae132"
  });

  // frame inside div: container-3
  $(".div-rocpost"+i+"-container").append('<div class="div-rocpost'+i+'-container-3"></div>')
  $(".div-rocpost"+i+"-container-3").css({
     "height": "100%",
     "width": "25%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#b001ee"
  });

  $(".div-rocpost"+i+"-container-1").append("<span style='font-weight: bold; color: #9b59b6; font-size: 20px; line-height: 40px'>"+history.filter+"</span>"+"<br>"+
                                           "<span style='font-weight: bold; font-size: 18px; line-height: 30px'>"+history.rocAmount+" TK</span>"+"<br>"+
                                           "<span style='color: #8f8f8f; line-height: 30px'>"+history.rocDate+"   "+history.rocTime+"</span>")

  $(".div-rocpost"+i+"-container-2").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 30px'>Transaction Type  </span>" + history.rocType+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 30px'>Amount Nature  </span>" + history.rocNature+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 30px'>Bank Charge  </span>" + history.rocBnkCharge)

  $(".div-rocpost"+i+"-container-3").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 30px'>Account Balance</span>"+"<br>"+
                                            "<span style='line-height: 23px'>Before  </span>"+history.rocBalanceBefore+" Tk."+"<br>"+
                                            "<span style='line-height: 23px'>After  </span>"+history.rocBalanceAfter+" Tk.")

}
