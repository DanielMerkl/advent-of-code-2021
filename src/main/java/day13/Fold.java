package day13;

record Fold(Axis axis, int position) {
    static Fold fromInput(String input) {
        String axisWithPosition = input.replace("fold along ", "");
        String[] split = axisWithPosition.split("=");
        Axis axis = Axis.valueOf(split[0].toUpperCase());
        int position = Integer.parseInt(split[1]);
        return new Fold(axis, position);
    }
}
