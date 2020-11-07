package com.example.worddict;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository repository;
    private LiveData<List<Word>> words;


    public WordViewModel(@NonNull Application application) {
        super(application);
        repository = new WordRepository(application);
        words = repository.getAll();
    }

    LiveData<List<Word>> getAll(){ return words;}

    public void insert(Word word) {repository.insert(word);}
}
