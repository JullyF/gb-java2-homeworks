package lesson1homework.participant;


public class Human implements Participant {
    private final String name;
    private final int jumpLimit;
    private final int runEndurance;


    public Human(String name, int jumpLimit, int runEndurance) {
        this.name = name;
        this.jumpLimit = jumpLimit;
        this.runEndurance = runEndurance;
    }

    public int jumpOverTheWall() {
        System.out.print("Человек " + this.name + " может перепрыгнуть препятствие высотой " + jumpLimit + " м. ");
        return jumpLimit;
    }

    public int runTheEntireTrack() {
        System.out.print("Человек " + this.name + " может пробежать дистанцию " + runEndurance + " м. ");
        return runEndurance;
    }

    @Override
    public String getName() {
        return name;
    }


}
