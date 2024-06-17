package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.cli.Interpreter;
import edu.austral.ingsis.clifford.filesystem.Archive;
import edu.austral.ingsis.clifford.filesystem.Directory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ls implements Command {

  @Override
  public String execute(String[] splitCommand, Interpreter interpreter) {
    Directory currentDir = interpreter.getCurrentDirectory();
    if (splitCommand.length == 1) {
      return loadFiles(currentDir);
    } else {
      return printAccordingToParameters(currentDir, splitCommand);
    }
  }

  private String printAccordingToParameters(Directory directory, String[] splitCommand) {
    String[] splitParam = splitCommand[1].split("=");
    StringBuilder output = new StringBuilder();
    List<String> files = loadFilesToString(directory);
    if (splitParam[1].equals("asc")) {
      Collections.sort(files);
    } else {
      files.sort(Collections.reverseOrder());
    }
    return buildString(output, files);
  }

  private String buildString(StringBuilder output, List<String> files) {
    if (files.size() > 1) {
      loadFilesWithSpaces(output, files);
    } else {
      output.append(files.getFirst());
    }
    return output.toString();
  }

  private void loadFilesWithSpaces(StringBuilder output, List<String> files) {
    output.append(files.get(0));
    for (int i = 1; i < files.size(); i++) {
      output.append(" ").append(files.get(i));
    }
  }

  private String loadFiles(Directory directory) {
    StringBuilder res = new StringBuilder();
    List<Archive> files = directory.getFiles();
    if (!files.isEmpty()) {
      if (files.size() > 1) {
        loadFilesWithSpaces(res, loadFilesToString(directory));
      } else {
        res.append(files.getFirst());
      }
    }
    return res.toString();
  }

  private List<String> loadFilesToString(Directory directory) {
    List<String> res = new ArrayList<>();
    for (Archive file : directory.getFiles()) {
      res.add(file.toString());
    }
    return res;
  }
}
