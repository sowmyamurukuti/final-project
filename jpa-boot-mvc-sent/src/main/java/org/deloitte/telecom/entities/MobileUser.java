package org.deloitte.telecom.entities;

import javax.persistence.*;

@Entity
@Table(name = "mobileusers")
public class MobileUser {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String password;

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    private String mobileNo;

    public String getMobileNo(){
        return mobileNo;
    }

    public void setMobileNo(String no){
        this.mobileNo=no;
    }
    
    private double balance;
    public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	private double amount;
    public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public MobileUser(){

    }


    public MobileUser( String name,String password, String mobileNo, double balance){
        this.name=name;
        this.password=password;
        this.mobileNo=mobileNo;
        this.balance=balance;
    }

}
