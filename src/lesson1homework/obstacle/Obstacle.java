package lesson1homework.obstacle;

import lesson1homework.participant.Participant;

public interface Obstacle {

    boolean passTheObstacle(Participant participant);

    void obstacleInfo();

}
