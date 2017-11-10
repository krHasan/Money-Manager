package operation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DatabaseConnection;
import tab.Bkash;
import tab.Rocket;

public class ComboboxList extends DatabaseConnection {
	
	
	public String[] getSourceList() {
		if(getSourceArraySize()>0) {
			String list[] = new String[getSourceArraySize()];
			String sql = "SELECT sourceList \n"
					+ "FROM Source_List";
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
			String list[] = {"No Source"};
			return list;
		}
	}
	public int getSourceArraySize() {
		int size = 0;
		String sqlid = "SELECT * \n"
				+ "FROM Source_List";
		
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
	
	
	public String[] getArchivedSourceList() {
		if(getArchivedSourceArraySize()>0) {
			String list[] = new String[getArchivedSourceArraySize()];
			String sql = "SELECT sourceArchiveList \n"
					+ "FROM Archived_Source_List";
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
			String list[] = {"No Source"};
			return list;
		}
	}
	public int getArchivedSourceArraySize() {
		int size = 0;
		String sqlid = "SELECT * \n"
				+ "FROM Archived_Source_List";
		
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
	
	
	public String[] getMethodList() {
		if(getMethodArraySize()>0) {
			String list[] = new String[getMethodArraySize()];
			String sql = "SELECT activeMethods \n"
					+ "FROM Methods_List";
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
			String list[] = {"No Method"};
			return list;
		}
	}
	public int getMethodArraySize() {
		int size = 0;
		String sqlid = "SELECT * \n"
				+ "FROM Methods_List";
		
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
	
	
	public String[] getSectorList() {
		if(getSectorArraySize()>0) {
			String list[] = new String[getSectorArraySize()];
			String sql = "SELECT sectorList \n"
					+ "FROM Sector_List";
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
			String list[] = {"No Sector"};
			return list;
		}
	}
	public int getSectorArraySize() {
		int size = 0;
		String sqlid = "SELECT * \n"
				+ "FROM Sector_List";
		
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
		if(getArchivedSectorArraySize()>0) {
			String list[] = new String[getArchivedSectorArraySize()];
			String sql = "SELECT sectorArchiveList \n"
					+ "FROM Archived_Sector_List";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
					int index = 0;
					while (result.next()) {
						list[index] = result.getString("sectorArchiveList");
						++index;			
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
			
		} else {
			String list[] = {"No Sector"};
			return list;
		}
	}
	public int getArchivedSectorArraySize() {
		int size = 0;
		String sqlid = "SELECT * \n"
				+ "FROM Archived_Sector_List";
		
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
	
	
	public String[] getBoRepayPersonNameList() {
		if(getBoRepayPersonNameSize()>0) {
			String list[] = new String[getBoRepayPersonNameSize()];
			String sql = "SELECT boWhom \n"
					+ "FROM Borrow_Summary";
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
			String list[] = {"No Source"};
			return list;
		}
	}
	public int getBoRepayPersonNameSize() {
		int size = 0;
		String sqlid = "SELECT * \n"
				+ "FROM Borrow_Summary";
		
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
	
	
	public String[] getLeRepayPersonNameList() {
		if(getLeRepayPersonNameSize()>0) {
			String list[] = new String[getLeRepayPersonNameSize()];
			String sql = "SELECT leWhom \n"
					+ "FROM Lend_Summary";
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
			String list[] = {"No Source"};
			return list;
		}
	}
	public int getLeRepayPersonNameSize() {
		int size = 0;
		String sqlid = "SELECT * \n"
				+ "FROM Lend_Summary";
		
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
	
	
	public String[] getAllMonth() {
		if(getAllMonthSize()>0) {
			String list[] = new String[getAllMonthSize()];
			String sql = "SELECT allTransactionMonth \n"
					+ "FROM All_Months";
			try (Connection conn = connector();
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery(sql)) {
					int index = 0;
					while (result.next()) {
						list[index] = result.getString("allTransactionMonth");
						++index;			
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
			
		} else {
			String list[] = {"No Month"};
			return list;
		}
	}
	public int getAllMonthSize() {
		int size = 0;
		String sqlid = "SELECT * \n"
				+ "FROM All_Months";
		
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
	
	
//	public String[] getAllYear() {
//		if(getAllYearSize()>0) {
//			String list[] = new String[getAllYearSize()];
//			String sql = "SELECT DISTINCT allYear \n"
//					+ "FROM All_Months";
//			try (Connection conn = connector();
//					Statement stmt = conn.createStatement();
//					ResultSet result = stmt.executeQuery(sql)) {
//					int index = 0;
//					while (result.next()) {
//						list[index] = result.getString("allYear");
//						++index;			
//					}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return list;
//			
//		} else {
//			String list[] = {"No Year"};
//			return list;
//		}
//	}
//	public int getAllYearSize() {
//		int size = 0;
//		String sqlid = "SELECT DISTINCT allYear \n"
//				+ "FROM All_Months";
//		
//		try (Connection conn = connector();
//				Statement stmt = conn.createStatement();
//				ResultSet result = stmt.executeQuery(sqlid)) {
//				while (result.next()) {
//					size = size + 1;
//				}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return size;
//	}
	
	
	public String[] getFilterList() {
		String sourceList[] = getSourceList();
		String sectorList[] = getSectorList();
		String allList[] = new String[7+getSourceArraySize()+getSectorArraySize()];
		allList[0] = "Get Money";
		allList[1] = "Expense";
		allList[2] = "Borrow";
		allList[3] = "Lend";
		int index = 4;
		if (new Bkash().isbKashActivated() && new Rocket().isRocketActivated()) {
			allList[index] = "bKash";
			++index;
			allList[index] = "Rocket";
			++index;
			allList[index] = "Personal";
			++index;
		} else if(new Bkash().isbKashActivated()) {
			allList[index] = "bKash";
			++index;
			allList[index] = "Personal";
			++index;
		} else if(new Rocket().isRocketActivated()) {
			allList[index] = "Rocket";
			++index;
			allList[index] = "Personal";
			++index;
		}
		for (String string : sourceList) {
			allList[index] = string;
			++index;
		}
		for (String string : sectorList) {
			allList[index] = string;
			++index;
		}
		return allList;
	}
	
	
//	public static void main(String[] args) {
//		ComboboxList access = new ComboboxList();
//		
//		String list[] = access.getSourceList();
//		for (String string : list) {
//			System.out.println("Source :"+string);
//		}
//		
//		String list2[] = access.getMethodList();
//		for (String string : list2) {
//			System.out.println("Method: "+string);
//		}
//	}
}









