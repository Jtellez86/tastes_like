package joel.tellez.com.tasteslike.injection;


import android.content.Context;

import joel.tellez.com.tasteslike.persistence.AppDatabase;
import joel.tellez.com.tasteslike.persistence.LocalReviewDataSource;
import joel.tellez.com.tasteslike.persistence.ReviewDataSource;
import joel.tellez.com.tasteslike.viewmodels.ViewModelFactory;

public class Injection {
    public static ReviewDataSource provideReviewDataSource(Context context) {
        AppDatabase database = AppDatabase.getAppDatabase(context);
        return new LocalReviewDataSource(database.reviewDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        ReviewDataSource dataSource = provideReviewDataSource(context);
        return new ViewModelFactory(dataSource);
    }
}
