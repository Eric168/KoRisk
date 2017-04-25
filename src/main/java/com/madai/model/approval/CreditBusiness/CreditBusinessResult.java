package com.madai.model.approval.CreditBusiness;

import java.util.ArrayList;
import java.util.List;

public class CreditBusinessResult extends CreditBusinessIn{
	
	/**
	 * 排除结清时间大于24个月的人民币贷款的记录
	 */
	private List<CreditParticular> loanCutPayMore24MonthList  = new ArrayList<>();
	
	/**
	 * 排除销户时间大于24个月的人民币贷记卡的记录
	 */
	private List<CreditParticular> creditCardCutPayMore24MonthList = new ArrayList<>();
	/**
	 * 排除销户时间大于24个月的人民币准贷记卡的记录
	 */
	private List<CreditParticular> semiCreditCardCutPayMore24MonthList = new ArrayList<>();
	
	/**
	 * 总记录数
	 */
	private int recordTotalCount;
	/**
	 * 贷记卡总记录数
	 */
	private int creditCardRecordTotalCount;
	
	/**
	 * 信用卡总记录数
	 */
	private int cardRecordTotalCount;
	
	
	/**
	 * 贷款总记录数
	 */
	private int loanRecordTotalCount;
	
	
	/**
	 * 贷款总记录数-排除结清24个月的
	 */
	private int loanRecordCutPay24MTotalCount;
	
	/**
	 * 排除销户时间大于24个月的人民币贷记卡的总记录数
	 */
	private int creditCardCutPayMore24MonthTotalCount;
	
