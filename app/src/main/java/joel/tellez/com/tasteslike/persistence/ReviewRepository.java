package joel.tellez.com.tasteslike.persistence;


import android.content.Context;

public class ReviewRepository {
    public static AppDatabase getDatabase(Context context) {
        return AppDatabase.getAppDatabase(context);
    }
}
