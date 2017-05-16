package pl.wojteksmajda.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pl.wojteksmajda.interactivestory.R;
import pl.wojteksmajda.interactivestory.model.Page;
import pl.wojteksmajda.interactivestory.model.Story;

import static android.R.attr.name;

public class StoryActivity extends AppCompatActivity {

    private static final Object TAG = StoryActivity.class.getSimpleName();

    private Story story;

    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;

    //private Page[] pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_story);


        storyImageView = (ImageView) findViewById(R.id.storyImageView);
        storyTextView = (TextView)findViewById(R.id.StoryTextView);
        choice1Button = (Button)findViewById(R.id.Choice1Button);
        choice2Button = (Button)findViewById(R.id.Choice2Button);

        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));

        if (name == null || name.isEmpty()) {
            name = "Friend";
        }

        //LOG.v(TAG, name);

        //pages = new Page[7];

        story = new Story();
        loadPage(0);

    }

    private void loadPage(int pageNumber) {

        final Page page = story.getPage(pageNumber);

        Drawable image = ContextCompat.getDrawable(this, page.getImageId());
        storyImageView.setImageDrawable(image);

        String pageText = getString(page.getTextId());



        // Add name if placeholder included
        // w pierwszym w2jidoku gdzie zmienia sie parametr name 

        pageText = String.format(pageText, name);
        storyTextView.setText(pageText);


//      jesli ostatnia strona nie ma opcji -> warunek
        if (page.isFinalPage()) {

            choice1Button.setVisibility(View.VISIBLE);
            choice1Button.setVisibility(View.INVISIBLE);

            choice2Button.setVisibility(View.VISIBLE);
            choice2Button.setText(R.string.play_again);
//       co sie dzieje z ostatnim przyciskiem
            choice2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // finish();
                    loadPage(0);
                }
            });

        } else {

            loadButtons(page);

        }

    }

//   listenbery dla kazdego z przyciskow

    private void loadButtons(final Page page) {
        choice1Button.setText(page.getChoice1().getTextid());
        choice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = page.getChoice1().getNextPage();
                loadPage(nextPage);
            }
        });


        choice2Button.setText(page.getChoice2().getTextid());
        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = page.getChoice2().getNextPage();
                loadPage(nextPage);
            }
        });
    }
}







