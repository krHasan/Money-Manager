function printSector(i, history){
  // post container frame
  $(".div-main").append('<div class="div-sectorPost'+i+'-container"></div>')
  $(".div-sectorPost"+i+"-container").css({
    "height": "125px",
    "width": "100%",
    "display": "flex",
    "flex-direction": "column",
    "padding": "5px 0px",
    "border-bottom": "1px solid purple",
    "background-color": (i%2 == 0) ? "#ebebeb" : "#f5f5f5" //shade of white
  });

  // frame inside div: container-2
  $(".div-sectorPost"+i+"-container").html('<div class="div-sectorPost'+i+'-container-2"></div>')
  $(".div-sectorPost"+i+"-container-2").css({
     "height": "85px",
     "width": "100%",
     "display": "flex",
     "flex-direction": "row"
    //  "background-color": "#bae1ee"
  });

  // frame inside div: container-2, subcontainer-1
  $(".div-sectorPost"+i+"-container-2").append('<div class="div-sectorPost'+i+'-subcon-1"></div>')
  $(".div-sectorPost"+i+"-subcon-1").css({
     "height": "100%",
     "width": "35%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#fae1ee"
  });

  // frame inside div: container-2, subcontainer-2
  $(".div-sectorPost"+i+"-container-2").append('<div class="div-sectorPost'+i+'-subcon-2"></div>')
  $(".div-sectorPost"+i+"-subcon-2").css({
     "height": "100%",
     "width": "40%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#bae132"
  });

  // frame inside div: container-2, subcontainer-3
  $(".div-sectorPost"+i+"-container-2").append('<div class="div-sectorPost'+i+'-subcon-3"></div>')
  $(".div-sectorPost"+i+"-subcon-3").css({
     "height": "100%",
     "width": "25%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "padding-top": "10px"
    //  "background-color": "#b001ee"
  });

  // frame insede div: get money description
  $(".div-sectorPost"+i+"-container").append('<div class="div-gmdis'+i+'"></div>')
  $(".div-gmdis"+i+"").css({
     "height": "40px",
     "width": "98%",
     "font-family": "Arial, Helvetica, sans-serif",
     "font-size": "15px",
     "padding-left": "10px",
     "vertical-align": "middle",
     "line-height": "40px" //the same as div height
    //  "background-color": "#bff1ee"
  });

  $(".div-sectorPost"+i+"-subcon-1").append("<span style='font-weight: bold; color: #d11141; font-size: 20px; line-height: 30px'>"+history.exSector+"</span>"+"<br>"+//304FFE
                                        "<span style='font-weight: bold; font-size: 18px; line-height: 30px'>"+history.exAmount+" TK</span>"+"<br>"+
                                        "<span style='color: #8f8f8f; line-height: 20px'>"+history.exDate+"   "+history.exTime+"</span>")
  // $(".div-sectorPost"+i+"-subcon-1-2").append("Amount : " + "<b>"+history.exAmount+"</b>")
  $(".div-sectorPost"+i+"-subcon-2").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 85px'>Source  </span>" + history.exSector)
  // $(".div-sectorPost"+i+"-subcon-2-2").append("Sector : " + history.exSector)
  $(".div-sectorPost"+i+"-subcon-3").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 30px'>Wallet Balance</span>"+"<br>"+
                                          "<span style='line-height: 23px'>Before  </span>"+history.exWalletBalanceBefore+" Tk."+"<br>"+
                                          "<span style='line-height: 23px'>After  </span>"+history.exWalletBalanceAfter+" Tk.")
  $(".div-gmdis"+i+"").append("<span style='font-weight: bold; color: #8f8f8f; line-height: 40px'>Discription  </span>" + history.exDescription)

}
