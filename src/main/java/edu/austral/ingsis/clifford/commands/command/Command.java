package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.cli.Interpreter;

public interface Command {
  String execute(String[] splitCommand, Interpreter interpreter);
}
