package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.cli.Interpreter;

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
    if (destination.charAt(1) == '.') {
      interpreter.setDirectory(
          interpreter.getDirectory().getParent());
    }
    String finalDir = interpreter.getDirectory().getName();
    return "Moved directory to: '" + finalDir + "'";
  }
}
