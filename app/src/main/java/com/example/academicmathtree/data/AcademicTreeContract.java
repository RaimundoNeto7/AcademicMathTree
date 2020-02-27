package com.example.academicmathtree.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class AcademicTreeContract {

    public static final String CONTENT_AUTHORITY = "com.example.academicmathtree";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_ACADEMIC = "academic";
    public static final class AcademicEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_ACADEMIC)
                .build();

        public static final String TABLE_NAME = "academic";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_UNIVERSITY = "university";
        public static final String COLUMN_EXPERTISE = "expertise";
        public static final String COLUMN_JOB = "job";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_ROOT = "root";
    }

    public static final String PATH_GUIDE = "guide";
    public static final class GuideEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_GUIDE)
                .build();

        public static final String TABLE_NAME = "guide";
        public static final String COLUMN_ID_TEARCHER = "idteacher";
        public static final String COLUMN_ID_STUDENT = "idstudent";
    }
}
