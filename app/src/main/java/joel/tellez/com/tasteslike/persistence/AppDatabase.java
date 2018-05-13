package joel.tellez.com.tasteslike.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import joel.tellez.com.tasteslike.models.Review;

@Database(entities = {Review.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract ReviewDao reviewDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "review-database")
                    .build();
//            INSTANCE.populateInitialData();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public void populateInitialData() {
//        if (reviewDao().count() == 0) {
//            for (int i = 0; i < 10; i++) {
//                reviewDao().insert(new Review("Review " + i));
//            }
//        }
    }
}