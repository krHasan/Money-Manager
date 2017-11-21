function searchHistoryByDate(){
  // refresh();
  // document.body.style.backgroundColor="#00f3f3";
  // var text = HistorySearch.print();
  // $('#aText').text(text);
  // var isInitialized = HistorySearch.initialize;
  var historyDataObject = HistorySearchByDate.getHistoryByDate();
  var historyData = JSON.parse(historyDataObject);

  // var typedFilterName = historyData[0].typedFilterName;

  $("#wrapper").html("<div class=\"div-main\"></div>")
  // $("#aText").html(historyData.length)

  // if (!isInitialized) {
    for (var i = 0; i < historyData.length; i++) {
      var history = historyData[i];
      var filter = history.filter;

          switch (filter) {
            case "Get Money":
                printGetMoney(i, history);
                // $('#aText').text(typedFilterName);
              break;

            case "Expense":
                printExpense(i, history);
              break;

            case "Borrow":
                printBorrow(i, history);
              break;

            case "Lend":
                printLend(i, history);
              break;

            case "bKash":
                printbKash(i, history);
              break;

            case "Rocket":
                printRocket(i, history);
              break;

            case "Personal":
                printPersonal(i, history);
              break;

            default:
  
          }

    }

    if (historyData.length == 0) {
      noResultFound();
    }
  // } else {
  //   initializeWindow();
  //   $('#aText').text(isInitialized);
  // }
}

// function refresh() {
//    location.reload();
// }

// function initializeWindow() {
//   $(".div-main").append(" ")
// }
