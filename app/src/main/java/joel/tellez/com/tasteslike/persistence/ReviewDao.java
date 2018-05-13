package joel.tellez.com.tasteslike.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import joel.tellez.com.tasteslike.models.Review;

@Dao
public interface ReviewDao {

    @Query("select * from review") Flowable<List<Review>> getAll();

    @Query("SELECT COUNT(*) from review") Single<Integer> count();

    @Insert Long insert(Review review);

    @Query("DELETE FROM review") void deleteAllReviews();
}
