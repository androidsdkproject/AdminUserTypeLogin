package com.example.android1.adminusertypelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String usertype;
    TextView textviewusertype;
    DrawerLayout drawer;

    @Deprecated
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        usertype = getIntent().getStringExtra("type");
        textviewusertype = (TextView) findViewById(R.id.textviewusertype);
        textviewusertype.setText("User Type : " + usertype);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        View headerView = navigationView.getHeaderView(0);
        TextView textViewusertype = headerView.findViewById(R.id.textuser);


        if (usertype.equals("user")) {
            textViewusertype.setText("User");
            hideItem(navigationView);
        } else {
            textViewusertype.setText("Admin");
        }


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.ApprovedUser) {
            Snackbar.make(drawer, "Approved User", Snackbar.LENGTH_LONG).show();
        } else if (id == R.id.adduser) {
            Snackbar.make(drawer, "Add user", Snackbar.LENGTH_LONG).show();
        } else if (id == R.id.deleteuser) {
            Snackbar.make(drawer, "Delete User", Snackbar.LENGTH_LONG).show();
        } else if (id == R.id.updateprofile) {
            Snackbar.make(drawer, "Update profile", Snackbar.LENGTH_LONG).show();
        } else if (id == R.id.ShowProfile) {
            Snackbar.make(drawer, "Show Profile", Snackbar.LENGTH_LONG).show();
        } else if (id == R.id.send) {
            Snackbar.make(drawer, "Send", Snackbar.LENGTH_LONG).show();
        } else if (id == R.id.share) {
            Snackbar.make(drawer, "Share", Snackbar.LENGTH_LONG).show();
        } else if (id == R.id.logout) {
            Snackbar.make(drawer, "Successfully Logout", Snackbar.LENGTH_LONG).show();
            Intent in = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(in);
        } else if (id == R.id.Setting) {
            Snackbar.make(drawer, "Share", Snackbar.LENGTH_LONG).show();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void hideItem(NavigationView navigationView) {
        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.adduser).setVisible(false);
        nav_Menu.findItem(R.id.ApprovedUser).setVisible(false);
        nav_Menu.findItem(R.id.deleteuser).setVisible(false);
    }
}
