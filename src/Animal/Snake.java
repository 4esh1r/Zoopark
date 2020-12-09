package Animal;

public  class Snake extends Animal{
    private int length;
    private String color;

   public 2Snake(String type, String name, int age, int weight, int aviaryNumber, int timeSpentInTheZoo, int length, String color) {
        super(type, name, age, weight, aviaryNumber, timeSpentInTheZoo);
        this.length = length;
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}