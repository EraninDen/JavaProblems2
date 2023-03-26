package СomputerScienceProblemsJava.chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleEquation extends Chromosome<SimpleEquation> {

    private int x, y;

    private static final int MAX_START = 6;

    public SimpleEquation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static SimpleEquation randomInstance() {
        Random random = new Random();
        return new SimpleEquation(random.nextInt(MAX_START),
                random.nextInt(MAX_START));
    }

    @Override
    public double fitness() {
        //6x - x^2 + 4y - y^2
        //return 6 * x - x * x + 4 * y - y * y;

        //return (3 * x - 5 * y - 2) / 100;
        //return (3 * x - y - 3);

        return (x + y) / 1;

        //5x - x^2 + 8y - y^2
        //return 5 * x - x * x + 8 * y - y * y;
    }

    @Override
    public List<SimpleEquation> crossover(SimpleEquation other) {
        SimpleEquation child1 = new SimpleEquation(x, other.y);
        SimpleEquation child2 = new SimpleEquation(other.x, y);
        return List.of(child1, child2);
    }

    @Override
    public void mutate() {
        Random random = new Random();
        if (random.nextDouble() > 0.5) {
            if (random.nextDouble() > 0.5) {
                x += 1;
            } else {
                x -= 1;
            }
        } else {
            if (random.nextDouble() > 0.5) {
                y += 1;
            } else {
                y -= 1;
            }
        }
    }

    @Override
    public SimpleEquation copy() {
        return new SimpleEquation(x, y);
    }

    @Override
    public String toString() {
        return "X: " + x + ", " + " Y: " + y + ", Fitness: " + fitness();
    }

    public static void main(String[] args) {
        ArrayList<SimpleEquation> initialPopulation = new ArrayList<>();
        final int POPULATION_SIZE = 6;
        final int GENERATIONS = 100;
        final double THRESHOLD = 60.0;

        for (int i = 0; i < POPULATION_SIZE; i++) {
            initialPopulation.add(SimpleEquation.randomInstance());
        }
        GeneticAlgorithm<SimpleEquation> qa = new GeneticAlgorithm<>(
                initialPopulation,
                0.1, 0.7, GeneticAlgorithm.SelectionType.TOURNAMENT
        );


            SimpleEquation result = qa.run(1000, 7);
            //System.out.println(GENERATIONS + ", " + THRESHOLD);
            System.out.println(result);


    }
    /* в общем и целом алгоритм работает с уравнением таким образом: в фитнесе задаем функцию - затем
    в неизвестные рандомно подставляються значения - диапазон стартовых рандомных значений задается в поле макс старт -
    далее если функция фитнес вернет значение больше порогового - порог мы указываем сами как и макс генератион
    выполняющий нужное количество генераций подбора.
    задача алгоритма  - подобрать оптимальное решение - а не точное*/
}
