package com.retailgrocery.pos.billing.adaptorservice;

import com.retailgrocery.pos.billing.exception.TransactionalException;
import com.retailgrocery.pos.billing.vo.UserVO;


/**
 * 
 * @author PS
 *
 */
public interface DiscountRuleEngineService {
	
	/**
	 * 
	 * @param userVO
	 * @return
	 */
	Double netPayableAmt(UserVO userVO)throws TransactionalException;
	
	
	/**
	 * 
	 * @param userVO
	 * @param discountAmount
	 * @return
	 */
	Double totalAmountCalc(UserVO userVO, Double discountAmount);
	

}
