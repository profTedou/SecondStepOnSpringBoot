package patterns.command;

public interface Command {
    boolean execute();
    boolean undo();
}
