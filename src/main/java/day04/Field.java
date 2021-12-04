package day04;

class Field {
    private final long number;
    private boolean marked = false;

    Field(long number) {
        this.number = number;
    }

    void mark() {
        marked = true;
    }

    public long getNumber() {
        return number;
    }

    public boolean isMarked() {
        return marked;
    }
}
