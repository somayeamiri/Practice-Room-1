package com.example.roomjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText word;
Button btn;
TextView show;
Dic dic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        word=findViewById(R.id.edt_word);
        btn=findViewById(R.id.btn);
        show=findViewById(R.id.edt_show);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryToDatabase();

                if (dic!= null){

                    show.setText(dic.translate);
//                    Toast.makeText(MainActivity.this, dic.translate, Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this, "not found", Toast.LENGTH_SHORT).show();

            }
        });


        //Query to add to database
//        Dic dic = new Dic();
//        dic.origin="hello";
//        dic.translate="سلام";
//        WordRoomDatabase.getDatabase(this).wordDao().insertDic(dic);


        //Query for fetch a list from database
//        List<Dic> result= WordRoomDatabase.getDatabase(this).wordDao().GetAllWord("water");
//        Toast.makeText(this, result.size()+"", Toast.LENGTH_SHORT).show();

        //Another method for getting word which include word"water"
//        List<Dic> result= WordRoomDatabase.getDatabase(this).wordDao().GetAllWord2("water");
//
//        for (int i = 0; i <result.size() ; i++) {
//
//            Log.i("tag",result.get(i).origin);
//
//        }


        //Query to delete from database
//        WordRoomDatabase.getDatabase(this).wordDao().DeleteWord("acapella");


    }

    private void queryToDatabase (){
        dic = WordRoomDatabase.getDatabase(this).wordDao().GetWord(word.getText().toString());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        WordRoomDatabase.closeDb();
    }
}