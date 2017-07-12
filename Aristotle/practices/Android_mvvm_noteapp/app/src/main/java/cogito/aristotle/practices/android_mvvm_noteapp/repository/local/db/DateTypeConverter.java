package cogito.aristotle.practices.android_mvvm_noteapp.repository.local.db;

import android.arch.persistence.room.TypeConverter;

import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

/**
 * Created by cogito88 on 7/12/17.
 */

public class DateTypeConverter {

    @TypeConverter
    public static LocalDateTime toDate(Long timestamp) {
        return timestamp == null ? null : LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.ofTotalSeconds(0));
    }

    @TypeConverter
    public static Long toTimestamp(LocalDateTime date) {
        return date == null ? null : date.toInstant(ZoneOffset.ofTotalSeconds(0)).getEpochSecond();
    }



}
