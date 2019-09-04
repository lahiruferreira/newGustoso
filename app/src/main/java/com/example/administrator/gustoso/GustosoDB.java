package com.example.administrator.gustoso;

/**
 * Created by Administrator on 9/1/2019.
 */

public class GustosoDB {
    public static abstract class userReview
    {
        public static final String FULL_NAME = "fullName";
        public static final String CONTACT_NO = "contactNo";
        public static final String EMAIL_ADDRESS = "emailAddress";
        public static final String COUNTRY = "country";
        public static final String REVIEW = "review";
        public static final String REVIEW_RATE = "reviewRate";
        public static final String TABLE_NAME = "UserReviews";
    }

    public static abstract class userContact
    {
        public static final String FULL_NAME = "fullName";
        public static final String CONTACT_NO = "contactNo";
        public static final String EMAIL_ADDRESS = "emailAddress";
        public static final String COUNTRY = "country";
        public static final String QUESTION= "question";
        public static final String TABLE_NAME = "UserContact";
    }
}
