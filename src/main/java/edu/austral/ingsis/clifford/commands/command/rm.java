package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.cli.Interpreter;
import edu.austral.ingsis.clifford.filesystem.Archive;
import edu.austral.ingsis.clifford.filesystem.Directory;

public class rm implements Command {

  @Override
  public String execute(String[] splitCommand, Interpreter interpreter) {
    if (splitCommand.length == 2) {
      return simpleRemoval(splitCommand[1], interpreter);
    } else {
      return recursiveRemoval(splitCommand[2], interpreter);
    }
  }

  private String recursiveRemoval(String fileName, Interpreter interpreter) {
    Directory directory = interpreter.getCurrentDirectory();
    Archive result = directory.findArchive(fileName);
    if (result == null) {
      return "could not find file '" + fileName + "'";
    } else {
      directory.removeDirectory(result);
      return "'" + fileName + "' removed";
    }
  }

  private String simpleRemoval(String fileName, Interpreter interpreter) {
    Directory directory = interpreter.getCurrentDirectory();
    Archive result = directory.findArchive(fileName);
    if (result == null) {
      return "could not find file '" + fileName + "'";
    } else {
      return processSimpleResult(result, fileName, directory);
    }
  }

  private String processSimpleResult(Archive result, String fileName, Directory directory) {
    if (result instanceof Directory) {
      return "cannot remove '" + result.getName() + "', is a directory";
    } else {
      directory.removeFile(fileName);
      return "'" + fileName + "' removed";
    }
  }
}
