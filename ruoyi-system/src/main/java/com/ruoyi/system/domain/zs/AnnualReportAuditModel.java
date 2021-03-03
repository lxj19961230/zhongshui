package com.ruoyi.system.domain.zs;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.DateUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;


/**
 *annual_report_audit bean
 */
public class AnnualReportAuditModel  extends BaseEntity {


	private Integer id;

	/**
	 * 年份
	 */
	@Excel(name = "年份")
	private Integer year;
	/**
	 * 业务文档序列号
	 */
	@Excel(name = "业务文档序列号")
	private Integer reportSerial;
	/**
	 * 新建1；存档33；失效555；撤档7777；
	 */
	@Excel(name = "状态", readConverterExp = "1=新建,33=存档,555=失效,7777=撤档")
	private Integer state;
	/**
	 * 业务报告存储路径
	 */
	@Excel(name = "业务报告存储路径")
	private String reportPath;
	/**
	 * 业务单位
	 */
	@Excel(name = "业务单位")
	private String customerName;
	/**
	 * 业务员ID
	 */
	private Long userId;
	/**
	 * 业务员姓名
	 */
	@Excel(name = "业务员姓名")
	private String userName;
	/**
	 * 部门ID
	 */
	private Long organizationId;
	/**
	 * 部门名称
	 */
	@Excel(name = "部门名称")
	private String organizationName;
	/**
	 * 取号日期
	 */
	@Excel(name = "报告日期", width = 30, dateFormat = "yyyy-MM-dd", type = Excel.Type.EXPORT)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date serialDate;
	private String serialDateStr;
	/**
	 * 资产
	 */
	@Excel(name = "资产",cellType = Excel.ColumnType.NUMERIC)
	private Double assets;
	/**
	 * 负债
	 */
	@Excel(name = "负债",cellType = Excel.ColumnType.NUMERIC)
	private Double liabilities;
	/**
	 * 实收资本
	 */
	@Excel(name = "实收资本",cellType = Excel.ColumnType.NUMERIC)
	private Double paidInCapital;
	/**
	 * 净资产
	 */
	@Excel(name = "净资产",cellType = Excel.ColumnType.NUMERIC)
	private Double netAssets;
	/**
	 * 收入
	 */
	@Excel(name = "收入",cellType = Excel.ColumnType.NUMERIC)
	private Double income;
	/**
	 * 利润总额
	 */
	@Excel(name = "利润总额",cellType = Excel.ColumnType.NUMERIC)
	private Double totalProfit;
	/**
	 * 所得税
	 */
	@Excel(name = "所得税",cellType = Excel.ColumnType.NUMERIC)
	private Double incomeTax;
	/**
	 * 意见类型
	 */
	@Excel(name = "意见类型")
	private String opinionType;
	/**
	 * 联系人姓名
	 */
	@Excel(name = "联系人姓名")
	private String contact;
	/**
	 * 电话
	 */
	@Excel(name = "电话")
	private String tel;
	/**
	 * 地址
	 */
	@Excel(name = "地址")
	private String address;
	/**
	 * 行业
	 */
	@Excel(name = "行业", readConverterExp = "1=金融行业,2=制造业,3=批发和零售业,4=房地产业")
	private String industry;
	/**
	 * 统一社会信用代码
	 */
	@Excel(name = "统一社会信用代码")
	private String unifiedSocialCreditCode;
	/**
	 * 审计年度
	 */
	@Excel(name = "审计年度",cellType = Excel.ColumnType.NUMERIC)
	private Integer auditYear;
	/**
	 * 企业类型
	 */
	@Excel(name = "企业类型", readConverterExp = "1=上市公司,2=一般企业,3=国有企业,4=事业单位,5=民间非营利组织,6=其他企业")
	private String companyType;
	/**
	 * 报告日期
	 */
	@Excel(name = "报告日期", width = 30, dateFormat = "yyyy-MM-dd", type = Excel.Type.EXPORT)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date reportDate;
	private String reportDateStr;
	/**
	 * 备注
	 */
	@Excel(name = "备注")
	private String remarks;
	/**
	 * 一审人员ID
	 */
	private Long firstAuditPersonId;
	/**
	 * 一审人员姓名
	 */
	@Excel(name = "一审")
	private String firstAuditPersonName;
	/**
	 * 一审意见
	 */
	private String firstAuditOpinion;
	/**
	 * 一审日期
	 */
	@Excel(name = "一审日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date firstAuditDate;
	private String firstAuditDateStr;
	/**
	 * 二审人员ID
	 */
	private Long secondAuditPersonId;
	/**
	 * 二审人员姓名
	 */
	@Excel(name = "二审")
	private String secondAuditPersonName;
	/**
	 * 二审意见
	 */
	private String secondAuditOpinion;
	/**
	 * 二审日期
	 */
	@Excel(name = "二审日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date secondAuditDate;
	private String secondAuditDateStr;
	/**
	 * 三审人员ID
	 */
	private Long thirdAudtiPersonId;
	/**
	 * 三审人员姓名
	 */
	@Excel(name = "三审")
	private String thirdAuditPersonName;
	/**
	 * 三审意见
	 */
	private String thirdAuditOpinion;
	/**
	 * 三审日期
	 */
	@Excel(name = "三审日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date thirdAuditDate;
	private String thirdAuditDateStr;
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


	public String getSerialDateStr() {
		if(Objects.nonNull(serialDate)){
			return DateUtils.parseDateToStr("yyyy-MM-dd",serialDate);
		}
		return serialDateStr;
	}

	public void setSerialDateStr(String serialDateStr) {
		this.serialDateStr = serialDateStr;
	}

	public String getReportDateStr() {
		if(Objects.nonNull(reportDate)){
			return DateUtils.parseDateToStr("yyyy-MM-dd",reportDate);
		}
		return reportDateStr;
	}

	public void setReportDateStr(String reportDateStr) {
		this.reportDateStr = reportDateStr;
	}

	public void setFirstAuditDate(Date firstAuditDate) {
		this.firstAuditDate = firstAuditDate;
	}

	public String getFirstAuditDateStr() {
		if(Objects.nonNull(firstAuditDate)){
			return DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss",firstAuditDate);
		}
		return firstAuditDateStr;
	}

	public void setFirstAuditDateStr(String firstAuditDateStr) {
		this.firstAuditDateStr = firstAuditDateStr;
	}

	public void setSecondAuditDate(Date secondAuditDate) {
		this.secondAuditDate = secondAuditDate;
	}

	public String getSecondAuditDateStr() {
		if(Objects.nonNull(secondAuditDate)){
			return DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss",secondAuditDate);
		}
		return secondAuditDateStr;
	}

	public void setSecondAuditDateStr(String secondAuditDateStr) {
		this.secondAuditDateStr = secondAuditDateStr;
	}

	public void setThirdAuditDate(Date thirdAuditDate) {
		this.thirdAuditDate = thirdAuditDate;
	}

	public String getThirdAuditDateStr() {
		if(Objects.nonNull(thirdAuditDate)){
			return DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss",thirdAuditDate);
		}
		return thirdAuditDateStr;
	}

	public void setThirdAuditDateStr(String thirdAuditDateStr) {
		this.thirdAuditDateStr = thirdAuditDateStr;
	}

	public AnnualReportAuditModel() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Date getSerialDate() {
		return serialDate;
	}

	public void setSerialDate(Date serialDate) {
		this.serialDate = serialDate;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public Long getFirstAuditPersonId() {
		return firstAuditPersonId;
	}

	public void setFirstAuditPersonId(Long firstAuditPersonId) {
		this.firstAuditPersonId = firstAuditPersonId;
	}

	public Long getSecondAuditPersonId() {
		return secondAuditPersonId;
	}

	public void setSecondAuditPersonId(Long secondAuditPersonId) {
		this.secondAuditPersonId = secondAuditPersonId;
	}

	public Long getThirdAudtiPersonId() {
		return thirdAudtiPersonId;
	}

	public void setThirdAudtiPersonId(Long thirdAudtiPersonId) {
		this.thirdAudtiPersonId = thirdAudtiPersonId;
	}

	public Double getAssets() {
		return assets;
	}

	public void setAssets(Double assets) {
		this.assets = assets;
	}

	public Double getLiabilities() {
		return liabilities;
	}

	public void setLiabilities(Double liabilities) {
		this.liabilities = liabilities;
	}

	public Double getPaidInCapital() {
		return paidInCapital;
	}

	public void setPaidInCapital(Double paidInCapital) {
		this.paidInCapital = paidInCapital;
	}

	public Double getNetAssets() {
		return netAssets;
	}

	public void setNetAssets(Double netAssets) {
		this.netAssets = netAssets;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Double getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(Double totalProfit) {
		this.totalProfit = totalProfit;
	}

	public Double getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(Double incomeTax) {
		this.incomeTax = incomeTax;
	}

	public String getOpinionType() {
		return opinionType;
	}

	public void setOpinionType(String opinionType) {
		this.opinionType = opinionType;
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

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}


	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
