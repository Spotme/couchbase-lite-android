package com.couchbase.touchdb;

import android.os.Build;

import net.sqlcipher.database.SQLiteDatabase;

public class RevCollator {
    public static void register(SQLiteDatabase database, String libPath) {
        nativeRegister(database, Build.VERSION.SDK_INT, libPath);
    }

    private static native void nativeRegister(SQLiteDatabase database, int sdkVersion, String libPath);

    // FIXME: only public for now until moved in to same package
    public static native int testCollateRevIds(String string1, String string2);

    static {
        System.loadLibrary("com_couchbase_touchdb_RevCollator");
    }
}
