package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.cli.Interpreter;
import edu.austral.ingsis.clifford.filesystem.Archive;
import edu.austral.ingsis.clifford.filesystem.Directory;
import java.util.List;

public class cd implements Command {

  @Override
  public String execute(String[] splitCommand, Interpreter interpreter) {
    String destination = splitCommand[1];
    if (destination.charAt(0) == '.') {
      return processCompositeArgument(destination, interpreter);
    } else if (destination.charAt(0) == '/') {
      return processDestinationFromRoot(destination, interpreter);
    } else {
      return processRoute(destination, interpreter);
    }
  }

  private String processRoute(String destination, Interpreter interpreter) {
    String[] splitRoute = destination.split("/");
    Directory currentDir = interpreter.getCurrentDirectory();
    List<Archive> dirFiles = currentDir.getFiles();
    if (splitRoute.length == 1) {
      /* Case "cd Desktop" */
      Directory res = findDirectory(splitRoute[0], dirFiles);
      if (res != null) {
        interpreter.setDirectory(res);
        return "moved to directory '" + res.getName() + "'";
      } else {
        return "Directory with name '" + splitRoute[0] + "' not found";
      }
    } else {
      /* Case "cd Desktop/Austral" */
      return findCompositeDirectory(splitRoute, interpreter, interpreter.getCurrentDirectory());
    }
  }

  private String findCompositeDirectory(
      String[] splitRoute, Interpreter interpreter, Directory currentDir) {
    for (String subDir : splitRoute) {
      List<Archive> files = currentDir.getFiles();
      Directory res = findDirectory(subDir, files);
      if (res == null) {
        return "Directory with name '" + subDir + "' not found";
      } else {
        currentDir = res;
      }
    }
    interpreter.setDirectory(currentDir);
    return "moved to directory '" + currentDir.getName() + "'";
  }

  private Directory findDirectory(String route, List<Archive> files) {
    for (Archive archive : files) {
      if (archive.getName().equals(route) && archive instanceof Directory) {
        return (Directory) archive;
      }
    }
    return null;
  }

  private String processDestinationFromRoot(String destination, Interpreter interpreter) {
    String[] splitRoute = destination.split("/");
    return findCompositeDirectory(splitRoute, interpreter, interpreter.getRoot());
  }

  /* First char of argument is '.' */
  private String processCompositeArgument(String destination, Interpreter interpreter) {
    Directory currentDir = interpreter.getCurrentDirectory();
    if (destination.charAt(1) == '.') {
      interpreter.setDirectory(currentDir.getParent());
      currentDir = interpreter.getCurrentDirectory();
    }
    String finalDir = currentDir.getName();
    return "moved to directory '" + finalDir + "'";
  }
}
