package operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import database.DatabaseConnection;

public class ComboboxList extends DatabaseConnection {

	//////////////////////////////////////////// Source Settings
	//////////////////////////////////////////// ////////////////////////////////////////////
	// ---------------------------------------------------------------------------------------------------------//
	public String[] getSourceList() {
		if (getSourceArraySize() > 0) {
			String list[] = new String[getSourceArraySize()];
			String sql = "SELECT sourceList \n" + "FROM Source_List";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
				int index = 0;
				while (result.next()) {
					list[index] = result.getString("sourceList");
					++index;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;

		} else {
			String list[] = { "No Source" };
			return list;
		}
	}

	public int getSourceArraySize() {
		int size = 0;
		String sqlid = "SELECT * \n" + "FROM Source_List";

		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sqlid)) {
			while (result.next()) {
				size = size + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	public String[] getSourceListForDashboard() {
		if (getSourceArraySizeForDashboard() > 0) {
			String list[] = new String[getSourceArraySizeForDashboard()];
			String sql = "SELECT sourceList \n" + "FROM Source_List";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
				list[0] = "All";
				int index = 1;
				if (BankIssue.isbKashActivated() && BankIssue.isRocketActivated()) {
					while (result.next()) {
						list[index] = result.getString("sourceList");
						++index;
					}
					list[getSourceArraySize() + 1] = "bKash";
					list[getSourceArraySize() + 2] = "Rocket";
					list[getSourceArraySize() + 3] = "Carried Over Amount";
				} else if (BankIssue.isbKashActivated()) {
					while (result.next()) {
						list[index] = result.getString("sourceList");
						++index;
					}
					list[getSourceArraySize() + 1] = "bKash";
					list[getSourceArraySize() + 2] = "Carried Over Amount";
				} else if (BankIssue.isRocketActivated()) {
					while (result.next()) {
						list[index] = result.getString("sourceList");
						++index;
					}
					list[getSourceArraySize() + 1] = "Rocket";
					list[getSourceArraySize() + 2] = "Carried Over Amount";
				} else {
					while (result.next()) {
						list[index] = result.getString("sourceList");
						++index;
					}
					list[getSourceArraySize() + 1] = "Carried Over Amount";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;

		} else {
			String list[] = { "No Source" };
			return list;
		}
	}

	public int getSourceArraySizeForDashboard() {
		int size = 0;
		if (BankIssue.isbKashActivated() && BankIssue.isRocketActivated()) {
			size = getSourceArraySize() + 4;
		} else if (BankIssue.isbKashActivated()) {
			size = getSourceArraySize() + 3;
		} else if (BankIssue.isRocketActivated()) {
			size = getSourceArraySize() + 3;
		} else {
			size = getSourceArraySize() + 2;
		}
		return size;
	}

	public String[] getArchivedSourceList() {
		if (getArchivedSourceArraySize() > 0) {
			String list[] = new String[getArchivedSourceArraySize()];
			String sql = "SELECT sourceArchiveList \n" + "FROM Archived_Source_List";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
				int index = 0;
				while (result.next()) {
					list[index] = result.getString("sourceArchiveList");
					++index;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;

		} else {
			String list[] = { "No Source" };
			return list;
		}
	}

	public int getArchivedSourceArraySize() {
		int size = 0;
		String sqlid = "SELECT * \n" + "FROM Archived_Source_List";

		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sqlid)) {
			while (result.next()) {
				size = size + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	//////////////////////////////////////////// Method Settings
	//////////////////////////////////////////// ////////////////////////////////////////////
	// ---------------------------------------------------------------------------------------------------------//
	public String[] getMethodList() {
		if (getMethodArraySize() > 0) {
			String list[] = new String[getMethodArraySize()];
			String sql = "SELECT activeMethods \n" + "FROM Methods_List";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
				int index = 0;
				while (result.next()) {
					list[index] = result.getString("activeMethods");
					++index;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;

		} else {
			String list[] = { "No Method" };
			return list;
		}
	}

	public int getMethodArraySize() {
		int size = 0;
		String sqlid = "SELECT * \n" + "FROM Methods_List";

		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sqlid)) {
			while (result.next()) {
				size = size + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	//////////////////////////////////////////// Sector Settings
	//////////////////////////////////////////// ////////////////////////////////////////////
	// ------------------------------------------------------------------------------------------------------//
	public String[] getSectorList() {
		if (getSectorArraySize() > 0) {
			String list[] = new String[getSectorArraySize()];
			String sql = "SELECT sectorList \n" + "FROM Sector_List WHERE sectorActive = \"active\"";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
				int index = 0;
				while (result.next()) {
					list[index] = result.getString("sectorList");
					++index;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;

		} else {
			String list[] = { "No Sector" };
			return list;
		}
	}

	public String[] getSectorListForDashboard() {
		if (getSectorArraySize() > 0) {
			String list[] = new String[getSectorArraySize() + 2];
			String sql = "SELECT sectorList \n" + "FROM Sector_List WHERE sectorActive = \"active\"";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
				list[0] = "All";
				int index = 1;
				while (result.next()) {
					list[index] = result.getString("sectorList");
					++index;
				}
				list[getSectorArraySize() + 1] = "Adjusted Balance";
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;

		} else {
			String list[] = { "No Sector" };
			return list;
		}
	}

	public int getSectorArraySize() {
		int size = 0;
		String sqlid = "SELECT * \n" + "FROM Sector_List WHERE sectorActive = \"active\"";

		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sqlid)) {
			while (result.next()) {
				size = size + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	public String[] getArchivedSectorList() {
		if (getArchivedSectorArraySize() > 0) {
			String list[] = new String[getArchivedSectorArraySize()];
			String sql = "SELECT sectorList \n" + "FROM Sector_List WHERE sectorArchived = \"archived\"";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
				int index = 0;
				while (result.next()) {
					list[index] = result.getString("sectorList");
					++index;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;

		} else {
			String list[] = { "No Sector" };
			return list;
		}
	}

	public int getArchivedSectorArraySize() {
		int size = 0;
		String sqlid = "SELECT * \n" + "FROM Sector_List WHERE sectorArchived = \"archived\"";

		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sqlid)) {
			while (result.next()) {
				size = size + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	public String[] getAdvancedSectorListInactive() {
		if (getAdvancedSectorInactiveArraySize() > 0) {
			String list[] = new String[getAdvancedSectorInactiveArraySize()];
			String sql = "SELECT sectorList \n" + "FROM Sector_List WHERE ASL_Queue = \"aslQueue\"";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
				int index = 0;
				while (result.next()) {
					list[index] = result.getString("sectorList");
					++index;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;

		} else {
			String list[] = { "No Sector" };
			return list;
		}
	}

	public int getAdvancedSectorInactiveArraySize() {
		int size = 0;
		String sqlid = "SELECT * \n" + "FROM Sector_List WHERE ASL_Queue = \"aslQueue\"";

		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sqlid)) {
			while (result.next()) {
				size = size + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	public String[] getAdvancedSectorListActive() {
		if (getAdvancedSectorActiveArraySize() > 0) {
			String list[] = new String[getAdvancedSectorActiveArraySize()];
			String sql = "SELECT sectorList \n" + "FROM Sector_List WHERE ASL_Active = \"aslActive\"";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
				int index = 0;
				while (result.next()) {
					list[index] = result.getString("sectorList");
					++index;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;

		} else {
			String list[] = { "No Sector" };
			return list;
		}
	}

	public int getAdvancedSectorActiveArraySize() {
		int size = 0;
		String sqlid = "SELECT * \n" + "FROM Sector_List WHERE ASL_Active = \"aslActive\"";

		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sqlid)) {
			while (result.next()) {
				size = size + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	//////////////////////////////////////////// Borrow Settings
	//////////////////////////////////////////// ////////////////////////////////////////////
	// ---------------------------------------------------------------------------------------------------------//
	public String[] getBoRepayPersonNameList() {
		if (getBoRepayPersonNameSize() > 0) {
			String list[] = new String[getBoRepayPersonNameSize()];
			String sql = "SELECT boWhom \n" + "FROM Borrow_Summary";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
				int index = 0;
				while (result.next()) {
					list[index] = result.getString("boWhom");
					++index;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;

		} else {
			String list[] = { "No One" };
			return list;
		}
	}

	public int getBoRepayPersonNameSize() {
		int size = 0;
		String sqlid = "SELECT * \n" + "FROM Borrow_Summary";

		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sqlid)) {
			while (result.next()) {
				size = size + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	//////////////////////////////////////////// Lend Settings
	//////////////////////////////////////////// ////////////////////////////////////////////
	// ---------------------------------------------------------------------------------------------------------//
	public String[] getLeRepayPersonNameList() {
		if (getLeRepayPersonNameSize() > 0) {
			String list[] = new String[getLeRepayPersonNameSize()];
			String sql = "SELECT leWhom \n" + "FROM Lend_Summary";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
				int index = 0;
				while (result.next()) {
					list[index] = result.getString("leWhom");
					++index;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;

		} else {
			String list[] = { "No One" };
			return list;
		}
	}

	public int getLeRepayPersonNameSize() {
		int size = 0;
		String sqlid = "SELECT * \n" + "FROM Lend_Summary";

		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sqlid)) {
			while (result.next()) {
				size = size + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	//////////////////////////////////////////// Months Settings
	//////////////////////////////////////////// ////////////////////////////////////////////
	// ---------------------------------------------------------------------------------------------------------//
	public String[] getAllMonth() {
		List<Date> dates = new ArrayList<Date>();
		if (getAllMonthSize() > 0) {
			String list[] = new String[getAllMonthSize()];
			String sql = "SELECT allTransactionMonth \n" + "FROM All_Months \n" + "ORDER BY allTransactionMonth DESC";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
				int index = 0;
				while (result.next()) {
					list[index] = result.getString("allTransactionMonth");
					++index;
				}
				for (String dateString : list) {
					Date date;
					date = new SimpleDateFormat("MMM-yy").parse(dateString);
					dates.add(date);
				}
				Collections.sort(dates, new Comparator<Date>() {

					@Override
					public int compare(Date o1, Date o2) {
						return o2.compareTo(o1);
					}
				});
				int index2 = 0;
				for (Date date : dates) {
					list[index2] = new SimpleDateFormat("MMM-yy").format(date);
					++index2;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;

		} else {
			String list[] = { "No Month" };
			return list;
		}
	}

	public int getAllMonthSize() {
		int size = 0;
		String sqlid = "SELECT * \n" + "FROM All_Months";

		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sqlid)) {
			while (result.next()) {
				size = size + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	public void setAllMonth(String monthName, String yearName) {
		String getDBMonth = "SELECT * FROM All_Months WHERE allTransactionMonth = ?";
		String addMonthYear = "INSERT INTO All_Months(allYear, allTransactionMonth) VALUES(?,?)";
		try (Connection conn = connector(); PreparedStatement pstmt = conn.prepareStatement(getDBMonth)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			if (!result.next()) {
				try (Connection conn2 = connector(); PreparedStatement pstmt2 = conn2.prepareStatement(addMonthYear)) {
					pstmt2.setString(1, yearName);
					pstmt2.setString(2, monthName);
					pstmt2.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] getAllGmMonth() {
		List<Date> dates = new ArrayList<Date>();
		if (getAllGmMonthSize() > 0) {
			String list[] = new String[getAllGmMonthSize()];
			String list2[] = new String[getAllGmMonthSize() + 1];

			String sql = "SELECT gmAllMonth \n" + "FROM All_GetMoney_Months \n" + "ORDER BY gmAllMonth DESC";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
				int index = 0;
				while (result.next()) {
					list[index] = result.getString("gmAllMonth");
					++index;
				}

				for (String dateString : list) {
					Date date;
					date = new SimpleDateFormat("MMM-yy").parse(dateString);
					dates.add(date);
				}
				Collections.sort(dates, new Comparator<Date>() {

					@Override
					public int compare(Date o1, Date o2) {
						return o2.compareTo(o1);
					}
				});

				int index2 = 1;
				list2[0] = "Total";
				for (Date date : dates) {
					list2[index2] = new SimpleDateFormat("MMM-yy").format(date);
					++index2;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list2;

		} else {
			String list[] = { "No Month", "No Month" };
			return list;
		}
	}

	public int getAllGmMonthSize() {
		int size = 0;
		String sqlid = "SELECT * \n" + "FROM All_GetMoney_Months";

		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sqlid)) {
			while (result.next()) {
				size = size + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	public void setAllGmMonth(String monthName, String yearName) {
		String getDBMonth = "SELECT * FROM All_GetMoney_Months WHERE gmAllMonth = ?";
		String addMonthYear = "INSERT INTO All_GetMoney_Months(allYear, gmAllMonth) VALUES(?,?)";
		try (Connection conn = connector(); PreparedStatement pstmt = conn.prepareStatement(getDBMonth)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			if (!result.next()) {
				try (Connection conn2 = connector(); PreparedStatement pstmt2 = conn2.prepareStatement(addMonthYear)) {
					pstmt2.setString(1, yearName);
					pstmt2.setString(2, monthName);
					pstmt2.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] getAllExMonth() {
		List<Date> dates = new ArrayList<Date>();
		if (getAllExMonthSize() > 0) {
			String list[] = new String[getAllExMonthSize()];
			String list2[] = new String[getAllExMonthSize() + 1];

			String sql = "SELECT exAllMonth \n" + "FROM All_Expense_Months \n" + "ORDER BY exAllMonth DESC";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
				int index = 0;
				while (result.next()) {
					list[index] = result.getString("exAllMonth");
					++index;
				}

				for (String dateString : list) {
					Date date;
					date = new SimpleDateFormat("MMM-yy").parse(dateString);
					dates.add(date);
				}
				Collections.sort(dates, new Comparator<Date>() {

					@Override
					public int compare(Date o1, Date o2) {
						return o2.compareTo(o1);
					}
				});

				int index2 = 1;
				list2[0] = "Total";
				for (Date date : dates) {
					list2[index2] = new SimpleDateFormat("MMM-yy").format(date);
					++index2;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list2;

		} else {
			String list[] = { "No Month" };
			return list;
		}
	}

	public int getAllExMonthSize() {
		int size = 0;
		String sqlid = "SELECT * \n" + "FROM All_Expense_Months";

		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sqlid)) {
			while (result.next()) {
				size = size + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	public void setAllExMonth(String monthName, String yearName) {
		String getDBMonth = "SELECT * FROM All_Expense_Months WHERE exAllMonth = ?";
		String addMonthYear = "INSERT INTO All_Expense_Months(allYear, exAllMonth) VALUES(?,?)";
		try (Connection conn = connector(); PreparedStatement pstmt = conn.prepareStatement(getDBMonth)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			if (!result.next()) {
				try (Connection conn2 = connector(); PreparedStatement pstmt2 = conn2.prepareStatement(addMonthYear)) {
					pstmt2.setString(1, yearName);
					pstmt2.setString(2, monthName);
					pstmt2.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//////////////////////////////////////////// History Settings
	//////////////////////////////////////////// ////////////////////////////////////////////
	// ---------------------------------------------------------------------------------------------------------//
	public String[] getFilterList() {
		String sourceList[] = getSourceList();
		String sectorList[] = getSectorList();
		String allList[] = new String[permanantFilterSize() + getSourceArraySize() + getSectorArraySize()];
		allList[0] = "All";
		allList[1] = "Get Money";
		allList[2] = "Expense";
		allList[3] = "Borrow";
		allList[4] = "Lend";
		int index = 5;
		if (BankIssue.isbKashActivated() && BankIssue.isRocketActivated()) {
			allList[index] = "bKash";
			++index;
			allList[index] = "Rocket";
			++index;
			allList[index] = "Personal";
			++index;
		} else if (BankIssue.isbKashActivated()) {
			allList[index] = "bKash";
			++index;
			allList[index] = "Personal";
			++index;
		} else if (BankIssue.isRocketActivated()) {
			allList[index] = "Rocket";
			++index;
			allList[index] = "Personal";
			++index;
		} else {
			allList[index] = "Personal";
			++index;
		}
		if (getSourceArraySize() != 0) {
			for (String string : sourceList) {
				allList[index] = string;
				++index;
			}
		}
		if (getSectorArraySize() != 0) {
			for (String string : sectorList) {
				allList[index] = string;
				++index;
			}
		}
		return allList;
	}

	private int permanantFilterSize() {
		int size = 5;
		if (BankIssue.isbKashActivated() && BankIssue.isRocketActivated()) {
			size = 8;
		} else if (BankIssue.isbKashActivated()) {
			size = 7;
		} else if (BankIssue.isRocketActivated()) {
			size = 7;
		} else {
			size = 6;
		}
		return size;
	}

	public boolean isFilterInSource(String filterName) {
		String sourceList[] = getSourceList();
		boolean status = false;
		for (String string : sourceList) {
			if (string.equals(filterName)) {
				status = true;
			}
		}
		return status;
	}

	public boolean isFilterInSector(String filterName) {
		String sectorList[] = getSectorList();
		boolean status = false;
		for (String string : sectorList) {
			if (string.equals(filterName)) {
				status = true;
			}
		}
		return status;
	}

	public String[] getSecurityQuestionList() {
		String list[] = { "What was Your First Phone Number?", "What is Your Favourite Teacher's Name?",
				"What is Your Special One's Name?", "What was your childhood nickname?", "What is your favorite team?",
				"What is your favorite movie?", "In what town was your first job?" };
		return list;
	}

	// public static void main(String[] args) {
	// ComboboxList access = new ComboboxList();
	// System.out.println(access.permanantFilterSize());
	// System.out.println(access.getSourceArraySize());
	// System.out.println(access.getSectorArraySize());
	// String list[] = access.getSourceList();
	// for (String string : list) {
	// System.out.println("Source :"+string);
	// }
	//
	// String list2[] = access.getMethodList();
	// for (String string : list2) {
	// System.out.println("Method: "+string);
	// }
	// }

}
