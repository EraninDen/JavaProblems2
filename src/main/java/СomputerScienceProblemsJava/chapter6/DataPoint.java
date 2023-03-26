package СomputerScienceProblemsJava.chapter6;

import java.util.ArrayList;
import java.util.List;

public class DataPoint {

    public final int numDimension;
    private List<Double> originals;
    public List<Double> dimensions;

    public DataPoint(List<Double> initials) {
        originals = initials;
        dimensions = new ArrayList<>(initials);
        numDimension = dimensions.size();
    }

    public double distance(DataPoint other) {
        double differences = 0.0;
        for (int i = 0; i < numDimension; i++) {
            double difference = dimensions.get(i) - other.dimensions.get(i);
            differences += Math.pow(difference, 2);
        }
        return Math.sqrt(differences);
    }

    @Override
    public String toString() {
        return originals.toString();
    }
}
