package com.retailgrocery.pos.billing.main;

import org.apache.log4j.Logger;

import com.retailgrocery.pos.billing.serviceimpl.DiscountRuleEngineServiceImpl;
import com.retailgrocery.pos.billing.util.UserTypeGroupMapping;
import com.retailgrocery.pos.billing.vo.UserVO;

public class MainClass {
	final static Logger logger = Logger.getLogger(MainClass.class);
	
	/**
	 * 
	 */
	private MainClass(){
		
	}
	
	public static void main(String[] args) {
		
		UserVO userVO = new UserVO();
		DiscountRuleEngineServiceImpl discountRuleEngineServiceImpl = new DiscountRuleEngineServiceImpl();
		userVO.setUserName("Pushpendra Singh");
		userVO.setBillTransctionNumber("10001");
		userVO.setBillAmount(50.0);
		userVO.setUserType(UserTypeGroupMapping.EMPLOYEE);
		
		discountRuleEngineServiceImpl.netPayableAmt(userVO);
		logger.debug("PayableAmount====>>"+userVO.getPayableAmount());
		
	}

}
