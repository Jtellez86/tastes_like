package joel.tellez.com.tasteslike.persistence;


import android.arch.persistence.room.TypeConverter;

import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.List;

public class Converters {
    @TypeConverter
    public static DateTime fromTimestamp(Long value) {
        return value == null ? null : new DateTime(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(DateTime date) {
        return date == null ? null : date.getMillis();
    }

    @TypeConverter
    public Reviews storedStringToReview(String value) {
        List<String> langs = Arrays.asList(value.split("\\s*,\\s*"));
        return new Reviews(langs);
    }

    @TypeConverter
    public String reviewsToStoredString(Reviews reviews) {
        String value = "";

        for (String review :reviews.getReviews())
            value += review + ",";

        return value;
    }

    public class Reviews {
        private List<String> reviews;

        public Reviews(List<String> reviews) {
            this.reviews = reviews;
        }

        public List<String> getReviews() {
            return reviews;
        }

        public void setCountryLangs(List<String> reviews) {
            this.reviews = reviews;
        }
    }

}
