package com.java.infintie.bank;

import java.sql.SQLException;
import java.util.Scanner;

public class DepositeAccountMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int accountNo,depositAmount;
		System.out.println("Enter Account No");
		accountNo=sc.nextInt();
		System.out.println("Enter Deposit Amount");
		depositAmount=sc.nextInt();
		BankDAO dao=new BankDAO();
		try {
			System.out.println(dao.depositeAccount(accountNo, depositAmount));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
