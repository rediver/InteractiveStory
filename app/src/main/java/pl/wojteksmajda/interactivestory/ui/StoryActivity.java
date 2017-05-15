package pl.wojteksmajda.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pl.wojteksmajda.interactivestory.R;

public class StoryActivity extends AppCompatActivity {

    private static final Object TAG = StoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));

        if (name == null || name.isEmpty()) {
            name = "Friend";
        }

        //LOG.v(TAG, name);


    }
}
