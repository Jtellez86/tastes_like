package joel.tellez.com.tasteslike.models;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.joda.time.DateTime;

import static org.joda.time.DateTimeZone.UTC;

@Entity(tableName = "review")
public class Review {

    @PrimaryKey(autoGenerate = true) private int uid;
    @ColumnInfo(name = "title") String title;
//    @ColumnInfo(name = "date") DateTime createdAt;

    public Review(String title) {
        this.title = title;
//        createdAt = DateTime.now(UTC);
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public DateTime getCreatedAt() {
//        return createdAt;
//    }

//    public void setCreatedAt(DateTime createdAt) {
//        this.createdAt = createdAt;
//    }
}