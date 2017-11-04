package tableAndgraph;

import javafx.beans.property.SimpleStringProperty;
import system.UnitConverter;

public class LendTableDataModel {
	
	private SimpleStringProperty leDate;
    private SimpleStringProperty leWhom;
    private SimpleStringProperty leExactTk;
    
    public LendTableDataModel(String Date, String Whom, String ExactTk) {
    	this.leDate = new SimpleStringProperty(Date);
        this.leWhom = new SimpleStringProperty(Whom);
        this.leExactTk = new SimpleStringProperty(UnitConverter.addThousandSeparator(ExactTk));
    }

    
	public final String getLeDate() {
		return leDate.get();
	}
	

	public final void setLeDate(String Date) {
		leDate.set(Date);
	}
	

	public final String getLeWhom() {
		return leWhom.get();
	}
	

	public final void setLeWhom(String Whom) {
		leWhom.set(Whom);
	}


	public final String getLeExactTk() {
		return leExactTk.get();
	}
	

	public final void setLeExactTk(String ExactTk) {
		leExactTk.set(ExactTk);
	}
	
}
