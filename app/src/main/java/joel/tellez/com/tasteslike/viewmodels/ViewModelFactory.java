package joel.tellez.com.tasteslike.viewmodels;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import joel.tellez.com.tasteslike.persistence.ReviewDataSource;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final ReviewDataSource reviewDataSource;

    public ViewModelFactory(ReviewDataSource reviewDataSource) {
        this.reviewDataSource = reviewDataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ReviewCreationViewModel.class)) {
            return (T) new ReviewCreationViewModel(reviewDataSource);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
