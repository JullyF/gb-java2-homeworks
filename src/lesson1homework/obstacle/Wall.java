package lesson1homework.obstacle;

import lesson1homework.participant.Participant;

public class Wall implements Obstacle {

    private final int wallHeight;

    public Wall(int wallHeight) {
        this.wallHeight = wallHeight;

    }


    @Override
    public boolean passTheObstacle(Participant participant) {
        if (participant.jumpOverTheWall() > this.wallHeight) {
            System.out.println("Участник " + participant.getName() + " перепрыгнул препятствие высотой " + this.wallHeight + " м.");
            return true;
        } else {
            System.out.println("Участник " + participant.getName() + " не смог преодолеть препятствие.");
            return false;
        }
    }

    @Override
    public void obstacleInfo() {
        System.out.println("Препятствие стена: высота - " + this.wallHeight);

    }

}
