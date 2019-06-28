package com.snowsec0.dao;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Demo {
	private long id;// 主键.
	private String name;// 测试名称.
	
	@JSONField(serialize=false)			//转为JSON时不包括此属性
	private String remark;	//备注
	
	@JSONField(format="yyyy-MM-dd HH:mm")   //转为JSON时按格式转换
	private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}