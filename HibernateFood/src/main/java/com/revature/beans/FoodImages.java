package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Images")
public class FoodImages {
	public FoodImages(int foodId, int userId, String comment, String description) {
		super();
		this.foodId = foodId;
		this.userId = userId;
		this.comment = comment;
		this.description = description;
	}
	

	public FoodImages(int userId, String comment, String description) {
		super();
		this.userId = userId;
		this.comment = comment;
		this.description = description;
	}
	
	public FoodImages() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="foodSequence")
	@SequenceGenerator(allocationSize=1,name="foodSequence",sequenceName="SQ_FOOD_PK")
	@Column(name="FOOD_ID")
	private int foodId;
	
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="IMAGE")
	private String comment;
	
	@Column(name="DESCRIPTION")
	private String description;

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "FoodImages [foodId=" + foodId + ", userId=" + userId + ", comment=" + comment + ", description="
				+ description + "]";
	}
	
	
}
