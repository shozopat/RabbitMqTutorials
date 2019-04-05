package com.shozo.amqp.producer.summaryStats;

import java.util.List;

public class StatsResponse {

	List<String> columns;
	List<Float> medians;
	List<Float> means;
	List<Float> maxs;
	List<Float> sums;
	List<Float> mins;
	List<Float> counts;
	List<Float> stddevs;
	List<Float> vars;
	String id;
	
	public StatsResponse() {
		
	}

	@Override
	public String toString() {
		return "StatsResponse [columns=" + columns + ", medians=" + medians + ", means=" + means + ", maxs=" + maxs
				+ ", sums=" + sums + ", mins=" + mins + ", counts=" + counts + ", stddevs=" + stddevs + ", vars=" + vars
				+ ", id=" + id + "]";
	}
	
}
