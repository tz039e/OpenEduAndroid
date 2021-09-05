package com.wudaokou.easylearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.wudaokou.easylearn.constant.SubjectMapChineseToEnglish;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TestActivity extends AppCompatActivity {

    TextInputLayout chooseSubjectLayout;
    AutoCompleteTextView chooseSubject;
    LinearLayout keywordLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        chooseSubject = findViewById(R.id.chooseSubject);
        keywordLayout = findViewById(R.id.keyword_layout);
        chooseSubjectLayout = findViewById(R.id.chooseSubjectLayout);

        // 选择学科
        String[] subjects = getResources().getStringArray(R.array.subjects);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this, R.layout.dropdown_subject_item, subjects);
        chooseSubject.setAdapter(arrayAdapter);

        chooseSubject.setOnItemClickListener((parent, view, position, id) -> chooseSubjectLayout.setError(null));

        increaseKeywordLayout();
    }

    public void getBack(View view) {
        finish();
    }

    public void increaseKeywordLayout(View view) {
        increaseKeywordLayout().requestFocus();
    }

    public EditText increaseKeywordLayout() {
        LayoutInflater.from(this).inflate(R.layout.test_keyword_layout, keywordLayout);
        final int newIndex = keywordLayout.getChildCount() - 1;
        LinearLayout newLayout = (LinearLayout) keywordLayout.getChildAt(newIndex);

        TextInputLayout newInputLayout = (TextInputLayout) newLayout.getChildAt(0);
        newInputLayout.setHint( "知识点" + keywordLayout.getChildCount() );

        Button newButton = (Button) newLayout.getChildAt(1);
        newButton.setOnClickListener(this::deleteRowOnClick);

        EditText newEditText = newInputLayout.getEditText();
        assert newEditText != null;
        newEditText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            public void afterTextChanged(Editable s) {
                newInputLayout.setError(null);
            }
        });
        return newEditText;
    }

    private void deleteRowOnClick(View v) {
        if(keywordLayout.getChildCount() == 1){
            Toast.makeText(this, "知识点不得少于1项", Toast.LENGTH_SHORT).show();
            return;
        }
        keywordLayout.removeViewAt(keywordLayout.indexOfChild((LinearLayout) v.getParent()));
        for(int i = 0; i < keywordLayout.getChildCount(); i++){
            LinearLayout iLayout = (LinearLayout) keywordLayout.getChildAt(i);
            TextInputLayout iInputLayout = (TextInputLayout) iLayout.getChildAt(0);
            iInputLayout.setHint( "知识点" + (i+1) );
        }
    }


    public void generate(View view) {
        boolean valid = true;
        String subject = chooseSubject.getText().toString();
        String subjectInEnglish = SubjectMapChineseToEnglish.getMap().get(subject);
        if(subject.equals("")){
            chooseSubjectLayout.setError("请选择学科");
            valid = false;
        }
        List<String> labels = new ArrayList<>();
        for(int i = 0; i < keywordLayout.getChildCount(); i++){
            LinearLayout iLayout = (LinearLayout) keywordLayout.getChildAt(i);
            TextInputLayout iInputLayout = (TextInputLayout) iLayout.getChildAt(0);
            EditText iEditText = iInputLayout.getEditText();
            assert iEditText != null;
            String text = iEditText.getText().toString();
            if(text.isEmpty()){
                iInputLayout.setError("知识点为空");
                valid = false;
            }
            labels.add(text);
        }
        if(!valid) return;

        // TODO

    }
}