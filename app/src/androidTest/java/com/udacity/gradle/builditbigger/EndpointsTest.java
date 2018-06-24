package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;

import java.util.concurrent.TimeUnit;

public class EndpointsTest extends AndroidTestCase {

    private static final String FAIL = "test failed";
    private static final String TIMEOUT = "connect timed out";

    private Context context;

    public void testJokeDownload() {
        try {
            EndpointsAsyncTask task = new EndpointsAsyncTask();
            task.execute();

            String joke = task.get(30, TimeUnit.SECONDS);

            assertNotNull(joke);
            assertTrue(!joke.equals(TIMEOUT) || joke.length() == 0);

        } catch (Exception e) {
            fail(FAIL);
        }

    }
}