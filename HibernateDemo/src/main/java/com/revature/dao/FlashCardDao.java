package com.revature.dao;

import java.util.List;
import com.revature.beans.Flashcard;

public interface FlashCardDao {
	
	List<Flashcard> getFlashcards();
	Flashcard getFlashcardById(int id);
	
}
