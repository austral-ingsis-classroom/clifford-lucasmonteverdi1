package edu.austral.ingsis.clifford;

import java.util.List;

public class Directory {
  private List<Archive> files;
  private String name;

  public Directory(String name) {
    this.name = name;
  }

  public List<Archive> getFiles() {
    return files;
  }

  public String getName() {
    return name;
  }

  /* 'touch' */
  public void addFile(Archive file) {
    this.files.add(file);
  }

  /* 'mkdir' */
  public void addDirectory(Archive directory) {
    this.files.add(directory);
  }

  /* 'rm' */
  public void removeFile(String name) {

  }

  private File findFile(String name, List<Archive> files) {
    for (Archive file : files) {
      if (file instanceof File && ((File) file).getFileName().equals(name)) {
        return (File) file;
      }
    }
    return null;
  }

  /* rm --recursive */
  public void removeDirectory(Archive directory) {
    this.files.remove(directory);
  }
}
