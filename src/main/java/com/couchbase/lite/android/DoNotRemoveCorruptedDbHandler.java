package com.couchbase.lite.android;

import android.util.Log;

import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.database.SQLiteDatabase;

/**
 * Handler, which does not remove corrupted dbs, but log an error,
 *  unlike {@link net.sqlcipher.DefaultDatabaseErrorHandler}
 */
class DoNotRemoveCorruptedDbHandler implements DatabaseErrorHandler {
    private static final String TAG = DoNotRemoveCorruptedDbHandler.class.getSimpleName();

    @Override
    public void onCorruption(SQLiteDatabase sqLiteDatabase) {
        Log.e(TAG, "Corruption reported by sqlite on database: " + sqLiteDatabase.getPath());
        if(sqLiteDatabase.isOpen()) {
            Log.e(TAG, "Database object for corrupted database is already open, closing");

            try {
                sqLiteDatabase.close();
            } catch (Exception var3) {
                Log.e(TAG, "Exception closing Database object for corrupted database, ignored", var3);
            }
        }
        //do not delete database file intentionally
    }
}