	/**
	 * 贷款当前逾期，提示拖欠金额是否大于250；
	 * 单笔贷款符合规则就触发系统结果
	 */
	private int loanPastdueAmountMore250Count;
	/**
	 * 贷款历史发生过逾期记录，但未超过90天，以下情况需拒绝：
	 * 贷款发放时间≤1年，且逾期月份数≥已还款月份数的50%；
	 * 单笔贷款符合规则就触发系统结果
	 */
	private int loanPastdueLess90Less01YearCount;	
	/**
	 * 贷款历史发生过逾期记录，但未超过90天，以下情况需拒
	 * 绝：贷款发放时间超过1年 ， 逾期月份数≥已还款月份数
	 * 的50% 或 逾期月份数≥10个月
	 * 所有贷款符合规则就触发系统结果
	 */
	private int loanPastdueLess90More01More10MonthCount;
	/**
	 * "贷款历史发生过逾期记录，但未超过90天，以下情况需拒绝：贷款发放时间超过1年，同时符合以下a、b、c、点，直接拒绝;
     *a)    逾期月份数≥已还款月份数的50% 或 逾期月份数≥10个月
     *b)    结清时间或信息截至时间在近1年以内 ；
     *c)    结清日期以后或截至时间当月及以后无发放新的贷记卡或贷款（农户贷款、低于5000元的消费分期除外）；"
     *单笔贷款符合规则就触发系统结果
	 */
	private int loanPastdueLess90More01More50Or10Count;
	/**
	 * 贷款历史曾有90天以上的逾期记录，以下情况需拒绝：
	 * 贷款发放时间≤1年，超过90天的逾期月份数≥1次；
	 * 单笔贷款符合规则就触发系统结果
	 */
	private int loanPastdueMore90More01YearMore01Count;
	/**
	 * 贷款历史曾有90天以上的逾期记录，以下情况需拒绝：
	 * 1年＜贷款发放时间≤2年，超过90天的逾期月份数≥2次
	 * 单笔贷款符合规则就触发系统结果
	 */
	private int loanPastdueMore90More01Less02YearMore02Count;
	/**
	 * 贷款历史曾有90天以上的逾期记录，以下情况需拒绝：
 	 *贷款发放时间＞2年，超过90天的逾期月份数≥2次，结清
 	 *日期以后或截至时间当月及以后无发放新的贷记卡或贷款（农户贷款、低于5000元的消费分期除外 )
 	 *排除结清时间大于24个月的人民币贷款
 	 * 单笔贷款符合规则就触发系统结果
	 */
	private int loanPastdueMore90More02YearMore02Count;
	/**
	 * 若客户名下仅有农户贷款，且历史逾期达到贷款拒绝标准的
	 * ，只要在逾期的贷款记录后有新的农户贷款产生，可正常处理
	 * 排除结清时间大于24个月的人民币贷款
	 * 单笔贷款符合规则就触发系统结果
	 */
	private int loanNongHuAppearNowLoanCount;
	/**
	 * 贷记卡当前逾期，且显示单张卡当前逾期金额大于250元，且当前无从未逾期过的贷记卡或
	 * 贷款（已使用额度为0、农户贷款、未激活、低于5000元的消费分期，使用记录不足半年除
	 * 外，逾期的信用卡发放时间距离信息截至时间超过6个月就提示
	 * 单笔贷记卡符合规则就触发系统结果
	 */
	private int cardNowPastdueMore250NoHistoryMore6Count;
	/**
	 * 贷记卡当前逾期，且显示单张卡当前逾期金额大于250元，且当前无从未逾期过的贷记卡或贷款
	 * （已使用额度为0、农户贷款、未激活、低于5000元的消费分期，使用记录不足半年除外，逾期
	 * 的信用卡发放时间距离信息截至时间小于等6个月就直接拒绝
	 * 单笔贷记卡符合规则就触发系统结果
	 */
	private int cardNowPastdueMore250NoHistoryLess6Count;
	/**
	 * 贷记卡账户状态止付或呆账，且在止付或呆账下其余额大于250元（单张卡）符合不良标准，直接拒绝
	 * 单笔贷记卡符合规则就触发系统结果
	 */
	private int cardDzZfMore250Count;
	/**
	 * 贷记卡账户状态止付或呆账，且在止付或呆账下其余额小于250元，销户日期以后或截至时间当月及以后无发放新的贷记
	 * 卡或贷款（农户贷款、低于5000元的消费分期除外）（单张卡），直接拒绝
	 * 单笔贷记卡符合规则就触发系统结果
	 */
	private int cardDzZfLess250OverXhNoNewCount;
	/**
	 * 贷记卡历史发生过逾期，但未超过90天，以下情况需拒绝：
	 * 1、贷记卡发放时间≤1年，逾期月份数≥发卡月份数的50%（单张卡）
	 * 所有贷记卡符合规则就触发系统结果
	 */
	private int cardPastdueMore90Less01YMore50Count;
	/**
	 * 贷记卡历史发生过逾期，但未超过90天，以下情况需拒绝:
	 * 贷记卡发放时间超过1年，若仅有a类还款记录，可直接拒绝，（单张卡）a)    
	 * 逾期月份数≥发卡月份数的50% 或 逾期月份数≥12个月；
	 * 排除销户时间大于24个月的人民币贷记卡
	 * 单笔贷记卡符合规则就触发系统结果
	 */
	private int cardPastdueLess90More01YMore50ACount;
	/**
	 *贷记卡历史发生过逾期，但未超过90天，发放时间超过1年，同时符合以下a、b、c、d点，拒绝处理（单张卡）
	 *a) 逾期月份数≥发卡月份数的50% 或 逾期月份数≥12个月；
	 *b) 授信额度大于500元（已销户的账户默认授信额度大于500元）；
	 *c) 销户时间或信息截至时间在近1年以内；
	 *d) 销户日期以后或截至时间当月及以后无发放新的贷记卡或贷款（农户贷款、低于5000元的消费分期除外）。
	 *排除销户时间大于24个月的人民币贷记卡
	 *单笔贷记卡符合规则就触发系统结果
	 */
	private int cardPastdueLess90More01YMore50ABCDCount;
	/**
	 * 贷记卡历史曾有90天以上的逾期记录，以下情况需拒绝：贷记卡发放时间≤1年，超过90天的逾期月份数≥1次
	 * 单笔贷记卡符合规则就触发系统结果
	 */
	private int cardPastdueMore90Less01Y90More01Count;
	/**
	 * 贷记卡历史曾有90天以上的逾期记录，以下情况需拒绝：
	 * 1年＜贷记卡发放时间≤2年，超过90天的逾期月份数≥2次
	 * 单笔贷记卡符合规则就触发系统结果
	 */
	private int cardPastdueMore90More01Less02Y90More02Count;
	
