package com.example.worddict;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewWord extends AppCompatActivity {

    private EditText text;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        text = findViewById(R.id.editText);
        button = findViewById(R.id.addNewWord);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();

                if (TextUtils.isEmpty(text.getText())){
                    setResult(RESULT_CANCELED, intent);
                }else{
                    bundle.putString("word", text.getText().toString());
                    intent.putExtras(bundle);

                    setResult(RESULT_OK, intent);


                }
                finish();
            }
        });
    }
}