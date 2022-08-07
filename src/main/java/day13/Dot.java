package day13;

record Dot(int x, int y) {
    static Dot fromInput(String input) {
        String[] split = input.split(",");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        return new Dot(x, y);
    }

    public int position(Axis axis) {
        return axis == Axis.X ? x : y;
    }

    public Dot changePosition(Axis axis, int updatedDotPosition) {
        if (axis == Axis.X) {
            return new Dot(updatedDotPosition, y);
        } else {
            return new Dot(x, updatedDotPosition);
        }
    }
}
