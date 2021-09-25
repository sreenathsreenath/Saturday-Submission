package com.java.infintie.bank;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MiniStatementMain {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter the Account No ");
		int accountNo=sc.nextInt();
		BankDAO dao=new BankDAO();
		
		Bank bank;
		try {
			bank = dao.searchAccount(accountNo);
			List<Trans> printList=null;
			if(bank!=null) {
				
				printList=dao.miniAccount(accountNo);
				printList.forEach( x -> System.out.println(x));
				
			}else {
				System.out.println("*****AccountNo Not Found******");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
