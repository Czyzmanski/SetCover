package cover.command;

import cover.algorithm.CoverAlgorithm;
import cover.element.Element;
import cover.element.ElementBuilder;
import cover.set.IndexedSetsFamily;
import cover.set.TargetSet;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandParser implements Iterator<Command> {

    private final IndexedSetsFamily indexedSetsFamily;
    private final Scanner inputScanner;
    private final OutputStream solutionOutputStream;
    private Integer lastRead;

    public CommandParser(IndexedSetsFamily indexedSetsFamily, InputStream inputStream,
                         OutputStream solutionOutputStream) {
        this.indexedSetsFamily = indexedSetsFamily;
        this.inputScanner = new Scanner(inputStream);
        this.solutionOutputStream = solutionOutputStream;
        this.lastRead = null;
    }

    @Override
    public boolean hasNext() {
        return this.inputScanner.hasNextInt();
    }

    @Override
    public Command next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        } else {
            if (this.lastRead == null) {
                this.lastRead = this.inputScanner.nextInt();
            }
            if (this.lastRead < 0) {
                return this.newSolveCoverCommand();
            } else if (this.lastRead == 0) {
                return this.newCreateSetCommand();
            } else {
                return this.newAddElementCommand();
            }
        }
    }

    private Command newSolveCoverCommand() {
        int targetSetLastNumber = -this.lastRead;
        int typeOfAlgorithm = this.inputScanner.nextInt();
        TargetSet targetSet = new TargetSet(targetSetLastNumber);
        CoverAlgorithm coverAlgorithm = CoverAlgorithm.newInstance(typeOfAlgorithm,
                                                                   this.solutionOutputStream);
        this.lastRead = null;
        return new SolveCoverCommand(indexedSetsFamily, targetSet, coverAlgorithm);
    }

    private Command newCreateSetCommand() {
        this.lastRead = null;
        return new CreateSetCommand(this.indexedSetsFamily);
    }

    private Command newAddElementCommand() {
        ElementBuilder elementBuilder = new ElementBuilder();
        elementBuilder.addParameter(this.lastRead);
        if (this.hasNext()) {
            this.lastRead = this.inputScanner.nextInt();
            if (this.lastRead < 0) {
                elementBuilder.addParameter(-this.lastRead);
                if (this.hasNext()) {
                    this.lastRead = this.inputScanner.nextInt();
                    if (this.lastRead < 0) {
                        elementBuilder.addParameter(-this.lastRead);
                        this.lastRead = null;
                    }
                }
            }
        }
        Element newElement = elementBuilder.buildElement();
        return new AddElementCommand(this.indexedSetsFamily, newElement);
    }

}
