package operation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DatabaseConnection;

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
			String list[] = {"No Source"};
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









