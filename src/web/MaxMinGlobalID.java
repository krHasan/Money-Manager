package web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DatabaseConnection;

public class MaxMinGlobalID extends DatabaseConnection {
	
	public int[] getGlobalIDNumbers(String monthName) {
		
		int gIDarr[] = new int[getGlobalIDNumbersSize(monthName)];
		int index = 0;
		
		String gmFirstGlobalIDsql = "SELECT globalID FROM Get_Money WHERE gmMonth = ? AND globalID IS NOT NULL";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(gmFirstGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				gIDarr[index] = result.getInt("globalID");
				index++;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String exFirstGlobalIDsql = "SELECT globalID FROM Expense WHERE exMonth = ? AND globalID IS NOT NULL";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(exFirstGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				gIDarr[index] = result.getInt("globalID");
				index++;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String boFirstGlobalIDsql = "SELECT globalID FROM Borrow WHERE boMonth = ? AND globalID IS NOT NULL";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(boFirstGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				gIDarr[index] = result.getInt("globalID");
				index++;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String leFirstGlobalIDsql = "SELECT globalID FROM Lend WHERE leMonth = ? AND globalID IS NOT NULL";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(leFirstGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				gIDarr[index] = result.getInt("globalID");
				index++;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String bkFirstGlobalIDsql = "SELECT globalID FROM bKash WHERE bkMonth = ? AND globalID IS NOT NULL";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(bkFirstGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				gIDarr[index] = result.getInt("globalID");
				index++;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String rocFirstGlobalIDsql = "SELECT globalID FROM Rocket WHERE rocMonth = ? AND globalID IS NOT NULL";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(rocFirstGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				gIDarr[index] = result.getInt("globalID");
				index++;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String perFirstGlobalIDsql = "SELECT globalID FROM Personal WHERE perMonth = ? AND globalID IS NOT NULL";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(perFirstGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				gIDarr[index] = result.getInt("globalID");
				index++;
			}
		} catch (Exception e) {e.printStackTrace();}
		

		for (int i = 0; i < gIDarr.length - 1; i++){
            int index2 = i;
            for (int j = i + 1; j < gIDarr.length; j++) {
                if (gIDarr[j] > gIDarr[index2]) { 
                    index2 = j;
                }
            }
            int smallerNumber = gIDarr[index2];  
            gIDarr[index2] = gIDarr[i];
            gIDarr[i] = smallerNumber;
        }

		
		return gIDarr;
	}
	
	
	private int getGlobalIDNumbersSize(String monthName) {

		int indexSize = 0;
		
		String gmLastGlobalIDsql = "SELECT globalID FROM Get_Money WHERE gmMonth = ? AND globalID IS NOT NULL";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(gmLastGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				indexSize++;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String exLastGlobalIDsql = "SELECT globalID FROM Expense WHERE exMonth = ? AND globalID IS NOT NULL";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(exLastGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				indexSize++;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String boLastGlobalIDsql = "SELECT globalID FROM Borrow WHERE boMonth = ? AND globalID IS NOT NULL";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(boLastGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				indexSize++;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String leLastGlobalIDsql = "SELECT globalID FROM Lend WHERE leMonth = ? AND globalID IS NOT NULL";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(leLastGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				indexSize++;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String bkLastGlobalIDsql = "SELECT globalID FROM bKash WHERE bkMonth = ? AND globalID IS NOT NULL";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(bkLastGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				indexSize++;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String rocLastGlobalIDsql = "SELECT globalID FROM Rocket WHERE rocMonth = ? AND globalID IS NOT NULL";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(rocLastGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				indexSize++;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String perLastGlobalIDsql = "SELECT globalID FROM Personal WHERE perMonth = ? AND globalID IS NOT NULL";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(perLastGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				indexSize++;
			}
		} catch (Exception e) {e.printStackTrace();}

		
		return indexSize;
	}
		
}






















