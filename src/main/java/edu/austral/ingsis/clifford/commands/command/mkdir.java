package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.cli.Interpreter;
import edu.austral.ingsis.clifford.filesystem.Directory;

public class mkdir implements Command {

  @Override
  public String execute(String[] splitCommand, Interpreter interpreter) {
    Directory newDir = new Directory(splitCommand[1],
        interpreter.getDirectory().getPath() + "/" + splitCommand[1], interpreter.getDirectory());
    interpreter.getDirectory().addDirectory(newDir);
    return "'" + splitCommand[1] + "' directory created.";
  }
}
