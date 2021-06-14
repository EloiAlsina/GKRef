package cat.itb.gkref.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cat.itb.gkref.R;

public class LocalPlayerAdapter extends RecyclerView.Adapter<LocalPlayerAdapter.LocalPlayersViewHolder> {
    List<PlayersLocal> playersLocals;

    public LocalPlayerAdapter(List<PlayersLocal> playersLocals) {
        this.playersLocals = playersLocals;
    }

    @Override
    public LocalPlayersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_local_team, parent, false);

        return new LocalPlayersViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LocalPlayersViewHolder holder, int position) {
        holder.onBind(playersLocals.get(position));

    }


    @Override
    public int getItemCount() {
        return playersLocals.size();
    }

    public class LocalPlayersViewHolder extends RecyclerView.ViewHolder {
        TextView players_name;

        public LocalPlayersViewHolder(@NonNull View itemView) {
            super(itemView);

            players_name = itemView.findViewById(R.id.teammember_2);
        }

        public void onBind(PlayersLocal playersLocals){
            players_name.setText((CharSequence) playersLocals.getName());
        }
    }
}
