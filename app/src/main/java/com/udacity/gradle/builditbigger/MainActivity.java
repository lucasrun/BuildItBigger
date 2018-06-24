package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.androiddisplayerlib.DisplayLibrary;
import com.example.android.javajokeslib.JokesLibrary;


public class MainActivity extends AppCompatActivity {
    JokesLibrary jokesLibrary = new JokesLibrary();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        // toast
//        Toast.makeText(this, jokesLibrary.tellJoke(), Toast.LENGTH_SHORT).show();

        // passing to intent extra
//        Intent intent = new Intent(this, DisplayLibrary.class);
//        intent.putExtra(getString(R.string.JOKE), jokesLibrary.tellJoke());
//        startActivity(intent);

        // using gce
//        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, getString(R.string.JOKE)));
        new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute (String result) {

                Intent intent = new Intent(getApplicationContext(), DisplayLibrary.class);
                intent.putExtra(getString(R.string.JOKE), result);
                startActivity(intent);
            }
        }.execute();
    }

}