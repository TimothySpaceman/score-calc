package rating;

import java.util.List;

public class Stats {
    public final double min;
    public final double max;
    public final double sum;
    public final double avg;

    private Stats(double min, double max, double sum, double avg) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.avg = avg;
    }

    public static Stats of(List<Score> scores) {
        if (scores.isEmpty()) {
            return new Stats(Double.NaN, Double.NaN, 0.0, Double.NaN);
        }

        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        double sum = 0.0;
        int count = 0;

        for (Score score : scores) {
            double v = score.getValue();
            if (v < min) min = v;
            if (v > max) max = v;
            sum += v;
            count++;
        }

        return new Stats(min, max, sum, sum / count);
    }

}
