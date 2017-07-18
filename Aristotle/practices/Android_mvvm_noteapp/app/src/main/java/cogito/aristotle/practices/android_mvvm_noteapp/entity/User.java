package cogito.aristotle.practices.android_mvvm_noteapp.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import static cogito.aristotle.practices.android_mvvm_noteapp.entity.User.TABLE_NAME;
import static cogito.aristotle.practices.android_mvvm_noteapp.entity.User.USER_TYPE.FRIEND;
import static cogito.aristotle.practices.android_mvvm_noteapp.entity.User.USER_TYPE.ME;

/**
 * Created by cogito88 on 7/17/17.
 */

@Entity(tableName = TABLE_NAME)
public class User {
    public static final String TABLE_NAME = "user";
    public static final String TYPE_FIELD = "type";

    @PrimaryKey
    private int id;
    private String name;
    private String email;
    @ColumnInfo(name = TYPE_FIELD)
    private USER_TYPE type;

    public User(int id, String name, String email, USER_TYPE type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public USER_TYPE getType() {
        return  type;
    }

    public static USER_TYPE convertIntToType(int intType) {
        switch (intType) {
            case USER_TYPE.USER_TYPE_ME:
                return ME;
            case USER_TYPE.USER_TYPE_FRIEND:
                return FRIEND;
            case USER_TYPE.USER_TYPE_STRANGER:
            default:
                return USER_TYPE.STRANGER;
        }
    }

    public static enum USER_TYPE {
        ME(USER_TYPE.USER_TYPE_ME),
        FRIEND(USER_TYPE.USER_TYPE_FRIEND),
        STRANGER(USER_TYPE.USER_TYPE_STRANGER);

        private int code;

        USER_TYPE(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }

        public static final int USER_TYPE_ME = 0;
        public static final int USER_TYPE_FRIEND = 1;
        public static final int USER_TYPE_STRANGER = 2;
    }
}
