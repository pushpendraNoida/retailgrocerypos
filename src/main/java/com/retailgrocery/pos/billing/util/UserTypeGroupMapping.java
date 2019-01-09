package com.retailgrocery.pos.billing.util;

import org.apache.log4j.Logger;

import com.retailgrocery.pos.billing.exception.TransactionalException;
import com.retailgrocery.pos.billing.vo.UserVO;


/**
 * 
 * @author PS
 * @Note Implementation of State pattern for calculating discount offer on Customer type.
 *
 */
public enum UserTypeGroupMapping implements UserTypeGroup {
	
	
	/**
	 * calculate the Get store type EMPLOYEE DISCOUNT
	 * 
	 */
	EMPLOYEE {
		@Override
		public Double getDiscountAmount(UserVO userVO) throws TransactionalException{
                // Calculating 5 % (100$ transaction billing) discount and 30 % 0n Store Employee 
				Double discountAmount = ((userVO.getBillAmount() / 100) * 5) + ((30 * userVO.getBillAmount()) / 100);
				return discountAmount;
			
			
		}
	},
	
	/**
	 * calculate the Get type AFFILIATE Customer DISCOUNT
	 * 
	 */
	AFFILIATE {
		@Override
		public Double getDiscountAmount(UserVO userVO) throws TransactionalException{
				Double discountAmount = ((userVO.getBillAmount() / 100) * 5) +((10 * userVO.getBillAmount()) / 100);
				return discountAmount;
			
		}
	},
	/**
	 * calculate the Get type Loyal Customer (aligned with store from 2 years) DISCOUNT
	 * 
	 */
	LOYAL {
		@Override
		public Double getDiscountAmount(UserVO userVO) throws TransactionalException{
				Double discountAmount = ((userVO.getBillAmount() / 100) * 5) +((5 * userVO.getBillAmount()) / 100);
				return discountAmount;
			
		}
	},
	
	/**
	 * calculate the Get type GROCERY Customer
	 * 
	 */
	GROCERY {
		@Override
		public Double getDiscountAmount(UserVO userVO) throws TransactionalException{
				Double discountAmount = (userVO.getBillAmount() / 100) * 5;
				return discountAmount;
						
		}
	},
	
	
	/**
	 * if User/Customer is UNKNOWN
	 * 
	 */
	UNKNOWN {
		@Override
		public Double getDiscountAmount(UserVO userVO)throws TransactionalException {
			return 0.0;
		}
	};
	
	
	/**
	 * 
	 * @param pass the Customer TYpe as runTime (Generic)
	 * @return
	 */
	public static UserTypeGroupMapping getUserGroupMappingType(String runTimeValue) {
		final  Logger logger = Logger.getLogger(UserTypeGroupMapping.class);
		try {
			return UserTypeGroupMapping.valueOf(runTimeValue.toUpperCase());
		} catch (Exception ex) {
			logger.error(ex.getMessage()); 
			return UserTypeGroupMapping.valueOf("UNKNOWN");
		}
	}
}
