package com.example.diablowiki;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
//THIS ACTIVITY IS FOR ABOUT THE GAME ACTIVITY
public class FirstActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_first);

        getIntent();

        //Setting the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Removing disabling the title from the toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        toolbar.setSubtitle("");

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        /*
         * This class provides a handy way to tie together the functionality of DrawerLayout and the framework ActionBar
         * to implement the recommended design for navigation drawers.
         * The given Activity will be linked to the specified DrawerLayout and the Toolbar's navigation icon will be set to a custom drawable.
         * Using this constructor will set Toolbar's navigation click listener to toggle the drawer when it is clicked.
         * String resources must be provided to describe the open/close drawer actions for accessibility services.
         */
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        /* Listener for the drawer. Drawer is given toggle as listener
         * ActionBarDrawerToggle can be used directly as a DrawerLayout.DrawerListene
         */
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        //This handles the actions of the drawer open/close
        toggle.syncState();
        //Set custom logo for toolbar button for drawer
        toolbar.setNavigationIcon(R.drawable.ic_toolbar_nav_logo);
        //Set a listener for the navigationView.
        // Because the listener is the activity
        NavigationView navigationView = findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(FirstActivity.this);
        }
        //Justifying textViews text.
        TextView mtextView1 = findViewById(R.id.first_quote);
        TextView mtextView2 = findViewById(R.id.first_introduction);
        TextView mtextView3 = findViewById(R.id.first_introduction2);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mtextView1.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView2.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView3.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }

        //TextView linkIntro = (TextView) findViewById(R.id.first_introduction);
        mtextView2.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * Handles a navigation drawer item click. It detects which item was
     * clicked and displays a toast message showing which item.
     * @param item  Item in the navigation drawer
     * @return      Returns true after closing the nav drawer
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_about_game:
                drawer.closeDrawer(GravityCompat.START);
                return true;
            case R.id.nav_lore:
                drawer.closeDrawer(GravityCompat.START);
                Intent intentSecond = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intentSecond);
                return true;
            case R.id.nav_characters:
                Intent intentThird = new Intent(FirstActivity.this, ThirdActivity.class);
                startActivity(intentThird);
                return true;
            case R.id.nav_items:
                Intent intentFourth = new Intent(FirstActivity.this, FourthActivity.class);
                startActivity(intentFourth);
                return true;
            case R.id.nav_talents:
                drawer.closeDrawer(GravityCompat.START);
                displayToast(getString(R.string.place_holder));
                return true;
            default:
                return false;
        }
    }

    //Displays a message on screen. This is a place holder for actions.
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}