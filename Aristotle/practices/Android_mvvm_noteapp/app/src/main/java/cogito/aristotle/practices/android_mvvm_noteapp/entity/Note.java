package cogito.aristotle.practices.android_mvvm_noteapp.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.threeten.bp.LocalDateTime;
import org.threeten.bp.temporal.ChronoUnit;

import static cogito.aristotle.practices.android_mvvm_noteapp.entity.Note.TABLE_NAME;

/**
 * Created by cogito88 on 7/12/17.
 */

@Entity(tableName = TABLE_NAME)
public class Note {
    public static final String TABLE_NAME = "note";
    public static final String DATE_FIELD = "date";

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String content;
    @ColumnInfo(name = DATE_FIELD)
    private LocalDateTime date;

    public Note(int id, String title, String content, LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public long getDaysUntil() {
        return ChronoUnit.DAYS.between(LocalDateTime.now(), getDate());
    }
}
