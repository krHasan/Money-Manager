package tableAndgraph;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import operation.ComboboxList;
import system.DateAndClock;
import tab.Sector;

public class ExpenseChart extends DateAndClock {
	public static Series<String, Number> getExpenseData(String monthName) {
		
		XYChart.Series<String, Number> sector = new XYChart.Series<>();
		String allSector[] = new ComboboxList().getSectorList();
		
		//chart data for all other Sectors
		for (String sectorName : allSector) {
			String sectorShortName = getAbbreviateName(sectorName);
			double amount = longToDouble(new Sector().getAmountBySectorFromExpense(monthName, sectorName));
			sector.getData().add(new XYChart.Data<>(sectorShortName, amount));
		}			
		
		//chart data for "Adjusted Balance" Sector
		String srtName = getAbbreviateName("Adjusted Balance");
		double amnt = longToDouble(new Sector().getAmountBySectorFromExpense(monthName, "Adjusted Balance"));
		sector.getData().add(new XYChart.Data<>(srtName, amnt));
				
		return sector;
	}
}
