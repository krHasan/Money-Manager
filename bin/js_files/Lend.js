function printLend(i, history){
  // post container frame
  $(".div-main").append('<div class="div-lepost'+i+'-container"></div>')
  $(".div-lepost"+i+"-container").css({
    "height": "125px",
    "width": "100%",
    "display": "flex",
    "flex-direction": "row",
    "padding": "5px 0px",
    "border-bottom": "1px solid purple",
    "background-color": (i%2 == 0) ? "#ebebeb" : "#f5f5f5" //shade of white
  });

  // frame inside div: container-1
  $(".div-lepost"+i+"-container").html('<div class="div-lepost'+i+'-container-1"></div>')
  $(".div-lepost"+i+"-container-1").css({
     "height": "100%",
     "width": "35%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#bae1ee"
  });

  // frame inside div: container-2
  $(".div-lepost"+i+"-container").append('<div class="div-lepost'+i+'-container-2"></div>')
  $(".div-lepost"+i+"-container-2").css({
     "height": "100%",
     "width": "40%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#bae132"
  });

  // frame inside div: container-3
  $(".div-lepost"+i+"-container").append('<div class="div-lepost'+i+'-container-3"></div>')
  $(".div-lepost"+i+"-container-3").css({
     "height": "100%",
     "width": "25%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#b001ee"
  });

  $(".div-lepost"+i+"-container-1").append("<span style='font-weight: bold; color: #d35400; font-size: 20px; line-height: 35px'>"+history.filter+"</span>"+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 25px'>Amount  </span>" + "<span style='font-weight: bold; font-size: 18px'>"+history.leTk+" TK</span>"+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 25px'>Exact Amount  </span>" + "<span style='font-weight: bold; font-size: 18px'>"+history.leExactTk+" TK</span>"+"<br>"+
                                           "<span style='color: #8f8f8f; line-height: 25px'>"+history.leDate+"   "+history.leTime+"</span>")
  // $(".div-lepost"+i+"-container-1-2").append("Amount : " + "<b>"+history.leTk+"</b>")
  // $(".div-lepost"+i+"-container-1-3").append("Exact Amount : " + "<b>"+history.leExactTk+"</b>")
  $(".div-lepost"+i+"-container-2").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 22px'>Method  </span>" + history.leMethod+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 22px'>Amount Nature  </span>" + history.leNature+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 22px'>Bank Charge  </span>" + history.leBnkCharge+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 22px'>Type  </span>" + history.leType+"<br>"+
                                           "<span style='font-weight: bold; color: #8f8f8f; line-height: 22px'>Lend Transaction With  </span>" + history.leWhom)
  // $(".div-lepost"+i+"-container-2-2").append("Type : " + history.leType)
  // $(".div-lepost"+i+"-container-2-3").append("Lend Transaction With : " + history.leWhom)
  $(".div-lepost"+i+"-container-3").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 30px'>Total Lended TK.</span>"+"<br>"+
                                           "<span style='line-height: 23px'>Before  </span>"+history.leBalanceBefore+" Tk."+"<br>"+
                                           "<span style='line-height: 23px'>After  </span>"+history.leBalanceAfter+" Tk.")
  // $(".div-lepost"+i+"-container-3-2").append("Amount Nature : "+history.leNature)
  // $(".div-lepost"+i+"-container-3-3").append("Bank Charge : " + history.leBnkCharge)
  // $(".div-lepost"+i+"-container-3-4").append("Total Lend Tk. Before : "+history.leBalanceBefore+" Tk.   After : "+history.leBalanceAfter+" Tk.")

}