	/**
	 * 贷记卡历史曾有90天以上的逾期记录，以下情况需拒绝：贷记卡发放时间＞2年，超过90天的
	 * 逾期月份数≥2次，销户日期以后或截至时间当月及以后无发放新的贷记卡或贷款（农户贷款、低于5000元的消费分期除外）
	 * 排除销户时间大于24个月的人民币贷记卡
	 * 单笔贷记卡符合规则就触发系统结果
	 */
	private int cardPastdueMore90More02YMore02OverNoNewCount;
	/**
	 * 透支余额大于250元（已销户的账户默认透支余额大于250元），且有过90天以上逾期记录≥2个月，
	 * 且销户日期以后或截至时间当月及以后无发放新的贷记卡或贷款（农户贷款、低于5000元的消费分期除外）
	 * 排除销户时间大于24个月的人民币准贷记卡
	 * 单笔贷记卡符合规则就触发系统结果
	 */
	private int cardMore250Pastdue90More02OverNoNewCount;
	/**
	 * 无任何信用记录， 直接拒绝
	 */
	private int whiteNoRecord;
	/**
	 * 历史有信用记录，但已全部结清或者销户，且结清销户时间在2年以上，直接拒绝
	 * 规则作用于所有信用卡和贷款
	 */
	private int whiteHasRecAllJqXhMore02YearCount;
	/**
	 * 当前所有的信用卡未激活且所有贷款发放时间距离查询报告时间不足3个月，直接拒绝
	 * 规则作用于所有信用卡和贷款
	 */
	private int whiteAllCardWjhReportQueryLess03MonthCount;
	/**
	 * 当前有发放信用卡，但发放时间距离报告时间不满3个月，且透支余额为0.且全部贷款结清时间在2年以上
	 * 规则作用于所有信用卡和贷款
	 */
	private int whiteAllCardLess03banlce0JqOver02Count;
	/**
     * 其他性质贷款，农户性质贷款的总记录数
     */
	private int notOtherLoanAndFarmerLoanTotalCount;

