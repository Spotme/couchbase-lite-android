package com.couchbase.spotme;

import com.couchbase.lite.spotme.DbCorruptionHandler;

import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.database.SQLiteDatabase;

/**
 * Handler, which does not remove corrupted dbs, but log an error,
 *  unlike {@link net.sqlcipher.DefaultDatabaseErrorHandler}
 */
public class DbCorruptionAdapterHandler implements DatabaseErrorHandler {
    private final DbCorruptionHandler<SQLiteDatabase> adaptee;

    public DbCorruptionAdapterHandler(DbCorruptionHandler<SQLiteDatabase> adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void onCorruption(SQLiteDatabase sqLiteDatabase) {
        adaptee.onCorruption(sqLiteDatabase);
    }
}
