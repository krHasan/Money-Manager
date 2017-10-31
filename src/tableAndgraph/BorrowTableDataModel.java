package tableAndgraph;

import javafx.beans.property.SimpleStringProperty;

public class BorrowTableDataModel {
	
	private SimpleStringProperty boDate;
    private SimpleStringProperty boWhom;
    private SimpleStringProperty boExactTk;
    
    public BorrowTableDataModel(String Date, String Whom, String ExactTk) {
    	this.boDate = new SimpleStringProperty(Date);
        this.boWhom = new SimpleStringProperty(Whom);
        this.boExactTk = new SimpleStringProperty(ExactTk);
    }

    
	public final String getBoDate() {
		return boDate.get();
	}
	

	public final void setBoDate(String Date) {
		boDate.set(Date);
	}
	

	public final String getBoWhom() {
		return boWhom.get();
	}
	

	public final void setBoWhom(String Whom) {
		boWhom.set(Whom);
	}


	public final String getBoExactTk() {
		return boExactTk.get();
	}
	

	public final void setBoExactTk(String ExactTk) {
		boExactTk.set(ExactTk);
	}
	
}
