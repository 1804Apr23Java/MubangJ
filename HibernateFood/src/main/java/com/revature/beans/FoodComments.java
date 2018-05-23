package com.revature.beans;

import javax.persistence.*;

@Entity
@Table(name="Comments")

public class FoodComments {
	
	public FoodComments(int commentId, int userId, String comment) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.comment = comment;
	}
	
	public FoodComments(int userId,String comment) {
		super();
		this.userId = userId;
		this.comment = comment;
	}
	
	public FoodComments() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="commentSequence")
	@SequenceGenerator(allocationSize=1,name="commentSequence",sequenceName="SQ_COMMENT_PK")
	@Column(name="COMMENT_ID")
	private int commentId;
	
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="COMMENT")
	private String comment;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

	@Override
	public String toString() {
		return "FoodComments [commentId=" + commentId + ", userId=" + userId + ", comment=" + comment + "]";
	}	

}
