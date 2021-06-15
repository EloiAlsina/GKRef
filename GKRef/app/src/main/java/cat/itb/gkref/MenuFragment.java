package cat.itb.gkref;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import cat.itb.gkref.Activities.MainActivity;

public class MenuFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_menu, container, false);
        MainActivity parentActivity = (MainActivity) getActivity();
        assert parentActivity != null;
        parentActivity.setVisibilityBottomNavView(View.VISIBLE);

        TransitionFragment.login.setVisibility(View.INVISIBLE);
        TransitionFragment.logout.setVisibility(View.VISIBLE);
        TransitionFragment.start.setVisibility(View.VISIBLE);

        return root;
    }
}
