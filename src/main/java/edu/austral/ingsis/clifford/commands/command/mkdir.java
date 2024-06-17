package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.cli.Interpreter;
import edu.austral.ingsis.clifford.filesystem.Directory;

public class mkdir implements Command {

  @Override
  public String execute(String[] splitCommand, Interpreter interpreter) {
    Directory currentDir = interpreter.getCurrentDirectory();
    String path = computePath(currentDir, splitCommand[1]);
    Directory newDir = new Directory(splitCommand[1], path, currentDir);
    currentDir.addDirectory(newDir);
    return "'" + splitCommand[1] + "' directory created";
  }

  private String computePath(Directory currentDir, String name) {
    /* Case where parent is the root. */
    if (currentDir.getParent() == null) {
      return "/" + name;
    } else {
      return currentDir.getPath() + "/" + name;
    }
  }
}
