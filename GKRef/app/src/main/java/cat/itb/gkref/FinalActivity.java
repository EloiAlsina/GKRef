package cat.itb.gkref;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import cat.itb.gkref.MenuFragment;
import cat.itb.gkref.R;

import static cat.itb.gkref.GameActivity.local_final_score4;
import static cat.itb.gkref.GameActivity.local_parts_result4;
import static cat.itb.gkref.GameActivity.visitor_final_score4;
import static cat.itb.gkref.GameActivity.visitor_parts_result4;

public class FinalActivity extends Fragment {
    private Button end_match;
    private TextView show_local_final_score, show_visitor_final_score, local_parts_result, visitor_parts_result;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_final, container, false);

        show_local_final_score=root.findViewById(R.id.show_local_final_score);
        show_visitor_final_score=root.findViewById(R.id.show_visitor_final_score);

        local_parts_result=root.findViewById(R.id.local_parts_result);
        visitor_parts_result=root.findViewById(R.id.visitor_parts_result);

        show_local_final_score.setText("" + local_final_score4+" goals");
        show_visitor_final_score.setText("" + visitor_final_score4+" goals");

        local_parts_result.setText("" + local_parts_result4+" points");
        visitor_parts_result.setText("" + visitor_parts_result4+" points");

        end_match=root.findViewById(R.id.end_match);

        end_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MenuFragment.class);
                startActivity(i);
            }
        });
    return root;
    }
}
