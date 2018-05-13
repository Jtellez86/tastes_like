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

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import joel.tellez.com.tasteslike.R;
import joel.tellez.com.tasteslike.databinding.ActivityReviewCreationBinding;
import joel.tellez.com.tasteslike.injection.Injection;
import joel.tellez.com.tasteslike.models.Review;
import joel.tellez.com.tasteslike.viewmodels.ReviewCreationViewModel;
import joel.tellez.com.tasteslike.viewmodels.ViewModelFactory;

public class ReviewCreationActivity extends AppCompatActivity {

    ActivityReviewCreationBinding binding;

    private ViewModelFactory viewModelFactory;
    private ReviewCreationViewModel viewModel;

    private CompositeDisposable compositeDisposable;

    public static Intent newIntent(Context context) {
        return new Intent(context, ReviewCreationActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        compositeDisposable = new CompositeDisposable();

        viewModelFactory = Injection.provideViewModelFactory(this);
        viewModel = viewModelFactory.create(ReviewCreationViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_review_creation);
    }

    @Override
    protected void onStart() {
        super.onStart();

        binding.createReviewButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                compositeDisposable.add(viewModel.addReview(new Review("My First Review"))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Long>() {
                            @Override
                            public void accept(Long id) throws Exception {
                                Toast.makeText(getApplicationContext(), String.format("Review with id %d, has been saved", id), Toast.LENGTH_LONG).show();
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Toast.makeText(getApplicationContext(), String.format("Oops, your review wasn't saved"), Toast.LENGTH_LONG).show();
                            }
                        }));
            }
        });

        binding.getReviewCountButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                compositeDisposable.add(viewModel.getReviewCount()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Integer>() {
                            @Override
                            public void accept(Integer reviewCount) throws Exception {
                                Toast.makeText(getApplicationContext(), String.format("There are %d reviews", reviewCount), Toast.LENGTH_LONG).show();
                            }
                        }));
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }
}
