interface Meowable {
    void meow();
}

class Cat implements Meowable {
    private String name;
    private int meowCount = 0;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void meow() {
        meowCount++;
        System.out.println(name + ": мяу!");
    }

    public int getMeowCount() {
        return meowCount;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }

    public static void meowsCare(Meowable m) {
        for (int i = 0; i < 5; i++) {
            m.meow();
        }
    }
}