package com.example.worddict;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private LayoutInflater inflater;
    private List<Word> wordsList;


    public WordListAdapter(@NonNull Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.word_list, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if (wordsList != null) {
            Word current = wordsList.get(position);
            holder.textView.setText(current.getWord());
        } else {
            holder.textView.setText("No Data");
        }
    }

    public void setWordsList(List<Word> wordsList){
        this.wordsList = wordsList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (wordsList != null)
            return wordsList.size();
        else
            return 0;
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
