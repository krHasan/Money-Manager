package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import operation.BankIssue;
import operation.CarriedOver;
import operation.ComboboxList;
import system.DateAndClock;
import system.UnitConverter;
import tab.Sector;
import tab.Source;

public class DashboardModel extends DateAndClock {

	public String getWalletBalance() {
		return UnitConverter.longToString(currentWalletBalance());
	}

	public String getTotalBorrowTk() {
		return UnitConverter.longToString(totalBorrowTk());
	}

	public String getTotalLendTk() {
		return UnitConverter.longToString(totalLendTk());
	}

	public String getbkAccountBalance() {
		return UnitConverter.longToString(currentbKashBalance());
	}

	public String getRocAccountBalance() {
		return UnitConverter.longToString(currentRocketBalance());
	}

	public String getPerAccountBalance() {
		return UnitConverter.longToString(currentPersonalBalance());
	}

	public ObservableList<String> loadAllGetMoneyMonths() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getAllGmMonth());
		return list;
	}

	public ObservableList<String> loadAllExpenseMonths() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getAllExMonth());
		return list;
	}

	public ObservableList<String> loadSector() {
		ObservableList<String> list = FXCollections
				.observableArrayList((new ComboboxList()).getSectorListForDashboard());
		return list;
	}

	public ObservableList<String> loadSource() {
		ObservableList<String> list = FXCollections
				.observableArrayList((new ComboboxList()).getSourceListForDashboard());
		return list;
	}

	public String getAmountBySource(String monthName, String sourceName) {
		long totalAmountinLong = 0;

		if (monthName.equals("Total")) {
			if (sourceName.equals("All")) {
				String allGetMoneySql = "SELECT gmAmount FROM Get_Money";
				try (Connection conn = connector();
						Statement stmt = conn.createStatement();
						ResultSet result = stmt.executeQuery(allGetMoneySql)) {
					while (result.next()) {
						totalAmountinLong += UnitConverter
								.stringToLong(removeThousandSeparator(result.getString("gmAmount")));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (sourceName.equals("Carried Over Amount")) {
				totalAmountinLong = 0;
			} else {
				String sql = "SELECT gmAmount FROM Get_Money WHERE gmSource = ?";
				try (Connection conn = connector(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setString(1, sourceName);
					ResultSet result = pstmt.executeQuery();

					while (result.next()) {
						totalAmountinLong += UnitConverter
								.stringToLong(removeThousandSeparator(result.getString("gmAmount")));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			if (sourceName.equals("All")) {
				String sourceList[] = new ComboboxList().getSourceListForDashboard();
				for (String string : sourceList) {
					totalAmountinLong += new Source().getAmountBySourceFromGM(monthName, string);
				}
				totalAmountinLong += new CarriedOver().getCOAmount(monthName);
			} else if (sourceName.equals("Carried Over Amount")) {
				totalAmountinLong = new CarriedOver().getCOAmount(monthName);
			} else {
				totalAmountinLong = new Source().getAmountBySourceFromGM(monthName, sourceName);
			}
		}

		return addThousandSeparator(longToString(totalAmountinLong));
	}

	public String getAmountBySector(String monthName, String sectorName) {
		long totalAmountinLong = 0;

		if (monthName.equals("Total")) {
			if (sectorName.equals("All")) {

				String allExpenseSql = "SELECT exAmount FROM Expense WHERE exSector <> \"Adjusted Balance\"";
				try (Connection conn = connector();
						Statement stmt = conn.createStatement();
						ResultSet result = stmt.executeQuery(allExpenseSql)) {
					while (result.next()) {
						totalAmountinLong += UnitConverter
								.stringToLong(removeThousandSeparator(result.getString("exAmount")));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				long totalAdjustBal = 0;
				String allAdjustBalSql = "SELECT exAmount FROM Expense WHERE exSector = \"Adjusted Balance\"";
				try (Connection conn = connector();
						Statement stmt = conn.createStatement();
						ResultSet result = stmt.executeQuery(allAdjustBalSql)) {
					while (result.next()) {
						totalAdjustBal += UnitConverter.stringToLong(
								removeThousandSeparator(result.getString("exAmount").replaceAll("[^0-9.*]", "")));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				totalAmountinLong = totalAmountinLong - totalAdjustBal;

			} else if (sectorName.equals("Adjusted Balance")) {
				String sql = "SELECT exAmount FROM Expense WHERE exSector = \"Adjusted Balance\"";
				try (Connection conn = connector();
						Statement stmt = conn.createStatement();
						ResultSet result = stmt.executeQuery(sql)) {
					long totalAddedBal = 0;
					while (result.next()) {
						if (result.getString("exAmount").matches(".*\\badded\\b.*")) {
							totalAddedBal += stringToLong(
									removeThousandSeparator(result.getString("exAmount").replaceAll("[^0-9.*]", "")));
						} else {
							totalAmountinLong += stringToLong(removeThousandSeparator(result.getString("exAmount")));
						}
					}
					totalAmountinLong = totalAmountinLong - totalAddedBal;
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				String bysectorSql = "SELECT exAmount FROM Expense WHERE exSector = ? ";
				try (Connection conn = connector(); PreparedStatement pstmt = conn.prepareStatement(bysectorSql)) {
					pstmt.setString(1, sectorName);
					ResultSet result = pstmt.executeQuery();

					while (result.next()) {
						totalAmountinLong += UnitConverter
								.stringToLong(removeThousandSeparator(result.getString("exAmount")));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			if (sectorName.equals("All")) {
				totalAmountinLong += new Sector().getAmountBySectorFromExpense(monthName, "Adjusted Balance");
				String sectorList[] = new ComboboxList().getSectorList();
				for (String string : sectorList) {
					totalAmountinLong += new Sector().getAmountBySectorFromExpense(monthName, string);
				}
				totalAmountinLong -= new Sector().addedAdjustBalance(monthName);
			} else {
				totalAmountinLong = new Sector().getAmountBySectorFromExpense(monthName, sectorName);
			}
		}

		return addThousandSeparator(longToString(totalAmountinLong));
	}

	int carrier = 1;

	public int currentBalanceStatus() {
		int status = 0;
		if (BankIssue.isbKashActivated() && BankIssue.isRocketActivated()) {
			if (carrier == 5) {
				status = carrier;
				carrier = 1;
			} else {
				status = carrier;
				this.carrier = carrier + 1;
			}
		} else if (BankIssue.isbKashActivated()) {
			if (carrier == 4) {
				status = carrier;
				carrier = 1;
			} else {
				status = carrier;
				this.carrier = carrier + 1;
			}
		} else if (BankIssue.isRocketActivated()) {
			if (carrier == 5) {
				status = carrier;
				carrier = 1;
			} else {
				if (carrier == 4) {
					status = 5;
					carrier = 5;
				} else {
					status = carrier;
					this.carrier = carrier + 1;
				}
			}
		} else {
			if (carrier == 3) {
				status = carrier;
				carrier = 1;
			} else {
				status = carrier;
				this.carrier = carrier + 1;
			}
		}

		return status;
	}

	// public static void main(String[] args) {
	// DashboardModel access = new DashboardModel();
	// System.out.println(access.currentBalanceStatus());
	// System.out.println(access.currentBalanceStatus());
	// System.out.println(access.currentBalanceStatus());
	// System.out.println(access.currentBalanceStatus());
	// System.out.println(access.currentBalanceStatus());
	// System.out.println(access.currentBalanceStatus());
	// System.out.println(access.currentBalanceStatus());
	// System.out.println(access.currentBalanceStatus());
	// System.out.println(access.currentBalanceStatus());
	// System.out.println(access.currentBalanceStatus());
	// System.out.println(access.currentBalanceStatus());
	// }
}
