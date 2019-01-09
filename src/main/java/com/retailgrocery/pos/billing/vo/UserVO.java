package com.retailgrocery.pos.billing.vo;

import com.retailgrocery.pos.billing.util.UserTypeGroupMapping;

/**
 * 
 * @author PS
 *
 */
public class UserVO {

	private String userName;
	
	private Double billAmount;
	
	private Double payableAmount;
	
	private String billTransctionNumber;
	
	private UserTypeGroupMapping userType;
	
	/**
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 
	 * @return
	 */
	public Double getBillAmount() {
		return billAmount;
	}
	
	/**
	 * 
	 * @param billAmount
	 */
	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}
	
	/**
	 * 
	 * @return
	 */
	public Double getPayableAmount() {
		return payableAmount;
	}
	
	/**
	 * 
	 * @param payableAmount
	 */
	public void setPayableAmount(Double payableAmount) {
		this.payableAmount = payableAmount;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getBillTransctionNumber() {
		return billTransctionNumber;
	}
	
	/**
	 * 
	 * @param billTransctionNumber
	 */
	public void setBillTransctionNumber(String billTransctionNumber) {
		this.billTransctionNumber = billTransctionNumber;
	}

	public UserTypeGroupMapping getUserType() {
		return userType;
	}

	public void setUserType(UserTypeGroupMapping userType) {
		this.userType = userType;
	}
	
}
