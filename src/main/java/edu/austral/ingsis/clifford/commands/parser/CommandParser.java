package edu.austral.ingsis.clifford.commands.parser;

import edu.austral.ingsis.clifford.commands.command.Command;

public interface CommandParser {
  Command parse(String command);
}
