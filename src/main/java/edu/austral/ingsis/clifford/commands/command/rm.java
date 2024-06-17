package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.cli.Interpreter;
import edu.austral.ingsis.clifford.filesystem.Archive;
import edu.austral.ingsis.clifford.filesystem.Directory;
import edu.austral.ingsis.clifford.filesystem.File;

import java.util.List;

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
    List<Archive> files = interpreter.getCurrentDirectory().getFiles();

    return "";
  }

  private String simpleRemoval(String fileName, Interpreter interpreter) {
    Directory directory = interpreter.getCurrentDirectory();
    Archive result = directory.findArchive(fileName);
    if (result == null) {
      return "could not find file '" + fileName + "'";
    } else {
      return processResult(result, fileName, directory);
    }

  }

  private String processResult(Archive result, String fileName, Directory directory) {
    if (result instanceof Directory) {
      return "cannot remove '" + result.getName() + "' is a directory";
    } else {
      directory.removeFile(fileName);
      return "'" + fileName + "' file removed";
    }
  }
}
