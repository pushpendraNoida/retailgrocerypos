package com.retailgrocery.pos.billing.serviceimpl;


import org.apache.log4j.Logger;

import com.retailgrocery.pos.billing.adaptorservice.DiscountRuleEngineService;
import com.retailgrocery.pos.billing.exception.TransactionalException;
import com.retailgrocery.pos.billing.util.PropertyLoader;
import com.retailgrocery.pos.billing.util.UserTypeGroupMapping;
import com.retailgrocery.pos.billing.util.ValidateTransactionUtil;
import com.retailgrocery.pos.billing.vo.UserVO;

/**
 * 
 * @author PS
 *
 */
public class DiscountRuleEngineServiceImpl implements DiscountRuleEngineService {
	
	final static Logger logger = Logger.getLogger(DiscountRuleEngineServiceImpl.class);

	@Override
	public Double netPayableAmt(UserVO userVO) {

		ValidateTransactionUtil.validateTransactionBilling(userVO);
		Double discountAmount = 0.0;
		try {
			/** by using State pattern on run time it will call dynamically the appropriate
			logic for calculate the discount amount on User Type, By using this pattern,
			It removed if/else and making loosely coupled. 
			**/
			discountAmount = UserTypeGroupMapping.getUserGroupMappingType(
					userVO.getUserType().toString()).getDiscountAmount(userVO);
		} catch (TransactionalException tx) {

			throw new TransactionalException("Transaction unsuccessful==>",
					PropertyLoader.propertyValue("TRANSCATION_FAILED_STATUS"));
		}
		
		logger.debug("UserType======>" + userVO.getUserType());
		logger.debug("discountAmount===>>" + discountAmount);
		Double netPayable = 0.0;

		if (discountAmount >= 0.0) {
			netPayable = totalAmountCalc(userVO, discountAmount);
		}
		return netPayable;
	}

	@Override
	public Double totalAmountCalc(UserVO userVO, Double discountAmount) {
		Double netPayable = userVO.getBillAmount() - discountAmount;
		userVO.setPayableAmount(netPayable);
		return netPayable;
	}

}
