package start;

import enumLeague.League;
import generator.Generator;
import model.Game;
import model.Player;
import model.PlayerManager;
import model.ResultOfGameService;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        String name = "NAME", surname = "SURNAME", age = "AGE", score = "SCORE", league = "LEAGUE";
        System.out.println(String.format("%5s %18s %10s %6s %7s", name, surname,age,score,league));
        System.out.println("--------------------------------------------------");

        Generator.createPlayerJunior();
        List<Player> junior = PlayerManager.getInstance().getPlayersByLeague(League.JUNIOR);
        game.makeGame(junior);

        Generator.createPlayerMiddle();
        List<Player> middle = PlayerManager.getInstance().getPlayersByLeague(League.MIDDLE);
        game.makeGame(middle);

        Generator.createPlayerSenior();
        List<Player> senior = PlayerManager.getInstance().getPlayersByLeague(League.SENIOR);
        game.makeGame(senior);

        System.out.println("\n----------------TOP BESTE PLAYERS-----------------");
        ResultOfGameService.showTopPlayerIntoLeague(junior);
        ResultOfGameService.showTopPlayerIntoLeague(middle);
        ResultOfGameService.showTopPlayerIntoLeague(senior);
        System.out.println("---------------------------------------------------");

        ResultOfGameService.movePlayers(senior,middle,junior);
        System.out.println("---------------TEAMS AFTER SELECTION---------------");
        Game.printPlayers(junior);
        Game.printPlayers(middle);
        Game.printPlayers(senior);
        System.out.println("---------------------------------------------------");

        System.out.println("\n-------------------SECOND LEVEL--------------------");
        game.makeGame(junior);
        game.makeGame(middle);
        game.makeGame(senior);

        System.out.println("\n----------------TOP BESTE PLAYERS-----------------");
        ResultOfGameService.showTopPlayerIntoLeague(junior);
        ResultOfGameService.showTopPlayerIntoLeague(middle);
        ResultOfGameService.showTopPlayerIntoLeague(senior);
        System.out.println("---------------------------------------------------");

        ResultOfGameService.movePlayers(senior,middle,junior);
        System.out.println("---------------TEAMS AFTER SELECTION---------------");
        Game.printPlayers(junior);
        Game.printPlayers(middle);
        Game.printPlayers(senior);
        System.out.println("---------------------------------------------------");

        HashMap<League, List<Player>> map =  ResultOfGameService.putResultIntoMap(senior,middle,junior);
        ResultOfGameService.showMap(map);
    }
}
