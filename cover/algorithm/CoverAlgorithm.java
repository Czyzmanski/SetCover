package cover.algorithm;

import cover.set.IndexedSetsFamily;
import cover.set.TargetSet;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public abstract class CoverAlgorithm {

    private static final int BRUTE_FORCE = 1;
    private static final int NAIVE_HEURISTIC = 2;
    private static final int GREEDY_HEURISTIC = 3;

    protected final TargetSet targetSet;
    protected final IndexedSetsFamily indexedSetsFamily;
    protected final Writer solutionWriter;

    public CoverAlgorithm(TargetSet targetSet, IndexedSetsFamily indexedSetsFamily, OutputStream outputStream) {
        this.targetSet = targetSet;
        this.indexedSetsFamily = indexedSetsFamily;
        this.solutionWriter = new PrintWriter(outputStream);
    }

    public abstract void run();

    public static CoverAlgorithm newInstance(int type, TargetSet targetSet,
                                             IndexedSetsFamily indexedSetsFamily, OutputStream outputStream) {
        if (type == BRUTE_FORCE) {
            return new BruteForceCoverAlgorithm(targetSet, indexedSetsFamily, outputStream);
        } else if (type == NAIVE_HEURISTIC) {
            return new NaiveHeuristicCoverAlgorithm(targetSet, indexedSetsFamily, outputStream);
        } else if (type == GREEDY_HEURISTIC) {
            return new GreedyHeuristicCoverAlgorithm(targetSet, indexedSetsFamily, outputStream);
        } else {
            throw new UnsupportedOperationException("Unsupported type of algorithm");
        }
    }

}
