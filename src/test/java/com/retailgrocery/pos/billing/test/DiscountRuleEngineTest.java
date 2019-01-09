package com.retailgrocery.pos.billing.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.retailgrocery.pos.billing.exception.TransactionalException;
import com.retailgrocery.pos.billing.serviceimpl.DiscountRuleEngineServiceImpl;
import com.retailgrocery.pos.billing.util.UserTypeGroupMapping;
import com.retailgrocery.pos.billing.vo.UserVO;

public class DiscountRuleEngineTest {
	
	final static Logger logger = Logger.getLogger(DiscountRuleEngineTest.class);
	UserVO userVO=new UserVO();
	DiscountRuleEngineServiceImpl discountRuleEngineServiceImpl = new DiscountRuleEngineServiceImpl();
	 
	// Test Case to validate for UserType = Store Employee
	// +ve scenarios Test case
	@Test
    public void testPositiveCasePayableBilledAmountStoreEMPLOYEE() {
    	 userVO.setUserName("Pushpendra Singh");
 		 userVO.setBillTransctionNumber("10001");
 		 userVO.setBillAmount(500.0);
 		 userVO.setUserType(UserTypeGroupMapping.EMPLOYEE);
 		 Double result= discountRuleEngineServiceImpl.netPayableAmt(userVO);
		 assertNotNull(result);
    }
	// Test Case to validate for UserType = Loyal Customer
	// Customer aligned from 2 year with store
	// +ve scenarios Test case
    @Test
    public void testPositiveCasePayableBilledAmountLoyalCustomer() {
    	 userVO.setUserName("Ram Kumar");
 		 userVO.setBillTransctionNumber("10002");
 		 userVO.setBillAmount(300.0);
 		 userVO.setUserType(UserTypeGroupMapping.LOYAL);
 		 Double result= discountRuleEngineServiceImpl.netPayableAmt(userVO);
		 assertNotNull(result);
    }
    
    // Test Case to validate for UserType = AFFILATED customer
    // +ve scenarios Test case
    @Test
    public void testPositiveCasePayableBilledAmountAffiliated_CUSTOMER() {
    	 userVO.setUserName("Syam Kumar");
 		 userVO.setBillTransctionNumber("10003");
 		 userVO.setBillAmount(100.0);
 		 userVO.setUserType(UserTypeGroupMapping.AFFILIATE);
 		 Double result= discountRuleEngineServiceImpl.netPayableAmt(userVO);
		 assertNotNull(result);
    }
  
    // not passed EMPLOYEE , AFFILIATE and LOYAL
    // Passed unknown i.e. ABCD
    @Test
    public void testCaseForUnknownUserType() {
       
        try {
        	 userVO.setUserName("Syam Kumar");
     		 userVO.setBillTransctionNumber("10004");
     		 userVO.setBillAmount(50.0);
     		 userVO.setUserType(UserTypeGroupMapping.UNKNOWN);
     		 Double result= discountRuleEngineServiceImpl.netPayableAmt(userVO);
   		     assertNotNull(result);
        } catch (TransactionalException e) {
        	 logger.error(e.getMessge()); 
        }
    }

    // Wrong input type for billed amount
    @Test
    public void testCaseForWrongBillAmount() {

		try {
			userVO.setUserName("Raj Kumar Singh");
			userVO.setBillTransctionNumber("10005");
			// userVO.setBillAmount(0.0);
			userVO.setUserType(UserTypeGroupMapping.EMPLOYEE);
			Double result = discountRuleEngineServiceImpl.netPayableAmt(userVO);
			fail("Test Unreachable..................");
		} catch (TransactionalException e) {
			logger.error(e.getMessge());
		}
    }

    // when BillTransctionNumber is not passed
    @Test
    public void testCaseWrongTransactionNo() {
    	try {
    		userVO.setUserName("Ram Singh");
			//userVO.setBillTransctionNumber("10005");
			userVO.setBillAmount(150.0);
			userVO.setUserType(UserTypeGroupMapping.LOYAL);
			Double result = discountRuleEngineServiceImpl.netPayableAmt(userVO);
			fail("Test Unreachable..................");
        } catch (TransactionalException e) {
			logger.error(e.getMessge());
		}
    }
}
