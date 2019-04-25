package com.example.engtonepdictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView Lview;



    public static final String meaning[] = {
            "k cha?", "What's up?",
            "Thik cha?", "Is it ok?",
            "Yeta Aaunus", "Come Here",
            "Uta jau", "Go There"
    };
    private Map<String, String> dictionary;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView Lview = findViewById(R.id.Lview);

        dictionary = new HashMap<>();
        for (int i = 0; i < meaning.length; i += 2) {
            dictionary.put(meaning[i], meaning[i + 1]);
        }
        ArrayAdapter meaningAdapter = new ArrayAdapter(
                this, android.R.layout.simple_list_item_1,
                new ArrayList(dictionary.keySet())
        );
        Lview.setAdapter(meaningAdapter);
        Lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String word = parent.getItemAtPosition(position).toString();
                String mean = dictionary.get(word);
                Intent intent = new Intent(MainActivity.this, another.class);
                intent.putExtra("meaning", mean);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),mean.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
