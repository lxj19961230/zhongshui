package com.ruoyi.system.domain.zs;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.DateUtils;
import java.util.Date;
import java.util.Objects;


/**
 *other_tax_assurance bean
 */
public class OtherTaxAssuranceModel  extends BaseEntity {


	private Integer id;
	/**
	 * 年份
	 */
	@Excel(name = "年份",cellType = Excel.ColumnType.NUMERIC)
	private Integer year;
	/**
	 * 业务文档序列号
	 */
	@Excel(name = "业务文档序列号",cellType = Excel.ColumnType.NUMERIC)
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
	@Excel(name = "取号日期", width = 30, dateFormat = "yyyy-MM-dd", type = Excel.Type.EXPORT)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date serialDate;
	private String serialDateStr;
	/**
	 * 审计项目名称
	 */
	@Excel(name = "审计项目名称")
	private String auditProjectName;
	/**
	 * 主要指标
	 */
	@Excel(name = "主要指标")
	private String mainIndicators;
	/**
	 * 审计开始年度
	 */
	@Excel(name = "审计开始年度", width = 30, dateFormat = "yyyy-MM-dd", type = Excel.Type.EXPORT)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date auditStartYear;
	private String auditStartYearStr;
	/**
	 * 审计结束年度
	 */
	@Excel(name = "审计结束年度", width = 30, dateFormat = "yyyy-MM-dd", type = Excel.Type.EXPORT)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date auditEndYear;
	private String auditEndYearStr;
	/**
	 * 审计年度
	 */
	@Excel(name = "auditYear",cellType = Excel.ColumnType.NUMERIC)
	private Integer auditYear;
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
	private String remarks;
	/**
	 * 一审人员ID
	 */
	private Long firstAuditPersonId;
	/**
	 * 一审人员姓名
	 */
	@Excel(name = "一审人员姓名")
	private String firstAuditPersonName;
	/**
	 * 一审意见
	 */
	@Excel(name = "一审意见")
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
	@Excel(name = "二审人员姓名")
	private String secondAuditPersonName;
	/**
	 * 二审意见
	 */
	@Excel(name = "二审意见")
	private String secondAuditOpinion;
	/**
	 * 二审日期
	 */
	@Excel(name = "二审日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date secondAuditDate;
	@Excel(name = "联系人姓名")
	private String secondAuditDateStr;
	/**
	 * 三审人员ID
	 */
	private Long thirdAudtiPersonId;
	/**
	 * 三审人员姓名
	 */
	@Excel(name = "三审人员姓名")
	private String thirdAuditPersonName;
	/**
	 * 三审意见
	 */
	@Excel(name = "三审意见")
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


	public OtherTaxAssuranceModel() {
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


	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}


	public String getAuditProjectName() {
		return auditProjectName;
	}

	public void setAuditProjectName(String auditProjectName) {
		this.auditProjectName = auditProjectName;
	}

	public String getMainIndicators() {
		return mainIndicators;
	}

	public void setMainIndicators(String mainIndicators) {
		this.mainIndicators = mainIndicators;
	}

	public Integer getAuditYear() {
		return auditYear;
	}

	public void setAuditYear(Integer auditYear) {
		this.auditYear = auditYear;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getSerialDate() {
		return serialDate;
	}

	public void setSerialDate(Date serialDate) {
		this.serialDate = serialDate;
	}

	public Date getAuditStartYear() {
		return auditStartYear;
	}

	public void setAuditStartYear(Date auditStartYear) {
		this.auditStartYear = auditStartYear;
	}

	public Date getAuditEndYear() {
		return auditEndYear;
	}

	public void setAuditEndYear(Date auditEndYear) {
		this.auditEndYear = auditEndYear;
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

	public Date getFirstAuditDate() {
		return firstAuditDate;
	}

	public void setFirstAuditDate(Date firstAuditDate) {
		this.firstAuditDate = firstAuditDate;
	}

	public Long getSecondAuditPersonId() {
		return secondAuditPersonId;
	}

	public void setSecondAuditPersonId(Long secondAuditPersonId) {
		this.secondAuditPersonId = secondAuditPersonId;
	}

	public Date getSecondAuditDate() {
		return secondAuditDate;
	}

	public void setSecondAuditDate(Date secondAuditDate) {
		this.secondAuditDate = secondAuditDate;
	}

	public Long getThirdAudtiPersonId() {
		return thirdAudtiPersonId;
	}

	public void setThirdAudtiPersonId(Long thirdAudtiPersonId) {
		this.thirdAudtiPersonId = thirdAudtiPersonId;
	}

	public Date getThirdAuditDate() {
		return thirdAuditDate;
	}

	public void setThirdAuditDate(Date thirdAuditDate) {
		this.thirdAuditDate = thirdAuditDate;
	}

	public String getThirdAuditDateStr() {
		if(Objects.nonNull(thirdAuditDate)){
			return DateUtils.parseDateToStr("yyyy-MM-dd",thirdAuditDate);
		}
		return thirdAuditDateStr;
	}

	public void setThirdAuditDateStr(String thirdAuditDateStr) {
		this.thirdAuditDateStr = thirdAuditDateStr;
	}

	public String getSerialDateStr() {
		if(Objects.nonNull(serialDate)){
			return DateUtils.parseDateToStr("yyyy-MM-dd",serialDate);
		}
		return serialDateStr;
	}

	public void setSerialDateStr(String serialDateStr) {
		this.serialDateStr = serialDateStr;
	}

	public String getSecondAuditDateStr() {
		if(Objects.nonNull(secondAuditDate)){
			return DateUtils.parseDateToStr("yyyy-MM-dd",secondAuditDate);
		}
		return firstAuditDateStr;
	}

	public void setSecondAuditDateStr(String secondAuditDateStr) {
		this.secondAuditDateStr = secondAuditDateStr;
	}
	public String getFirstAuditDateStr() {
		if(Objects.nonNull(firstAuditDate)){
			return DateUtils.parseDateToStr("yyyy-MM-dd",firstAuditDate);
		}
		return firstAuditDateStr;
	}

	public void setFirstAuditDateStr(String firstAuditDateStr) {
		this.firstAuditDateStr = firstAuditDateStr;
	}

	public String getAuditEndYearStr() {
		if(Objects.nonNull(auditEndYear)){
			return DateUtils.parseDateToStr("yyyy-MM-dd",auditEndYear);
		}
		return auditEndYearStr;
	}

	public void setAuditEndYearStr(String auditEndYearStr) {
		this.auditEndYearStr = auditEndYearStr;
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

	public String getAuditStartYearStr() {
		if(Objects.nonNull(auditStartYear)){
			return DateUtils.parseDateToStr("yyyy-MM-dd",auditStartYear);
		}
		return auditStartYearStr;
	}

	public void setAuditStartYearStr(String auditStartYearStr) {
		this.auditStartYearStr = auditStartYearStr;
	}
}
