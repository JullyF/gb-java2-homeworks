package lesson1homework.participant;

public class Cat implements Participant {
    private final String name;
    private final int jumpLimit;
    private final int runEndurance;

    public Cat(String name, int jumpLimit, int runEndurance) {
        this.name = name;
        this.jumpLimit = jumpLimit;
        this.runEndurance = runEndurance;
    }

    public int jumpOverTheWall() {
        System.out.print("Кот " + this.name + " может перепрыгнуть препятствие высотой " + jumpLimit + " м. ");
        return jumpLimit;
    }

    public int runTheEntireTrack() {
        System.out.print("Кот " + this.name + " может пробежать дистанцию " + runEndurance + " м. ");
        return runEndurance;
    }

    @Override
    public String getName() {
        return name;
    }

}
