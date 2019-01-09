package com.retailgrocery.pos.billing.util;

import com.retailgrocery.pos.billing.vo.UserVO;


/**
 * 
 * @author PS
 *
 */
@FunctionalInterface
public interface UserTypeGroup {
	
	/**
	 * 
	 * @param userVO
	 * @return
	 */
	Double getDiscountAmount(UserVO userVO);
}