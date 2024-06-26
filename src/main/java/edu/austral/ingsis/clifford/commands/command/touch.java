package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.cli.Interpreter;
import edu.austral.ingsis.clifford.filesystem.Directory;
import edu.austral.ingsis.clifford.filesystem.File;

public class touch implements Command {

  @Override
  public String execute(String[] splitCommand, Interpreter interpreter) {
    Directory currentDir = interpreter.getCurrentDirectory();
    File file = new File(splitCommand[1], currentDir.getPath(), currentDir);
    if (currentDir.getFiles().contains(file)) {
      currentDir.removeFile(file.getName());
    }
    currentDir.addFile(file);
    return "'" + splitCommand[1] + "' file created";
  }
}
