package joel.tellez.com.tasteslike.persistence;


import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import joel.tellez.com.tasteslike.models.Review;

public interface ReviewDataSource {
    Flowable<List<Review>> getAll();

    Single<Integer> getCount();

    Long insertReview(Review review);

    void deleteAllReviews();

}
