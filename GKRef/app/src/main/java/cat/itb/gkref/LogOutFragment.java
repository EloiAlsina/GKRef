package cat.itb.gkref;

import android.os.Bundle;

import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cat.itb.gkref.R;
import com.google.firebase.auth.FirebaseAuth;

public class LogOutFragment extends Fragment {

    FirebaseAuth firebaseAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_logout, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signOut();
        Toast.makeText(getContext(),"SignOut complete",Toast.LENGTH_SHORT).show();
        getActivity().onBackPressed();
        return v;
    }


}