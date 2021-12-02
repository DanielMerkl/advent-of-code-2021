package day02;

record Instruction(Direction direction, long amount) {
    static Instruction fromInput(String input) {
        String[] split = input.split(" ");

        Direction direction = Direction.valueOf(split[0].toUpperCase());
        long amount = Long.parseLong(split[1]);

        return new Instruction(direction, amount);
    }
}
