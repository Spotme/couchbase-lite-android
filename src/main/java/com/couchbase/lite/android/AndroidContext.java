package com.couchbase.lite.android;

import com.couchbase.lite.Context;

import net.sqlcipher.database.SQLiteDatabase;

import java.io.File;

import dalvik.system.PathClassLoader;

public class AndroidContext implements Context {

    private android.content.Context wrappedContext;

    public AndroidContext(android.content.Context wrappedContext) {
        this.wrappedContext = wrappedContext;
        loadDatabaseLibraries();
    }

    @Override
    public File getFilesDir() {
        return wrappedContext.getFilesDir();
    }

	@Override
	public String getLibraryDir(String name) {
		try {
			return ((PathClassLoader) wrappedContext.getClassLoader()).findLibrary(name);
		} catch (Exception e) {
			return null;
		}
	}

	public android.content.Context getWrappedContext() {
        return wrappedContext;
    }

    public void loadDatabaseLibraries() {
        SQLiteDatabase.loadLibs(wrappedContext);
    }

}
