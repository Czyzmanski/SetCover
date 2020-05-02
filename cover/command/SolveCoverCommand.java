package cover.command;

import cover.algorithm.CoverAlgorithm;
import cover.set.SetsFamily;
import cover.set.SetToCover;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

public class SolveCoverCommand extends Command {

    private static final int NO_SOLUTION = 0;

    private final CoverAlgorithm coverAlgorithm;
    private final PrintWriter solutionWriter;

    public SolveCoverCommand(SetsFamily setsFamily, int setToCoverMaxNumber,
                             int coverAlgorithmType, OutputStream solutionOutputStream) {
        super(setsFamily);
        this.coverAlgorithm = CoverAlgorithm.newInstance(coverAlgorithmType,
                                                         new SetToCover(setToCoverMaxNumber),
                                                         this.setsFamily);
        this.solutionWriter = new PrintWriter(solutionOutputStream, true);
    }

    @Override
    public void execute() {
        this.coverAlgorithm.run();
        List<Integer> solution = this.coverAlgorithm.solution();
        Collections.sort(solution);
        if (solution.isEmpty()) {
            this.solutionWriter.println(NO_SOLUTION);
        } else {
            this.solutionWriter.print(solution.get(0) + 1);
            int solutionSize = solution.size();
            for (int i = 1; i < solutionSize; i++) {
                this.solutionWriter.print(String.format(" %d", solution.get(i) + 1));
            }
            this.solutionWriter.println();
        }
        this.solutionWriter.flush();
    }

}
