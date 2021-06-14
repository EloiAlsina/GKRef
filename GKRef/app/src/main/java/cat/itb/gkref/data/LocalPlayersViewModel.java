package cat.itb.gkref.data;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class LocalPlayersViewModel extends ViewModel {
    static List<PlayersLocal> playersLocals = new ArrayList<PlayersLocal>();

    public LocalPlayersViewModel() {
        playersLocals.add(new PlayersLocal());
    }

    public List<PlayersLocal> getPlayersLocals() {
        return playersLocals;
    }

    public void addPlayersLocal(PlayersLocal playersLocal) {
        playersLocals.add(playersLocal);
    }
}
