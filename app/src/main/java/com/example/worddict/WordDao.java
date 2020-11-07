package com.example.worddict;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insertWord(Word word);

    @Query("Delete from word_table")
    void deleteAll();

    @Query("Select * from word_table")
    LiveData<List<Word>> getAll();
}
