package com.example.academicmathtree.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

import static com.example.academicmathtree.data.AcademicTreeContract.*;

public class AcademicTreeProvider extends ContentProvider {

    public static final int CODE_ACADEMIC = 100;
    public static final int CODE_ACADEMIC_BY_ID = 101;
    public static final int CODE_ACADEMIC_ROOTS = 102;
    public static final int CODE_ACADEMIC_BY_ROOT = 103;
    public static final int CODE_GUIDE = 200;
    public static final int CODE_GUIDE_BY_TEACHER = 201;

    private static final UriMatcher matcher = buildUriMatcher();
    private AcademicTreeDbHelper dbHelper;

    private static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = CONTENT_AUTHORITY;

        matcher.addURI(authority, PATH_ACADEMIC, CODE_ACADEMIC);
        matcher.addURI(authority, PATH_ACADEMIC + "/#", CODE_ACADEMIC_BY_ID);
        matcher.addURI(authority, PATH_ACADEMIC + "/" + AcademicEntry.COLUMN_ID_ROOT, CODE_ACADEMIC_ROOTS);
        matcher.addURI(authority, PATH_ACADEMIC + "/" + AcademicEntry.COLUMN_ID_ROOT + "/#", CODE_ACADEMIC_BY_ROOT);
        matcher.addURI(authority, PATH_GUIDE, CODE_GUIDE);
        matcher.addURI(authority, PATH_GUIDE + "/" + GuideEntry.COLUMN_ID_TEARCHER + "/#", CODE_GUIDE_BY_TEACHER);

        return matcher;
    }

    @Override
    public boolean onCreate() {
        dbHelper = new AcademicTreeDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor;
        switch (matcher.match(uri)) {
            case CODE_ACADEMIC: {
                cursor = dbHelper.getReadableDatabase().query(
                    AcademicEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case CODE_ACADEMIC_BY_ID: {

                String id = uri.getLastPathSegment();

                cursor = dbHelper.getReadableDatabase().query(
                        AcademicEntry.TABLE_NAME,
                        projection,
                        AcademicEntry._ID + " = ?",
                         new String[] {id},
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case CODE_ACADEMIC_ROOTS: {
                cursor = dbHelper.getReadableDatabase().query(
                        AcademicEntry.TABLE_NAME,
                        projection,
                        AcademicEntry._ID + " = " + AcademicEntry.COLUMN_ID_ROOT,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case CODE_ACADEMIC_BY_ROOT: {

                String id = uri.getLastPathSegment();

                cursor = dbHelper.getReadableDatabase().query(
                        AcademicEntry.TABLE_NAME,
                        projection,
                        AcademicEntry.COLUMN_ID_ROOT + " = ? ",
                        new String[] {id},
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case CODE_GUIDE: {
                cursor = dbHelper.getReadableDatabase().query(
                        GuideEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case CODE_GUIDE_BY_TEACHER: {

                String id = uri.getLastPathSegment();

                cursor = dbHelper.getReadableDatabase().query(
                        GuideEntry.TABLE_NAME,
                        projection,
                        GuideEntry.COLUMN_ID_TEARCHER + " = ?",
                        new String[] {id},
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        cursor.setNotificationUri(Objects.requireNonNull(getContext()).getContentResolver(), uri);
        return cursor;
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        final SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch (matcher.match(uri)) {
            case CODE_ACADEMIC: {
                db.beginTransaction();
                int rowsInserted = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(AcademicEntry.TABLE_NAME, null, value);
                        if(_id != -1){
                            rowsInserted++;
                        }
                    }
                    db.setTransactionSuccessful();
                }
                finally {
                    db.endTransaction();
                }
                if(rowsInserted > 0) {
                    Objects.requireNonNull(getContext()).getContentResolver().notifyChange(uri, null);
                }
                return rowsInserted;
            }
            case CODE_GUIDE: {
                db.beginTransaction();
                int rowsInserted = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(GuideEntry.TABLE_NAME, null, value);
                        if(_id != -1){
                            rowsInserted++;
                        }
                    }
                    db.setTransactionSuccessful();
                }
                finally {
                    db.endTransaction();
                }
                if(rowsInserted > 0) {
                    Objects.requireNonNull(getContext()).getContentResolver().notifyChange(uri, null);
                }
                return rowsInserted;
            }
            default:
                return super.bulkInsert(uri, values);
        }
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