	/**
	 * 征信显示某笔贷款到期日在申请日之前，但是当前状态没有更新，显示为非结清的状态，需根据以下规则进行处理：
	 * 如果贷款为其他性质贷款或农户贷款，当前余额≥1万，需提供结清证明，才能进件
	 * 规则作用于其他性质贷款'，‘农户性质贷款’贷款
	 */
	private int otherEndBefApplyDateNhLoanMore1WCount;
	/**
	 * 近3个月查询次数:EX贷产品大于等于6次直接拒绝
	 */
	private int other3MonthQueryEXProductMore6Count;
	/**
	 * 近3个月查询次数:U贷产品大于等于8次直接拒绝
	 */
	private int other3MonthQueryUProductMore8Count;;
	/**
	 * 近24个月信用卡查询次数大于24次，系统提示
	 */
	private int other24MonthQueryMore24Count ;

	
	public int getLoanPastdueAmountMore250Count() {
		return loanPastdueAmountMore250Count;
	}
	public void setLoanPastdueAmountMore250Count(int loanPastdueAmountMore250Count) {
		this.loanPastdueAmountMore250Count = loanPastdueAmountMore250Count;
	}
	public int getLoanPastdueLess90Less01YearCount() {
		return loanPastdueLess90Less01YearCount;
	}
	public void setLoanPastdueLess90Less01YearCount(int loanPastdueLess90Less01YearCount) {
		this.loanPastdueLess90Less01YearCount = loanPastdueLess90Less01YearCount;
	}
	public int getLoanPastdueLess90More01More10MonthCount() {
		return loanPastdueLess90More01More10MonthCount;
	}
	public void setLoanPastdueLess90More01More10MonthCount(int loanPastdueLess90More01More10MonthCount) {
		this.loanPastdueLess90More01More10MonthCount = loanPastdueLess90More01More10MonthCount;
	}
	public int getLoanPastdueLess90More01More50Or10Count() {
		return loanPastdueLess90More01More50Or10Count;
	}
	public void setLoanPastdueLess90More01More50Or10Count(int loanPastdueLess90More01More50Or10Count) {
		this.loanPastdueLess90More01More50Or10Count = loanPastdueLess90More01More50Or10Count;
	}
	public int getLoanPastdueMore90More01YearMore01Count() {
		return loanPastdueMore90More01YearMore01Count;
	}
	public void setLoanPastdueMore90More01YearMore01Count(int loanPastdueMore90More01YearMore01Count) {
		this.loanPastdueMore90More01YearMore01Count = loanPastdueMore90More01YearMore01Count;
	}
	public int getLoanPastdueMore90More01Less02YearMore02Count() {
		return loanPastdueMore90More01Less02YearMore02Count;
	}
	public void setLoanPastdueMore90More01Less02YearMore02Count(int loanPastdueMore90More01Less02YearMore02Count) {
		this.loanPastdueMore90More01Less02YearMore02Count = loanPastdueMore90More01Less02YearMore02Count;
	}
	public int getLoanPastdueMore90More02YearMore02Count() {
		return loanPastdueMore90More02YearMore02Count;
	}
	public void setLoanPastdueMore90More02YearMore02Count(int loanPastdueMore90More02YearMore02Count) {
		this.loanPastdueMore90More02YearMore02Count = loanPastdueMore90More02YearMore02Count;
	}
	public int getLoanNongHuAppearNowLoanCount() {
		return loanNongHuAppearNowLoanCount;
	}
	public void setLoanNongHuAppearNowLoanCount(int loanNongHuAppearNowLoanCount) {
		this.loanNongHuAppearNowLoanCount = loanNongHuAppearNowLoanCount;
	}
	public int getCardNowPastdueMore250NoHistoryMore6Count() {
		return cardNowPastdueMore250NoHistoryMore6Count;
	}
	public void setCardNowPastdueMore250NoHistoryMore6Count(int cardNowPastdueMore250NoHistoryMore6Count) {
		this.cardNowPastdueMore250NoHistoryMore6Count = cardNowPastdueMore250NoHistoryMore6Count;
	}
	public int getCardNowPastdueMore250NoHistoryLess6Count() {
		return cardNowPastdueMore250NoHistoryLess6Count;
	}
	public void setCardNowPastdueMore250NoHistoryLess6Count(int cardNowPastdueMore250NoHistoryLess6Count) {
		this.cardNowPastdueMore250NoHistoryLess6Count = cardNowPastdueMore250NoHistoryLess6Count;
	}
	public int getCardDzZfMore250Count() {
		return cardDzZfMore250Count;
	}
	public void setCardDzZfMore250Count(int cardDzZfMore250Count) {
		this.cardDzZfMore250Count = cardDzZfMore250Count;
	}
	public int getCardDzZfLess250OverXhNoNewCount() {
		return cardDzZfLess250OverXhNoNewCount;
	}
	public void setCardDzZfLess250OverXhNoNewCount(int cardDzZfLess250OverXhNoNewCount) {
		this.cardDzZfLess250OverXhNoNewCount = cardDzZfLess250OverXhNoNewCount;
	}
	public int getCardPastdueMore90Less01YMore50Count() {
		return cardPastdueMore90Less01YMore50Count;
	}
	public void setCardPastdueMore90Less01YMore50Count(int cardPastdueMore90Less01YMore50Count) {
		this.cardPastdueMore90Less01YMore50Count = cardPastdueMore90Less01YMore50Count;
	}
	public int getCardPastdueLess90More01YMore50ACount() {
		return cardPastdueLess90More01YMore50ACount;
	}
	public void setCardPastdueLess90More01YMore50ACount(int cardPastdueLess90More01YMore50ACount) {
		this.cardPastdueLess90More01YMore50ACount = cardPastdueLess90More01YMore50ACount;
	}
	public int getCardPastdueLess90More01YMore50ABCDCount() {
		return cardPastdueLess90More01YMore50ABCDCount;
	}
	public void setCardPastdueLess90More01YMore50ABCDCount(int cardPastdueLess90More01YMore50ABCDCount) {
		this.cardPastdueLess90More01YMore50ABCDCount = cardPastdueLess90More01YMore50ABCDCount;
	}
	public int getCardPastdueMore90Less01Y90More01Count() {
		return cardPastdueMore90Less01Y90More01Count;
	}
	public void setCardPastdueMore90Less01Y90More01Count(int cardPastdueMore90Less01Y90More01Count) {
		this.cardPastdueMore90Less01Y90More01Count = cardPastdueMore90Less01Y90More01Count;
	}
	public int getCardPastdueMore90More01Less02Y90More02Count() {
		return cardPastdueMore90More01Less02Y90More02Count;
	}
	public void setCardPastdueMore90More01Less02Y90More02Count(int cardPastdueMore90More01Less02Y90More02Count) {
		this.cardPastdueMore90More01Less02Y90More02Count = cardPastdueMore90More01Less02Y90More02Count;
	}
	public int getCardPastdueMore90More02YMore02OverNoNewCount() {
		return cardPastdueMore90More02YMore02OverNoNewCount;
	}
	public void setCardPastdueMore90More02YMore02OverNoNewCount(int cardPastdueMore90More02YMore02OverNoNewCount) {
		this.cardPastdueMore90More02YMore02OverNoNewCount = cardPastdueMore90More02YMore02OverNoNewCount;
	}
	public int getCardMore250Pastdue90More02OverNoNewCount() {
		return cardMore250Pastdue90More02OverNoNewCount;
	}
	public void setCardMore250Pastdue90More02OverNoNewCount(int cardMore250Pastdue90More02OverNoNewCount) {
		this.cardMore250Pastdue90More02OverNoNewCount = cardMore250Pastdue90More02OverNoNewCount;
	}
	public int getWhiteNoRecord() {
		return whiteNoRecord;
	}
	public void setWhiteNoRecord(int whiteNoRecord) {
		this.whiteNoRecord = whiteNoRecord;
	}
	public int getWhiteHasRecAllJqXhMore02YearCount() {
		return whiteHasRecAllJqXhMore02YearCount;
	}
	public void setWhiteHasRecAllJqXhMore02YearCount(int whiteHasRecAllJqXhMore02YearCount) {
		this.whiteHasRecAllJqXhMore02YearCount = whiteHasRecAllJqXhMore02YearCount;
	}
	public int getWhiteAllCardWjhReportQueryLess03MonthCount() {
		return whiteAllCardWjhReportQueryLess03MonthCount;
	}
	public void setWhiteAllCardWjhReportQueryLess03MonthCount(int whiteAllCardWjhReportQueryLess03MonthCount) {
		this.whiteAllCardWjhReportQueryLess03MonthCount = whiteAllCardWjhReportQueryLess03MonthCount;
	}
	public int getWhiteAllCardLess03banlce0JqOver02Count() {
		return whiteAllCardLess03banlce0JqOver02Count;
	}
	public void setWhiteAllCardLess03banlce0JqOver02Count(int whiteAllCardLess03banlce0JqOver02Count) {
		this.whiteAllCardLess03banlce0JqOver02Count = whiteAllCardLess03banlce0JqOver02Count;
	}
	public int getOtherEndBefApplyDateNhLoanMore1WCount() {
		return otherEndBefApplyDateNhLoanMore1WCount;
	}
	public void setOtherEndBefApplyDateNhLoanMore1WCount(int otherEndBefApplyDateNhLoanMore1WCount) {
		this.otherEndBefApplyDateNhLoanMore1WCount = otherEndBefApplyDateNhLoanMore1WCount;
	}
	public int getOther3MonthQueryEXProductMore6Count() {
		return other3MonthQueryEXProductMore6Count;
	}
	public void setOther3MonthQueryEXProductMore6Count(int other3MonthQueryEXProductMore6Count) {
		this.other3MonthQueryEXProductMore6Count = other3MonthQueryEXProductMore6Count;
	}
	public int getOther3MonthQueryUProductMore8Count() {
		return other3MonthQueryUProductMore8Count;
	}
	public void setOther3MonthQueryUProductMore8Count(int other3MonthQueryUProductMore8Count) {
		this.other3MonthQueryUProductMore8Count = other3MonthQueryUProductMore8Count;
	}
	public int getOther24MonthQueryMore24Count() {
		return other24MonthQueryMore24Count;
	}
	public void setOther24MonthQueryMore24Count(int other24MonthQueryMore24Count) {
		this.other24MonthQueryMore24Count = other24MonthQueryMore24Count;
	}
	
