package lesson1homework;

import lesson1homework.obstacle.Obstacle;
import lesson1homework.participant.Participant;

public class Competition {

    private Obstacle[] obstacles;
    private Participant[] participants;
    private final String competitionTitle;


    public Competition(String competitionTitle) {
        this.competitionTitle = competitionTitle;
    }

    public void startCompetition() {
        System.out.println("Соревнование " + this.competitionTitle);
        for (Obstacle obstacle : obstacles) {
            obstacle.obstacleInfo();
        }
        System.out.println();

        for (Participant participant : this.participants) {
            System.out.println();
            if (!this.isParticipantPassedTheCompetition(participant)) {
                System.out.println("Участник " + participant.getName() + " не смог пройти все препятствия.");
            } else {
                System.out.println("Участник " + participant.getName() + " успешно завершил гонку!");
            }
        }


    }

    private boolean isParticipantPassedTheCompetition(Participant participant) {
        for (Obstacle obstacle : this.obstacles) {
            if (!obstacle.passTheObstacle(participant)) {
                return false;
            }
        }
        return true;
    }


    public void setObstacles(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }


    public void setParticipants(Participant[] participants) {
        this.participants = participants;
    }

}



