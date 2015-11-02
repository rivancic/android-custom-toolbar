package com.rivancic.toolbar;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private static Logger LOG = Logger.getLogger(MainActivity.class.getName());
    protected ActionBar actionBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
    }

    /**
     * Initialize the toolbar with the default options.
     * The activity has to have the view with id toolbar which is type of android.support.v7.widget.Toolbar
     */
    protected void setToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        this.actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(ContextCompat.getDrawable(this, R.drawable.back_arrow_white));
            actionBar.setDisplayShowHomeEnabled(true); // show or hide the default home button
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowCustomEnabled(true); // enable overriding the default toolbar layout
            actionBar.setDisplayShowTitleEnabled(false); // disable the default title element here (for centered title)
            setBackTextClickable();
            setBackText("Back");
            setTitle(getTitle());
        }
    }

    /**
     * Set custom back button text.
     *
     * @param backText value to be set.
     */
    public void setBackText(CharSequence backText) {

        TextView backTv = (TextView) findViewById(R.id.toolbar_back);
        if (backTv != null) {
            backTv.setText(backText);
        }
    }

    /**
     * If the back text is clicked then it should react as back button.
     */
    private void setBackTextClickable() {

        TextView backView = (TextView) findViewById(R.id.toolbar_back);
        if (backView != null) {
            backView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    try {
                        NavUtils.navigateUpFromSameTask(MainActivity.this);
                    } catch (IllegalArgumentException iae) {
                        LOG.log(Level.SEVERE, "You should specify parent activity", iae);
                    }
                }
            });
        }
    }

    /**
     * Set custom title for toolbar.
     *
     * @param title value to be set.
     */
    @Override
    public void setTitle(CharSequence title) {

        TextView titleView = (TextView) findViewById(R.id.toolbar_title);
        if (titleView != null) {
            titleView.setText(title);
        }
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
}
