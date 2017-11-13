window.ready = function() {
  // refresh();
  // document.body.style.backgroundColor="#00f3f3";
  // var text = HistorySearch.print();
  // $('#aText').text(text);
  // var isInitialized = HistorySearch.initialize;
  var historyDataObject = HistorySearch.getAllHistory();
  var historyData = JSON.parse(historyDataObject);

  var typedFilterName = historyData[0].typedFilterName;

  // if (!isInitialized) {
    for (var i = 1; i < historyData.length; i++) {
      var history = historyData[i];
      var filter = history.filter;

      switch (typedFilterName) {
        case "All":
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
          break;

        case "Get Money":
            printGetMoney(i, history);
          // $('#bText').text("bText "+typedFilterName);
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

        case "Source":
            printSource(i, history);
          break;

        case "Sector":
            printSector(i, history);
          break;

        default:
      }
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
