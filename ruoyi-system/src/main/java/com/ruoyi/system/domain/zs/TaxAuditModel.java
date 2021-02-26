package com.ruoyi.system.domain.zs;
import lombok.*;
import java.time.LocalDateTime;


/**
 *tax_audit bean
 */
@Data
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
}
