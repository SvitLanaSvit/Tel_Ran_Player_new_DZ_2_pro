package model;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Game {

    public static void printPlayers(List<Player> players){
        System.out.println("---------------------"+players.get(0).getLeague()+"-----------------------");
        for (Player p:players) {
            System.out.println(String.format("%-15s %-15s %-5d %-5d %-10s",
                    p.getName(), p.getSurname(), p.getAge(), p.getScore(), p.getLeague()));
        }
    }

    public void makeGame(List<Player> players){
        for(int k = 0; k < 5; k++){
            for (int i = 0; i < players.size() - 1; i++){
                Player p1 = players.get(i);
                for(int j = i + 1; j < players.size(); j++){
                    Player p2 = players.get(j);
                    resultGame(p1,p2);
                }
            }
        }
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                int res = o2.getScore() - o1.getScore();
                if(res == 0)
                    res = o1.getName().compareTo(o2.getName());
                return res;
            }
        });
        printPlayers(players);
    }

    public void resultGame(Player p1, Player p2){
        if(Math.random() > 0.5)
            p2.addScore(1);
        else p1.addScore(1);
    }
}