	public List<CreditParticular> getCreditCardCutPayMore24MonthList() {
		return creditCardCutPayMore24MonthList;
	}
	public void setCreditCardCutPayMore24MonthList(List<CreditParticular> creditCardCutPayMore24MonthList) {
		this.creditCardCutPayMore24MonthList = creditCardCutPayMore24MonthList;
	}
	
	public List<CreditParticular> getSemiCreditCardCutPayMore24MonthList() {
		return semiCreditCardCutPayMore24MonthList;
	}
	public void setSemiCreditCardCutPayMore24MonthList(List<CreditParticular> semiCreditCardCutPayMore24MonthList) {
		this.semiCreditCardCutPayMore24MonthList = semiCreditCardCutPayMore24MonthList;
	}
	public int getCreditCardRecordTotalCount() {
		return creditCardRecordTotalCount;
	}
	public void setCreditCardRecordTotalCount(int creditCardRecordTotalCount) {
		this.creditCardRecordTotalCount = creditCardRecordTotalCount;
	}
	
	public int getRecordTotalCount() {
		return recordTotalCount;
	}
	public void setRecordTotalCount(int recordTotalCount) {
		this.recordTotalCount = recordTotalCount;
	}
	public int getCardRecordTotalCount() {
		return cardRecordTotalCount;
	}
	public void setCardRecordTotalCount(int cardRecordTotalCount) {
		this.cardRecordTotalCount = cardRecordTotalCount;
	}
	public List<CreditParticular> getLoanCutPayMore24MonthList() {
		return loanCutPayMore24MonthList;
	}
	public void setLoanCutPayMore24MonthList(List<CreditParticular> loanCutPayMore24MonthList) {
		this.loanCutPayMore24MonthList = loanCutPayMore24MonthList;
	}
	public int getLoanRecordTotalCount() {
		return loanRecordTotalCount;
	}
	public void setLoanRecordTotalCount(int loanRecordTotalCount) {
		this.loanRecordTotalCount = loanRecordTotalCount;
	}
	public int getLoanRecordCutPay24MTotalCount() {
		return loanRecordCutPay24MTotalCount;
	}
	public void setLoanRecordCutPay24MTotalCount(int loanRecordCutPay24MTotalCount) {
		this.loanRecordCutPay24MTotalCount = loanRecordCutPay24MTotalCount;
	}
	
