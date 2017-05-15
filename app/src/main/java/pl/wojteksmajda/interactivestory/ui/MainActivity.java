package pl.wojteksmajda.interactivestory.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pl.wojteksmajda.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText nameFiled;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameFiled = (EditText) findViewById(R.id.nameEditText);
        startButton = (Button) findViewById(R.id.StartButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameFiled.getText().toString();
                startStory(name);
            }
        });


    }

    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);
        Resources resources = getResources();
        String key = resources.getString(R.string.key_name);


        // /przekazywana byla tu zmienna "name" w postaci shardcodowanego stringa, w ywpoadku skorzystania z resources wrzucamy to key
        intent.putExtra(key , name);


        startActivity(intent);
    }
}
