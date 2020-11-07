package com.example.worddict;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;

import java.util.List;

public class WordRepository {

    private WordDao wordDao;
    private LiveData<List<Word>> words;

    public WordRepository(Application application) {
        WordRoomDatabase database = WordRoomDatabase.getDatabase(application);
        wordDao = database.getWordDao();
        words = wordDao.getAll();
    }

    public LiveData<List<Word>> getAll() {
        return words;
    }

    public void insert (Word word){
        new InsertWordAsyncTask(wordDao).execute(word);
    }

    private static class InsertWordAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao daoTask;

        public InsertWordAsyncTask(WordDao daoTask) {
            this.daoTask = daoTask;
        }

        @Override
        protected Void doInBackground(final Word... word) {
            daoTask.insertWord(word[0]);
            return null;
        }
    }
}
