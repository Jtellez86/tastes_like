package joel.tellez.com.tasteslike.viewmodels;


import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import joel.tellez.com.tasteslike.models.Review;
import joel.tellez.com.tasteslike.persistence.ReviewDataSource;

public class ReviewCreationViewModel extends ViewModel {

    private final ReviewDataSource dataSource;

    public ReviewCreationViewModel(ReviewDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Flowable<List<Review>> getReviews() {
        return dataSource.getAll();
    }

    public Single<Long> addReview(final Review review) {
        return Single.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return dataSource.insertReview(review);
            }
        });
    }

//    public Completable deleteAllReviews() {
//        return dataSource.deleteAllReviews();
//    }

    public Single<Integer> getReviewCount() { return dataSource.getCount(); }
}
