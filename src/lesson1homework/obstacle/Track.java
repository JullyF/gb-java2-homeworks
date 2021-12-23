package lesson1homework.obstacle;

import lesson1homework.participant.Participant;

public class Track implements Obstacle {

    private final int trackLength;


    public Track(int trackLength) {
        this.trackLength = trackLength;
    }


    @Override
    public boolean passTheObstacle(Participant participant) {

        if (participant.runTheEntireTrack() > this.trackLength) {
            System.out.println("Участник " + participant.getName() +
                    " пробежал всю дистанцию, равную " + this.trackLength + " м.");
            return true;
        } else {
            System.out.println("Участник " + participant.getName() + " сошёл с дистанции.");
            return false;
        }

    }

    public void obstacleInfo() {
        System.out.println("Беговая дорожка: длина - " + this.trackLength);

    }

}
