function printBorrow(i, history){
  // post container frame
  $(".div-main").append('<div class="div-bopost'+i+'-container"></div>')
  $(".div-bopost"+i+"-container").css({
     "height": "125px",
     "width": "100%",
     "display": "flex",
     "flex-direction": "row",
     "padding": "5px 0px",
     "border-bottom": "1px solid purple",
     "background-color": (i%2 == 0) ? "#ebebeb" : "#f5f5f5" //shade of white
  });

  // frame inside div: container-1
  $(".div-bopost"+i+"-container").html('<div class="div-bopost'+i+'-container-1"></div>')
  $(".div-bopost"+i+"-container-1").css({
     "height": "100%",
     "width": "35%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#bae1ee"
  });

  // frame inside div: container-2
  $(".div-bopost"+i+"-container").append('<div class="div-bopost'+i+'-container-2"></div>')
  $(".div-bopost"+i+"-container-2").css({
     "height": "100%",
     "width": "40%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#bae132"
  });

  // frame inside div: container-3
  $(".div-bopost"+i+"-container").append('<div class="div-bopost'+i+'-container-3"></div>')
  $(".div-bopost"+i+"-container-3").css({
     "height": "100%",
     "width": "25%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#b001ee"
  });

  $(".div-bopost"+i+"-container-1").append("<span style='font-weight: bold; color: #3498db; font-size: 20px; line-height: 35px'>"+history.filter+"</span>"+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 25px'>Amount  </span>" + "<span style='font-weight: bold; font-size: 18px'>"+history.boTk+" TK</span>"+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 25px'>Exact Amount  </span>" + "<span style='font-weight: bold; font-size: 18px'>"+history.boExactTk+" TK</span>"+"<br>"+
                                           "<span style='color: #8f8f8f; line-height: 25px'>"+history.boDate+"   "+history.boTime+"</span>")
  // $(".div-bopost"+i+"-container-1-2").append("Amount : " + "<b>"+history.boTk+"</b>")
  // $(".div-bopost"+i+"-container-1-3").append("Exact Amount : " + "<b>"+history.boExactTk+"</b>")
  $(".div-bopost"+i+"-container-2").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 22px'>Method  </span>" + history.boMethod+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 22px'>Amount Nature  </span>" + history.boNature+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 22px'>Bank Charge  </span>" + history.boBnkCharge+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 22px'>Type  </span>" + history.boType+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 22px'>Borrow Transaction With  </span>" + history.boWhom)
  // $(".div-bopost"+i+"-container-2-2").append("Type : " + history.boType)
  // $(".div-bopost"+i+"-container-2-3").append("Borrow Transaction With : " + history.boWhom)
  $(".div-bopost"+i+"-container-3").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 30px'>Total Borrowed TK</span>"+"<br>"+
                                           "<span style='line-height: 23px'>Before  </span>"+history.boBalanceBefore+" Tk."+"<br>"+
                                           "<span style='line-height: 23px'>After  </span>"+history.boBalanceAfter+" Tk.")

  // $(".div-bopost"+i+"-container-3-2").append("Amount Nature : "+history.boNature)
  // $(".div-bopost"+i+"-container-3-3").append("Bank Charge : " + history.boBnkCharge)
  // $(".div-bopost"+i+"-container-3-4").append("Total Borrow Tk. Before : "+history.boBalanceBefore+" Tk.   After : "+history.boBalanceAfter+" Tk.")

}
