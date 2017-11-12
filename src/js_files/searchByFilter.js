window.ready = function() {
  // document.body.style.backgroundColor="#00f3f3";
  // var text = HistorySearch.print();
  // $('#aText').text(text);

  var historyDataObject = HistorySearch.getAllHistory();
  var historyData = JSON.parse(historyDataObject);

  var typedFilterName = historyData[0].typedFilterName;

  for (var i = 1; i < historyData.length; i++) {
    var history = historyData[i];
    var filter = history.filter;

    switch (typedFilterName) {
      case "All":
        switch (filter) {
          case "Get Money":
            printGetMoney(i, history);
          break;

          case "Expense":
            break;

          case "Borrow":
            break;

          case "Lend":
            break;

          case "bKash":
            break;

          case "Rocket":
            break;

          case "Personal":
            break;

          default:
        }
        break;

      case "Get Money":
        printGetMoney(i, history);
        break;

      case "Expense":
        break;

      case "Borrow":
        break;

      case "Lend":
        break;

      case "bKash":
        break;

      case "Rocket":
        break;

      case "Personal":
        break;

      case "Source":
        break;

      case "Sector":
        break;

      default:
    }
  }
}
