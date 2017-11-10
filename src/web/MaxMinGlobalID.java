package web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DatabaseConnection;

public class MaxMinGlobalID extends DatabaseConnection {
	
	public int getMinIDNumber(String monthName) {
		
		int gmFirstGlobalID = 0, exFirstGlobalID = 0, boFirstGlobalID = 0, leFirstGlobalID = 0, bkFirstGlobalID = 0, rocFirstGlobalID = 0, perFirstGlobalID = 0;
		int minIDnumber = 0;
		
		String gmFirstGlobalIDsql = "SELECT globalID FROM Get_Money WHERE gmMonth = ? AND globalID IS NOT NULL LIMIT 1";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(gmFirstGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			if (result.next()) {
				gmFirstGlobalID = result.getInt("globalID");
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String exFirstGlobalIDsql = "SELECT globalID FROM Expense WHERE exMonth = ? AND globalID IS NOT NULL LIMIT 1";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(exFirstGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			if (result.next()) {
				exFirstGlobalID = result.getInt("globalID");
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String boFirstGlobalIDsql = "SELECT globalID FROM Borrow WHERE boMonth = ? AND globalID IS NOT NULL LIMIT 1";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(boFirstGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			if (result.next()) {
				boFirstGlobalID = result.getInt("globalID");
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String leFirstGlobalIDsql = "SELECT globalID FROM Lend WHERE leMonth = ? AND globalID IS NOT NULL LIMIT 1";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(leFirstGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			if (result.next()) {
				leFirstGlobalID = result.getInt("globalID");
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String bkFirstGlobalIDsql = "SELECT globalID FROM bKash WHERE bkMonth = ? AND globalID IS NOT NULL LIMIT 1";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(bkFirstGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			if (result.next()) {
				bkFirstGlobalID = result.getInt("globalID");
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String rocFirstGlobalIDsql = "SELECT globalID FROM Rocket WHERE rocMonth = ? AND globalID IS NOT NULL LIMIT 1";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(rocFirstGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			if (result.next()) {
				rocFirstGlobalID = result.getInt("globalID");
			}
		} catch (Exception e) {e.printStackTrace();}
		
		String perFirstGlobalIDsql = "SELECT globalID FROM Personal WHERE perMonth = ? AND globalID IS NOT NULL LIMIT 1";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(perFirstGlobalIDsql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			if (result.next()) {
				perFirstGlobalID = result.getInt("globalID");
			}
		} catch (Exception e) {e.printStackTrace();}
		
		int[] arr = {gmFirstGlobalID, exFirstGlobalID, boFirstGlobalID, leFirstGlobalID, bkFirstGlobalID, rocFirstGlobalID, perFirstGlobalID};
		for (int i : arr) {
			System.out.println(i);
		}
//		for (int i = 0; i < arr.length - 1; i++){
//            int index = i;
//            for (int j = i + 1; j < arr.length; j++)
//                if (arr[j] > arr[index]) 
//                    index = j;
//      
//            minIDnumber = arr[index];  
//            arr[index] = arr[i];
//            arr[i] = minIDnumber;
//         
//        }
//		
		return minIDnumber;
	}
	
	
	public int getMaxIDNumber(String monthName) {

		int gmLastGlobalID = 0, exLastGlobalID = 0, boLastGlobalID = 0, leLastGlobalID = 0, bkLastGlobalID = 0, rocLastGlobalID = 0, perLastGlobalID = 0;
		int maxIDnumber = 0;
		
		return 0;
	}
	
	
	public static void main(String[] args) {
		MaxMinGlobalID access = new MaxMinGlobalID();
		System.out.println("\n"+access.getMinIDNumber("Nov-17"));
	}
}






















