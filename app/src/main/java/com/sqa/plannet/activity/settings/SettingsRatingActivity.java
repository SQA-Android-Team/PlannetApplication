package com.sqa.plannet.activity.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;

public class SettingsRatingActivity extends AppCompatActivity {
    ImageButton backBtn;
    private RatingBar ratingBar;
    private Button ratingButton;
    private Button ratingScoreButton;
    private EditText editTxtRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.settings_rating);


        addListenerOnButtonClick();

        // add event listener for backBtn
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void addListenerOnButtonClick() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingButton = (Button) findViewById(R.id.ratingBtn);
        ratingScoreButton = (Button) findViewById(R.id.ratingScoreBtn);
        editTxtRating = (EditText) findViewById(R.id.editTxtRating);

        //Change the color of the filled stars programmatically
//        Drawable drawableReview = ratingBar.getProgressDrawable();
//        drawableReview.setColorFilter(Color.parseColor("#FFD850"),
//                PorterDuff.Mode.SRC_ATOP);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingScoreButton.setText(String.valueOf(rating) + "/5");
            }
        });
        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{"thanhcongvnqn1310@gamil.com"});
                it.putExtra(Intent.EXTRA_SUBJECT, "Rate App");
                it.putExtra(Intent.EXTRA_TEXT, "Score: " + ratingBar.getRating() + "/5" + "\n" +
                        "Comment: " + editTxtRating.getText()
                );
                it.setType("message/rfc822"); //it.setType("plain/text");
                startActivity(Intent.createChooser(it, "Choose Mail App"));
            }
        });
    }
}
