package cat.itb.gkref.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import cat.itb.gkref.ActActivity;
import cat.itb.gkref.MenuFragment;
import cat.itb.gkref.FragmentRef;
import cat.itb.gkref.R;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavView;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavView = findViewById(R.id.bottom_nav);
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.menu_history, R.id.menu_act, R.id.menu_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupWithNavController(navigationView, navController);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        setVisibilityBottomNavView(View.GONE);

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void setVisibilityBottomNavView(int visibility) {
        bottomNavView.setVisibility(visibility);
    }
}
