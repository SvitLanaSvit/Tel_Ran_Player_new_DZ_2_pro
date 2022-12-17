package model;
import enumLeague.League;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PlayerManager {
    private List<Player> players;
    static PlayerManager pm = null;

    private PlayerManager() {
        players = new ArrayList<>();
    }

    public static PlayerManager getInstance(){
        if(pm == null)
            pm = new PlayerManager();
        return pm;
    }

    public boolean addIntoListPlayer(Player player){
        for (Player p : players) {
            if(p.getId().equals(player.getId()))
                return false;
        }
        if(assignLeague(player))
            players.add(player);
        return true;
    }

    public boolean assignLeague(Player p){
        boolean res = true;
        if(p.getAge() >= 15 && p.getAge() <= 17)
            p.setLeague(League.JUNIOR);
        else if(p.getAge() >= 18 && p.getAge() <= 25)
            p.setLeague(League.MIDDLE);
        else if(p.getAge() >= 26 && p.getAge() <= 40)
            p.setLeague(League.SENIOR);
        else res = false;
        return res;
    }

    public List<Player> getPlayersByLeague(League league){
        List<Player> playersListByLeague = new LinkedList<>();
        for (Player p: players) {
            if(p.getLeague().equals(league)){
                playersListByLeague.add(p);
            }
        }
        return playersListByLeague;
    }
}
