package edu.austral.ingsis.clifford.cli;

import edu.austral.ingsis.clifford.filesystem.Directory;

public interface Interpreter {
  void execute(String command);

  Directory getCurrentDirectory();

  Directory getRoot();

  void setDirectory(Directory directory);
}