	public int getCreditCardCutPayMore24MonthTotalCount() {
		return creditCardCutPayMore24MonthTotalCount;
	}
	public void setCreditCardCutPayMore24MonthTotalCount(int creditCardCutPayMore24MonthTotalCount) {
		this.creditCardCutPayMore24MonthTotalCount = creditCardCutPayMore24MonthTotalCount;
	}
	public int getNotOtherLoanAndFarmerLoanTotalCount() {
		return notOtherLoanAndFarmerLoanTotalCount;
	}
	public void setNotOtherLoanAndFarmerLoanTotalCount(
			int notOtherLoanAndFarmerLoanTotalCount) {
		this.notOtherLoanAndFarmerLoanTotalCount = notOtherLoanAndFarmerLoanTotalCount;
	}
	@Override
	public String toString() {
		return "CreditBusinessResult [loanCutPayMore24MonthList="
				+ loanCutPayMore24MonthList
				+ ", creditCardCutPayMore24MonthList="
				+ creditCardCutPayMore24MonthList
				+ ", semiCreditCardCutPayMore24MonthList="
				+ semiCreditCardCutPayMore24MonthList + ", recordTotalCount="
				+ recordTotalCount + ", creditCardRecordTotalCount="
				+ creditCardRecordTotalCount + ", cardRecordTotalCount="
				+ cardRecordTotalCount + ", loanRecordTotalCount="
				+ loanRecordTotalCount + ", loanRecordCutPay24MTotalCount="
				+ loanRecordCutPay24MTotalCount
				+ ", creditCardCutPayMore24MonthTotalCount="
				+ creditCardCutPayMore24MonthTotalCount
				+ ", loanPastdueAmountMore250Count="
				+ loanPastdueAmountMore250Count
				+ ", loanPastdueLess90Less01YearCount="
				+ loanPastdueLess90Less01YearCount
				+ ", loanPastdueLess90More01More10MonthCount="
				+ loanPastdueLess90More01More10MonthCount
				+ ", loanPastdueLess90More01More50Or10Count="
				+ loanPastdueLess90More01More50Or10Count
				+ ", loanPastdueMore90More01YearMore01Count="
				+ loanPastdueMore90More01YearMore01Count
				+ ", loanPastdueMore90More01Less02YearMore02Count="
				+ loanPastdueMore90More01Less02YearMore02Count
				+ ", loanPastdueMore90More02YearMore02Count="
				+ loanPastdueMore90More02YearMore02Count
				+ ", loanNongHuAppearNowLoanCount="
				+ loanNongHuAppearNowLoanCount
				+ ", cardNowPastdueMore250NoHistoryMore6Count="
				+ cardNowPastdueMore250NoHistoryMore6Count
				+ ", cardNowPastdueMore250NoHistoryLess6Count="
				+ cardNowPastdueMore250NoHistoryLess6Count
				+ ", cardDzZfMore250Count=" + cardDzZfMore250Count
				+ ", cardDzZfLess250OverXhNoNewCount="
				+ cardDzZfLess250OverXhNoNewCount
				+ ", cardPastdueMore90Less01YMore50Count="
				+ cardPastdueMore90Less01YMore50Count
				+ ", cardPastdueLess90More01YMore50ACount="
				+ cardPastdueLess90More01YMore50ACount
				+ ", cardPastdueLess90More01YMore50ABCDCount="
				+ cardPastdueLess90More01YMore50ABCDCount
				+ ", cardPastdueMore90Less01Y90More01Count="
				+ cardPastdueMore90Less01Y90More01Count
				+ ", cardPastdueMore90More01Less02Y90More02Count="
				+ cardPastdueMore90More01Less02Y90More02Count
				+ ", cardPastdueMore90More02YMore02OverNoNewCount="
				+ cardPastdueMore90More02YMore02OverNoNewCount
				+ ", cardMore250Pastdue90More02OverNoNewCount="
				+ cardMore250Pastdue90More02OverNoNewCount + ", whiteNoRecord="
				+ whiteNoRecord + ", whiteHasRecAllJqXhMore02YearCount="
				+ whiteHasRecAllJqXhMore02YearCount
				+ ", whiteAllCardWjhReportQueryLess03MonthCount="
				+ whiteAllCardWjhReportQueryLess03MonthCount
				+ ", whiteAllCardLess03banlce0JqOver02Count="
				+ whiteAllCardLess03banlce0JqOver02Count
				+ ", notOtherLoanAndFarmerLoanTotalCount="
				+ notOtherLoanAndFarmerLoanTotalCount
				+ ", otherEndBefApplyDateNhLoanMore1WCount="
				+ otherEndBefApplyDateNhLoanMore1WCount
				+ ", other3MonthQueryEXProductMore6Count="
				+ other3MonthQueryEXProductMore6Count
				+ ", other3MonthQueryUProductMore8Count="
				+ other3MonthQueryUProductMore8Count
				+ ", other24MonthQueryMore24Count="
				+ other24MonthQueryMore24Count + "]";
	}
	
}
