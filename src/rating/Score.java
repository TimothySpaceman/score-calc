package rating;

public class Score {
    private double value;

    public Score(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public static Score fromString(String s) {
        return new Score(Double.parseDouble(s));
    }
}
