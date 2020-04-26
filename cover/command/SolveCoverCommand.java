package cover.command;

import cover.algorithm.CoverAlgorithm;
import cover.set.IndexedSetsFamily;
import cover.set.TargetSet;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

public class SolveCoverCommand extends Command {

    private final TargetSet targetSet;
    private final CoverAlgorithm coverAlgorithm;
    private final PrintWriter solutionWriter;

    public SolveCoverCommand(IndexedSetsFamily indexedSetsFamily, TargetSet targetSet,
                             CoverAlgorithm coverAlgorithm, OutputStream solutionOutputStream) {
        super(indexedSetsFamily);
        this.targetSet = targetSet;
        this.coverAlgorithm = coverAlgorithm;
        this.solutionWriter = new PrintWriter(solutionOutputStream, true);
    }

    @Override
    public void execute() {
        this.coverAlgorithm.run(this.indexedSetsFamily, this.targetSet);
        List<Integer> solution = this.coverAlgorithm.solution();
        if (solution.isEmpty()) {
            this.solutionWriter.println(0);
        } else {
            this.solutionWriter.print(solution.get(0));
            int solutionSize = solution.size();
            for (int i = 1; i < solutionSize; i++) {
                this.solutionWriter.print(String.format(" %d", solution.get(i)));
            }
            this.solutionWriter.println();
        }
    }

}
