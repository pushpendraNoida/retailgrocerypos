package com.retailgrocery.pos.billing.util;

import java.util.Arrays;

import com.retailgrocery.pos.billing.constants.Constants;
import com.retailgrocery.pos.billing.exception.TransactionalException;
import com.retailgrocery.pos.billing.vo.UserVO;

/**
 * 
 * @author PS
 *
 */
public class ValidateTransactionUtil {
	
	/**
	 * 
	 */
	private ValidateTransactionUtil(){
		
	}

	/**
	 * 
	 * @param userVO
	 * @return
	 */
	public static String validateTransactionBilling(UserVO userVO) {
		String msg = "";

		if (userVO.getBillAmount() == null || userVO.getBillAmount() <= 0.0) {
			msg = Constants.BILLED_AMOUNT_MSG;
			throw new TransactionalException(msg,
					PropertyLoader.propertyValue("BILLED_AMOUNT_NOT_CORRECT"));
		}
		if (userVO.getUserType() == null
				|| !Arrays.asList(UserTypeGroupMapping.values()).contains(
						userVO.getUserType())) {
			msg = Constants.CUSTOMER_TYPE_NOT_CORRECTED;
			throw new TransactionalException(msg,
					PropertyLoader.propertyValue("CUSTOMER_TYPE_NOT_CORRECT"));
		}
		if (userVO.getBillTransctionNumber() == null) {
			msg = Constants.TRANSACTION_NO_NOT_CORRECT;
			throw new TransactionalException(
					msg,
					PropertyLoader
							.propertyValue("EXIT_STATUS_TRANSACTION_NO_NOT_CORRECT"));
		}

		return msg;
	}

}
