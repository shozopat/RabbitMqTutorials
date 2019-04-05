package com.shozo.amqp.producer.summaryStats;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.context.annotation.Profile;

@Profile("stats")
@Entity
public class Dataset implements Serializable{

	private static final long serialVersionUID = 2373041735506378127L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer datasetId;
	
	@Column
	String datasetName;
	
	@Column
	Timestamp createDate;

	@Column
	@Lob
	String statsInfo;
	
	public Dataset() {
		
	}

	public Integer getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(Integer datasetId) {
		this.datasetId = datasetId;
	}

	public String getDatasetName() {
		return datasetName;
	}

	public void setDatasetName(String datasetName) {
		this.datasetName = datasetName;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getStatsInfo() {
		return statsInfo;
	}

	public void setStatsInfo(String statsInfo) {
		this.statsInfo = statsInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
