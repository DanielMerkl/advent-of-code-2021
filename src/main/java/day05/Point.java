package day05;

record Point(long x, long y) {
    static Point fromInput(String input) {
        String[] split = input.split(",");
        long x = Long.parseLong(split[0]);
        long y = Long.parseLong(split[1]);
        return new Point(x, y);
    }
}
