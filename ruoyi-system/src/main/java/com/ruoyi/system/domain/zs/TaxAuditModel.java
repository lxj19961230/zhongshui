package com.ruoyi.system.domain.zs;
import java.time.LocalDateTime;


/**
 *tax_audit bean
 */
public class TaxAuditModel  extends IdModel  {


	/**
	 * 年份
	 */
	private Integer year;
	/**
	 * 业务文档序列号
	 */
	private Integer reportSerial;
	/**
	 * 新建1；存档33；失效555；撤档7777；
	 */
	private Integer state;
	/**
	 * 业务报告存储路径
	 */
	private String reportPath;
	/**
	 * 业务单位
	 */
	private String customerName;
	/**
	 * 业务员ID
	 */
	private Integer userId;
	/**
	 * 业务员姓名
	 */
	private String userName;
	/**
	 * 部门ID
	 */
	private Integer organizationId;
	/**
	 * 部门名称
	 */
	private String organizationName;
	/**
	 * 取号日期
	 */
	private LocalDateTime serialDate;
	/**
	 * 税务类型
	 */
	private String taxType;
	/**
	 * 调整前利润
	 */
	private Double profitBeforeAdjustment;
	/**
	 * 收入
	 */
	private Double income;
	/**
	 * 调整后利润
	 */
	private Double profitAfterAdjustment;
	/**
	 * 纳税调增额或账面研发费（针对加计扣除）
	 */
	private Double taxIncreaseOrBookRDExpenses;
	/**
	 * tax_deduction_or_approved_deduction
	 */
	private Double taxDeductionOrApprovedDeduction;
	/**
	 * 联系人姓名
	 */
	private String contact;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 行业
	 */
	private String industry;
	/**
	 * 统一社会信用代码
	 */
	private String unifiedSocialCreditCode;
	/**
	 * 审计年度
	 */
	private Integer auditYear;
	/**
	 * 报告日期
	 */
	private LocalDateTime reportDate;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 一审人员ID
	 */
	private Integer firstAuditPersonId;
	/**
	 * 一审人员姓名
	 */
	private String firstAuditPersonName;
	/**
	 * 一审意见
	 */
	private String firstAuditOpinion;
	/**
	 * 一审日期
	 */
	private LocalDateTime firstAuditDate;
	/**
	 * 二审人员ID
	 */
	private Integer secondAuditPersonId;
	/**
	 * 二审人员姓名
	 */
	private String secondAuditPersonName;
	/**
	 * 二审意见
	 */
	private String secondAuditOpinion;
	/**
	 * 二审日期
	 */
	private LocalDateTime secondAuditDate;
	/**
	 * 三审人员ID
	 */
	private Integer thirdAudtiPersonId;
	/**
	 * 三审人员姓名
	 */
	private String thirdAuditPersonName;
	/**
	 * 三审意见
	 */
	private String thirdAuditOpinion;
	/**
	 * 三审日期
	 */
	private LocalDateTime thirdAuditDate;
	/**
	 * 收款方式
	 */
	private String paymentMethod;
	/**
	 * 收款金额
	 */
	private Double amountReceived;
	/**
	 * 逻辑删除 0存在；1删除；
	 */
	private Integer isDeleted;

