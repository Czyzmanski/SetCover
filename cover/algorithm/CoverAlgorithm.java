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
    
    protected final Writer solutionWriter;

    public CoverAlgorithm(OutputStream solutionOutputStream) {
        this.solutionWriter = new PrintWriter(solutionOutputStream);
    }

    public abstract void run(IndexedSetsFamily indexedSetsFamily, TargetSet targetSet);

    public static CoverAlgorithm newInstance(int type, OutputStream solutionOutputStream) {
        if (type == BRUTE_FORCE) {
            return new BruteForceCoverAlgorithm(solutionOutputStream);
        } else if (type == NAIVE_HEURISTIC) {
            return new NaiveHeuristicCoverAlgorithm(solutionOutputStream);
        } else if (type == GREEDY_HEURISTIC) {
            return new GreedyHeuristicCoverAlgorithm(solutionOutputStream);
        } else {
            throw new UnsupportedOperationException("Unsupported type of algorithm");
        }
    }

}
