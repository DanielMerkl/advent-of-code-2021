package day12;

record Cave(String name) {

    static final Cave START_CAVE = new Cave("start");
    static final Cave END_CAVE = new Cave("end");

    boolean isSmall() {
        return name.equals(name.toLowerCase());
    }

    boolean isLarge() {
        return !isSmall();
    }

    boolean isEnd() {
        return this.equals(END_CAVE);
    }

    boolean isStart() {
        return this.equals(START_CAVE);
    }

}
