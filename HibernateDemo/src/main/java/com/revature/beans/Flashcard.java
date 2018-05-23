package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="FLASHCARD")
public class Flashcard implements Serializable{

	
	
	

	public Flashcard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flashcard(int id, String question, String answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}

	private static final long serialVersionUID = 1897553647260794654L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="flashcardSequence")
	@SequenceGenerator(allocationSize=1, name="flashcardSequence", sequenceName="SQ_FLASHCARD_PQ")
	@Column(name="FLASHCARD_ID")
	private int id;
	
	@Column()
	private String question;
	private String answer;
	
	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}



	
	
}
