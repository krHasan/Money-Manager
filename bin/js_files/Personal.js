function printPersonal(i, history){
  // post container frame
  $(".div-main").append('<div class="div-perpost'+i+'-container"></div>')
  $(".div-perpost"+i+"-container").css({
    "height": "125px",
    "width": "100%",
    "display": "flex",
    "flex-direction": "row",
    "padding": "5px 0px",
    "border-bottom": "1px solid purple",
    "background-color": (i%2 == 0) ? "#ebebeb" : "#f5f5f5" //shade of white
  });

  // frame inside div: container-1
  $(".div-perpost"+i+"-container").html('<div class="div-perpost'+i+'-container-1"></div>')
  $(".div-perpost"+i+"-container-1").css({
     "height": "100%",
     "width": "35%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#bae1ee"
  });

  // frame inside div: container-2
  $(".div-perpost"+i+"-container").append('<div class="div-perpost'+i+'-container-2"></div>')
  $(".div-perpost"+i+"-container-2").css({
     "height": "100%",
     "width": "40%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#bae132"
  });

  // frame inside div: container-3
  $(".div-perpost"+i+"-container").append('<div class="div-perpost'+i+'-container-3"></div>')
  $(".div-perpost"+i+"-container-3").css({
     "height": "100%",
     "width": "25%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#b001ee"
  });

  $(".div-perpost"+i+"-container-1").append("<span style='font-weight: bold; color: #2c3e50; font-size: 20px; line-height: 40px'>"+history.filter+"</span>"+"<br>"+
                                           "<span style='font-weight: bold; font-size: 18px; line-height: 30px'>"+history.perAmount+" TK</span>"+"<br>"+
                                           "<span style='color: #8f8f8f; line-height: 30px'>"+history.perDate+"   "+history.perTime+"</span>")
  // $(".div-perpost"+i+"-container-1-2").append("Amount : " + "<b>"+history.perAmount+"</b>")
  $(".div-perpost"+i+"-container-2").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 100px'>Amount Nature  </span>" + history.perNature)

  $(".div-perpost"+i+"-container-3").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 30px'>Personal Acc. Balance</span>"+"<br>"+
                                            "<span style='line-height: 23px'>Before  </span>"+history.perBalanceBefore+" Tk."+"<br>"+
                                            "<span style='line-height: 23px'>After  </span>"+history.perBalanceAfter+" Tk.")
  // $(".div-perpost"+i+"-container-2-3").append("Account Balance - Before : "+history.perBalanceBefore+" Tk.   After : "+history.perBalanceAfter+" Tk.")

}
