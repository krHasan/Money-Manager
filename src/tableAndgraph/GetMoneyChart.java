package tableAndgraph;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import operation.ComboboxList;
import tab.Source;
import system.DateAndClock;

public class GetMoneyChart extends DateAndClock {
	
	public static Series<String, Number> getSourceData(String monthName) {
		
		XYChart.Series<String, Number> source = new XYChart.Series<>();
		String allSource[] = new ComboboxList().getSourceListForDashboard();
		
		for (String sourceName : allSource) {
			if (!sourceName.equals("All")) {
				String sourceShortName = getAbbreviateName(sourceName);
				double amount = longToDouble(new Source().getAmountBySourceFromGM(monthName, sourceName));
				source.getData().add(new XYChart.Data<>(sourceShortName, amount));
			}
		}		
		
		return source;
	}
}
