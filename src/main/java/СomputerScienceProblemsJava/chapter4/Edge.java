package СomputerScienceProblemsJava.chapter4;

public class Edge {
    public final int u;
    public final int v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public Edge reversed() {
        return new Edge(v, u);
    }

    @Override
    public String toString() {
        return u + " -> " + v;
    }
}
