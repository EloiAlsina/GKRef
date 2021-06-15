package cat.itb.gkref.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import cat.itb.gkref.R;

import static com.google.android.gms.common.util.CollectionUtils.listOf;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavView = findViewById(R.id.bottom_nav);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavView, navController);

        setVisibilityBottomNavView(View.GONE);

    }

    public void setVisibilityBottomNavView(int visibility) {
        bottomNavView.setVisibility(visibility);
    }
}
