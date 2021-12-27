package lesson1homework;

import lesson1homework.obstacle.Obstacle;
import lesson1homework.obstacle.Track;
import lesson1homework.obstacle.Wall;
import lesson1homework.participant.Cat;
import lesson1homework.participant.Human;
import lesson1homework.participant.Participant;
import lesson1homework.participant.Robot;

import java.util.Random;

public class CompetitionApp {
    public static void main(String[] args) {
        Competition competition = createAndPrepareCompetition();
        competition.startCompetition();
        
    }

    private static Competition createAndPrepareCompetition() {
        Participant[] participants = {
                new Human("Евлампий", 2, 1000),
                new Cat("Пушистик", 5, 30),
                new Cat("Мурзик", 4, 10),
                new Robot("WALL-E", 0, 3000),
                new Human("Казимир", 1, 500),
                new Robot("RK900", 50, 5000),
        };

        Random random = new Random();
        Obstacle[] obstacles = {
                new Wall(random.nextInt(10)),
                new Track(random.nextInt(100))
        };

        Competition competition = new Competition("\"Гонка на выживание\"!");
        competition.setObstacles(obstacles);
        competition.setParticipants(participants);
        return competition;
    }


}
