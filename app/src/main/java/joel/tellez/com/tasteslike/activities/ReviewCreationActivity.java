package joel.tellez.com.tasteslike.activities;


import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import joel.tellez.com.tasteslike.R;
import joel.tellez.com.tasteslike.databinding.ActivityReviewCreationBinding;

public class ReviewCreationActivity extends AppCompatActivity{

    ActivityReviewCreationBinding binding;

    public static Intent newIntent(Context context) {
        return new Intent(context, ReviewCreationActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_review_creation);

        binding.createReviewButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "You created a review", Toast.LENGTH_SHORT);
            }
        });
    }
}
