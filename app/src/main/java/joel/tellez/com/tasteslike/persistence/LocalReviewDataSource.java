package joel.tellez.com.tasteslike.persistence;


import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import joel.tellez.com.tasteslike.models.Review;

public class LocalReviewDataSource implements ReviewDataSource {

    private final ReviewDao reviewDao;

    public LocalReviewDataSource(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    public Flowable<List<Review>> getAll() {
        return reviewDao.getAll();
    }

    @Override
    public Single<Integer> getCount() { return reviewDao.count(); }

    @Override
    public Long insertReview(Review review) { return reviewDao.insert(review); }

    @Override
    public void deleteAllReviews() { reviewDao.deleteAllReviews(); }
}
