package cover.algorithm;

import cover.set.SetsFamily;
import cover.set.SetToCover;

import java.util.ArrayList;
import java.util.List;

public abstract class CoverAlgorithm {

    private static final int BRUTE_FORCE = 1;
    private static final int GREEDY_HEURISTIC = 2;
    private static final int NAIVE_HEURISTIC = 3;

    protected SetToCover setToCover;
    protected SetsFamily setsFamily;
    /* List containing numbers of sets used in solution. */
    protected List<Integer> solution;

    public CoverAlgorithm(SetToCover setToCover, SetsFamily setsFamily) {
        this.setToCover = setToCover;
        this.setsFamily = setsFamily;
        this.solution = new ArrayList<>();
    }

    public List<Integer> solution() {
        return this.solution;
    }

    public abstract void run();

    public static CoverAlgorithm newInstance(int coverAlgorithmType,
                                             SetToCover setToCover, SetsFamily setsFamily) {
        if (coverAlgorithmType == BRUTE_FORCE) {
            return new BruteForceCoverAlgorithm(setToCover, setsFamily);
        } else if (coverAlgorithmType == NAIVE_HEURISTIC) {
            return new NaiveHeuristicCoverAlgorithm(setToCover, setsFamily);
        } else if (coverAlgorithmType == GREEDY_HEURISTIC) {
            return new GreedyHeuristicCoverAlgorithm(setToCover, setsFamily);
        } else {
            throw new UnsupportedOperationException("Unsupported type of algorithm");
        }
    }

}