	public TaxAuditModel() {
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getReportSerial() {
		return reportSerial;
	}

	public void setReportSerial(Integer reportSerial) {
		this.reportSerial = reportSerial;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getReportPath() {
		return reportPath;
	}

	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public LocalDateTime getSerialDate() {
		return serialDate;
	}

	public void setSerialDate(LocalDateTime serialDate) {
		this.serialDate = serialDate;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public Double getProfitBeforeAdjustment() {
		return profitBeforeAdjustment;
	}

	public void setProfitBeforeAdjustment(Double profitBeforeAdjustment) {
		this.profitBeforeAdjustment = profitBeforeAdjustment;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Double getProfitAfterAdjustment() {
		return profitAfterAdjustment;
	}

	public void setProfitAfterAdjustment(Double profitAfterAdjustment) {
		this.profitAfterAdjustment = profitAfterAdjustment;
	}

	public Double getTaxIncreaseOrBookRDExpenses() {
		return taxIncreaseOrBookRDExpenses;
	}

	public void setTaxIncreaseOrBookRDExpenses(Double taxIncreaseOrBookRDExpenses) {
		this.taxIncreaseOrBookRDExpenses = taxIncreaseOrBookRDExpenses;
	}

	public Double getTaxDeductionOrApprovedDeduction() {
		return taxDeductionOrApprovedDeduction;
	}

	public void setTaxDeductionOrApprovedDeduction(Double taxDeductionOrApprovedDeduction) {
		this.taxDeductionOrApprovedDeduction = taxDeductionOrApprovedDeduction;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getUnifiedSocialCreditCode() {
		return unifiedSocialCreditCode;
	}

	public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
		this.unifiedSocialCreditCode = unifiedSocialCreditCode;
	}

	public Integer getAuditYear() {
		return auditYear;
	}

	public void setAuditYear(Integer auditYear) {
		this.auditYear = auditYear;
	}

	public LocalDateTime getReportDate() {
		return reportDate;
	}

	public void setReportDate(LocalDateTime reportDate) {
		this.reportDate = reportDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getFirstAuditPersonId() {
		return firstAuditPersonId;
	}

	public void setFirstAuditPersonId(Integer firstAuditPersonId) {
		this.firstAuditPersonId = firstAuditPersonId;
	}

	public String getFirstAuditPersonName() {
		return firstAuditPersonName;
	}

	public void setFirstAuditPersonName(String firstAuditPersonName) {
		this.firstAuditPersonName = firstAuditPersonName;
	}

	public String getFirstAuditOpinion() {
		return firstAuditOpinion;
	}

	public void setFirstAuditOpinion(String firstAuditOpinion) {
		this.firstAuditOpinion = firstAuditOpinion;
	}

	public LocalDateTime getFirstAuditDate() {
		return firstAuditDate;
	}

	public void setFirstAuditDate(LocalDateTime firstAuditDate) {
		this.firstAuditDate = firstAuditDate;
	}

	public Integer getSecondAuditPersonId() {
		return secondAuditPersonId;
	}

	public void setSecondAuditPersonId(Integer secondAuditPersonId) {
		this.secondAuditPersonId = secondAuditPersonId;
	}

	public String getSecondAuditPersonName() {
		return secondAuditPersonName;
	}

	public void setSecondAuditPersonName(String secondAuditPersonName) {
		this.secondAuditPersonName = secondAuditPersonName;
	}

	public String getSecondAuditOpinion() {
		return secondAuditOpinion;
	}

	public void setSecondAuditOpinion(String secondAuditOpinion) {
		this.secondAuditOpinion = secondAuditOpinion;
	}

	public LocalDateTime getSecondAuditDate() {
		return secondAuditDate;
	}

	public void setSecondAuditDate(LocalDateTime secondAuditDate) {
		this.secondAuditDate = secondAuditDate;
	}

	public Integer getThirdAudtiPersonId() {
		return thirdAudtiPersonId;
	}

	public void setThirdAudtiPersonId(Integer thirdAudtiPersonId) {
		this.thirdAudtiPersonId = thirdAudtiPersonId;
	}

	public String getThirdAuditPersonName() {
		return thirdAuditPersonName;
	}

	public void setThirdAuditPersonName(String thirdAuditPersonName) {
		this.thirdAuditPersonName = thirdAuditPersonName;
	}

	public String getThirdAuditOpinion() {
		return thirdAuditOpinion;
	}

	public void setThirdAuditOpinion(String thirdAuditOpinion) {
		this.thirdAuditOpinion = thirdAuditOpinion;
	}

	public LocalDateTime getThirdAuditDate() {
		return thirdAuditDate;
	}

	public void setThirdAuditDate(LocalDateTime thirdAuditDate) {
		this.thirdAuditDate = thirdAuditDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Double getAmountReceived() {
		return amountReceived;
	}

	public void setAmountReceived(Double amountReceived) {
		this.amountReceived = amountReceived;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
}
