package com.java.infintie.bank;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class BankDAO {
	Connection connection;
	PreparedStatement pst;
	
	public int generateAccountNo() throws ClassNotFoundException, SQLException {
		connection=ConnectionHelper.getConnection();
		String cmd="select case when max(accountNo)IS NULL THEN 1 ELSE max(accountNo)+1 END accno from Bank";
		pst=connection.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		rs.next();
		int accountNo=rs.getInt("accno");
		return accountNo;
	}
	
		public List<Trans> miniAccount(int accountNo) throws ClassNotFoundException, SQLException {
			connection=ConnectionHelper.getConnection();
			String cmd="(select*from trans where AccountNo=? order by TransDate desc Limit 5)Order by TransDate ASC";
					
			pst=connection.prepareStatement(cmd);
			pst.setInt(1, accountNo);
			ResultSet rs=pst.executeQuery();
			Trans trans=null;
			
			List<Trans> transList = new ArrayList<Trans>();
			
			while(rs.next()) {
				trans=new Trans();
				trans.setAccountNo(rs.getInt("accountNo"));
				trans.setTransAmount(rs.getInt("transAmount"));
				trans.setTransDate(rs.getDate("transDate"));
				trans.setTransType(rs.getString("transType"));
				transList.add(trans);
			}
			return transList;
		}
	
		public Bank searchAccount(int accountNo) throws ClassNotFoundException, SQLException {
			connection =ConnectionHelper.getConnection();
			String cmd="select* from Bank where AccountNo=?";
			pst=connection.prepareStatement(cmd);
			pst.setInt(1, accountNo);
			ResultSet rs=pst.executeQuery();
			Bank bank=null;
			if(rs.next()) {
				bank=new Bank();
				bank.setAccountNo(rs.getInt("accountNo"));
				bank.setFirstName(rs.getString("FirstName"));
				bank.setLastName(rs.getString("LastName"));
				bank.setCity(rs.getString("city"));
				bank.setState(rs.getString("state"));
				bank.setAmount(rs.getInt("amount"));
				bank.setCheqFacil(rs.getString("accountType"));
			}
			return bank;
				
			}
		public String depositeAccount(int accountNo,int depositeAmount) throws ClassNotFoundException, SQLException {
			Bank bank=searchAccount(accountNo);
			if(bank!=null) {
				connection = ConnectionHelper.getConnection();
				String cmd="Update bank Set Amount=Amount+? where AccountNo=?";
				pst=connection.prepareStatement(cmd);
				pst.setInt(1, depositeAmount);
				pst.setInt(2, accountNo);
				pst.executeUpdate();
				cmd="Insert into Trans(AccountNo,TransAmount,TransType) values(?,?,?)";
				pst=connection.prepareStatement(cmd);
				pst.setInt(1, accountNo);
				pst.setInt(2, depositeAmount);
				pst.setString(3, "c");
				pst.execute();
				return "Amount Creadited..";
			}
			return "Account Not Found";
		}
		
		public String updateAccount(Bank bank) throws ClassNotFoundException, SQLException {

			 

			Bank old = searchAccount(bank.getAccountNo());
			if (old != null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "Update Bank set FirstName=?,LastName=?,city=?,state=?,Amount=?,CheqFacil=?,AccountType=? where AccountNO=?";
			PreparedStatement pst = connection.prepareStatement(cmd);
			pst.setString(1, bank.getFirstName());
			pst.setString(2, bank.getLastName());
			pst.setString(3, bank.getCity());
			pst.setString(4, bank.getState());
			pst.setInt(5, bank.getAmount());
			pst.setString(6, bank.getCheqFacil());
			pst.setString(7, bank.getAccountType());
			pst.setInt(8, bank.getAccountNo());
			int result = pst.executeUpdate();
			if (result == 1) {
			return "record updated";
			} else {
			return "failed to update";
			}

			 

			} else {

			 

			return "record not found";
			}

			 

			}
		

			public String closeAccount(int accountNo) throws ClassNotFoundException, SQLException {
				Bank bank=searchAccount(accountNo);
				if(bank!=null) {
					connection = ConnectionHelper.getConnection();
					String cmd="update bank set status='inactive' where accountNo=?";
					pst=connection.prepareStatement(cmd);
					pst.setInt(1, accountNo);
					pst.executeUpdate();
					return "Account Closed";
					
				}return "Account Not Found";
			}
			
			public String withdrawAccount(int accountNo,int withdrawAmount) throws ClassNotFoundException, SQLException {
				Bank bank=searchAccount(accountNo);
				
				if(bank!=null) {
					connection = ConnectionHelper.getConnection();
					int balance=bank.getAmount();
					
					if(balance-withdrawAmount>1000) {
						
					
					String cmd="Update bank Set Amount=Amount-? where AccountNo=?";
					pst=connection.prepareStatement(cmd);
					pst.setInt(1, withdrawAmount);
					pst.setInt(2, accountNo);
					pst.executeUpdate();
					cmd="Insert into Trans(AccountNo,TransAmount,TransType) values(?,?,?)";
					pst=connection.prepareStatement(cmd);
					pst.setInt(1, accountNo);
					pst.setInt(2, withdrawAmount);
					pst.setString(3, "w");
					pst.execute();
					return "Amount withdrawn";
					
				}
				else{
					return "No Minium Balance";
				}
			}else {
				return "Account Not Found";
				
			}
		}
			
	
	public String createAccount(Bank bank) throws ClassNotFoundException, SQLException {
		connection=ConnectionHelper.getConnection();
		int accno=generateAccountNo();
		bank.setAccountNo(accno);
		
		String cmd="Insert into Bank(AccountNo,FirstName,LastName,City,State,Amount,CheqFacil,AccountType)values(?,?,?,?,?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, bank.getAccountNo());
		pst.setString(2,bank.getFirstName());
		pst.setString(3,bank.getLastName());
		pst.setString(4, bank.getCity());
		pst.setString(5, bank.getState());
		pst.setInt(6, bank.getAmount());
		pst.setString(7, bank.getCheqFacil());
		pst.setString(8, bank.getAccountType());
		pst.executeUpdate();
		return "Account Added Successfully...";
	}

}
