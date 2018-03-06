package tableAndgraph;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import operation.CarriedOver;
import operation.ComboboxList;
import tab.Source;
import system.DateAndClock;

public class GetMoneyChart extends DateAndClock {
	
	public static Series<String, Number> getSourceData(String monthName) {
		
		XYChart.Series<String, Number> source = new XYChart.Series<>();
		String allSource[] = new ComboboxList().getSourceListForDashboard();
		
		for (String sourceName : allSource) {
			if (!sourceName.equals("All")) {
				if (sourceName.equals("Carried Over Amount")) {
					String sourceShortName = getAbbreviateName(sourceName);
					double amount = longToDouble(new CarriedOver().getCOAmount(monthName));
					source.getData().add(new XYChart.Data<>(sourceShortName, amount));
				} else {
					String sourceShortName = getAbbreviateName(sourceName);
					double amount = longToDouble(new Source().getAmountBySourceFromGM(monthName, sourceName));
					source.getData().add(new XYChart.Data<>(sourceShortName, amount));
				}
			}
		}		
		
		return source;
	}
}
