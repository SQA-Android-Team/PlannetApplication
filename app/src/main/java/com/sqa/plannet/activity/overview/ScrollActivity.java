package com.sqa.plannet.activity.overview;

import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;

import butterknife.BindView;

public class ScrollActivity extends OverviewMainActivity{
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.header_img)
    ImageView headerImage;
    @BindView(R.id.body)
    LinearLayout body;
    @BindView(R.id.overview_header)
    TextView heading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* intially hide the view */
        heading.setAlpha(0f);
        /* set the scroll change listener on scrollview */
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                /* get the maximum height which we have scroll before performing any action */
                int maxDistance = headerImage.getHeight();
                /* how much we have scrolled */
                int movement = scrollView.getScrollY();
                /*finally calculate the alpha factor and set on the view */
                float alphaFactor = ((movement * 1.0f) / (maxDistance - heading.getHeight()));
                if (movement >= 0 && movement <= maxDistance) {
                    /*for image parallax with scroll */
                    headerImage.setTranslationY(-movement / 2);
                    /* set visibility */
                    heading.setAlpha(alphaFactor);
                }
            }
        });
    }

}