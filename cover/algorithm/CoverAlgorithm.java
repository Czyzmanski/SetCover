package cover.algorithm;

import cover.set.IndexedSetsFamily;
import cover.set.TargetSet;

import java.util.ArrayList;
import java.util.List;

public abstract class CoverAlgorithm {

    private static final int BRUTE_FORCE = 1;
    private static final int NAIVE_HEURISTIC = 2;
    private static final int GREEDY_HEURISTIC = 3;

    protected final List<Integer> solution;

    public CoverAlgorithm() {
        this.solution = new ArrayList<>();
    }

    public abstract void run(IndexedSetsFamily indexedSetsFamily, TargetSet targetSet);

    public static CoverAlgorithm newInstance(int typeOfAlgorithm) {
        if (typeOfAlgorithm == BRUTE_FORCE) {
            return new BruteForceCoverAlgorithm();
        } else if (typeOfAlgorithm == NAIVE_HEURISTIC) {
            return new NaiveHeuristicCoverAlgorithm();
        } else if (typeOfAlgorithm == GREEDY_HEURISTIC) {
            return new GreedyHeuristicCoverAlgorithm();
        } else {
            throw new UnsupportedOperationException("Unsupported type of algorithm");
        }
    }

}
