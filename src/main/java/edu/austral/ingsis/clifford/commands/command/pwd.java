package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.cli.Interpreter;

public class pwd implements Command {

  @Override
  public String execute(String[] splitCommand, Interpreter interpreter) {
    return interpreter.getCurrentDirectory().getPath();
  }
}
