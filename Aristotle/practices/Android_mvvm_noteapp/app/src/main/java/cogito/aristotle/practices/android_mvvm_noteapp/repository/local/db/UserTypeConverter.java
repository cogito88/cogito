package cogito.aristotle.practices.android_mvvm_noteapp.repository.local.db;

import android.arch.persistence.room.TypeConverter;
import cogito.aristotle.practices.android_mvvm_noteapp.entity.User;

/**
 * Created by cogito88 on 7/17/17.
 */

public class UserTypeConverter {

    @TypeConverter
    public static User.USER_TYPE toUserType(int type) {
        return User.convertIntToType(type);
    }

    @TypeConverter
    public static int toInteger(User.USER_TYPE userType) {
        return userType.getCode();
    }
}
