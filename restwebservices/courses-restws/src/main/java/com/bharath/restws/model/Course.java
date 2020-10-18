package com.bharath.restws.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name="Course")
public class Course {
	
	private long id;
	private String name;
	private String taughtBy;
	private BigDecimal price;
	private Integer rating;

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

	public String getTaughtBy() {
		return taughtBy;
	}

	public void setTaughtBy(String taughtBy) {
		this.taughtBy = taughtBy;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
}
