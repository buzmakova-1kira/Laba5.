package cats;

public class CatCounter extends Cat {
    private int meowCount;

    public CatCounter(String name) {
        super(name);
    }

    @Override
    public void meow() {
        super.meow();
        meowCount++;
    }

    public int getMeowCount() {
        return meowCount;
    }
}