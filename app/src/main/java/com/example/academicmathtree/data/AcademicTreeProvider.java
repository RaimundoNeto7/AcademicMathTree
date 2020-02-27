package com.example.academicmathtree.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AcademicTreeProvider extends ContentProvider {

    public static final int CODE_ACADEMIC = 100;
    public static final int CODE_ACADEMIC_BY_ID = 101;

    private static final UriMatcher matcher = buildUriMatcher();
    private AcademicTreeDbHelper dbHelper;

    private static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = AcademicTreeContract.CONTENT_AUTHORITY;

        matcher.addURI(authority, AcademicTreeContract.PATH_ACADEMIC, CODE_ACADEMIC);
        matcher.addURI(authority, AcademicTreeContract.PATH_ACADEMIC + "/#", CODE_ACADEMIC_BY_ID);
        
        return matcher;
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
