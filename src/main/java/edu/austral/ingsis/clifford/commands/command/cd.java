package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.cli.Interpreter;
import edu.austral.ingsis.clifford.filesystem.Directory;

public class cd implements Command {

  @Override
  public String execute(String[] splitCommand, Interpreter interpreter) {
    String destination = splitCommand[1];
    if (destination.charAt(0) == '.') {
      return processCompositeArgument(destination, interpreter);
    }
    return "";
  }

  /* First char of argument is '.' */
  private String processCompositeArgument(String destination, Interpreter interpreter) {
    Directory currentDir = interpreter.getDirectory();
    if (destination.charAt(1) == '.') {
      interpreter.setDirectory(currentDir.getParent());
    }
    String finalDir = currentDir.getName();
    return "Moved directory to: '" + finalDir + "'";
  }
}
