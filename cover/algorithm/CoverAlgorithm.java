package cover.algorithm;

import cover.set.SetsFamily;
import cover.set.TargetSet;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public abstract class CoverAlgorithm {

    private static final int BRUTE_FORCE = 1;
    private static final int NAIVE_HEURISTIC = 2;
    private static final int GREEDY_HEURISTIC = 3;

    protected final TargetSet targetSet;
    protected final SetsFamily setsFamily;
    protected final Writer solutionWriter;

    public CoverAlgorithm(TargetSet targetSet, SetsFamily setsFamily, OutputStream outputStream) {
        this.targetSet = targetSet;
        this.setsFamily = setsFamily;
        this.solutionWriter = new PrintWriter(outputStream);
    }

    public abstract void run();

    public static CoverAlgorithm newInstance(int type, TargetSet targetSet,
                                             SetsFamily setsFamily, OutputStream outputStream) {
        switch (type) {
            case BRUTE_FORCE:
                return new BruteForceCoverAlgorithm(targetSet, setsFamily, outputStream);
            case NAIVE_HEURISTIC:
                return new NaiveHeuristicCoverAlgorithm(targetSet, setsFamily, outputStream);
            case GREEDY_HEURISTIC:
                return new GreedyHeuristicCoverAlgorithm(targetSet, setsFamily, outputStream);
            default:
                throw new UnsupportedOperationException("Unsupported type of algorithm");
        }
    }

}
