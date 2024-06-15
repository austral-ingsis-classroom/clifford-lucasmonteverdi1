package edu.austral.ingsis.clifford.filesystem;

import java.util.List;

public class Directory implements Archive {
  private List<Archive> files;
  private String name;
  private String path;

  public Directory(String name, String path) {
    this.name = name;
    this.path = path;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getPath() {
    return path;
  }

  @Override
  public String toString() {
    return name;
  }

  public List<Archive> getFiles() {
    return files;
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

  private Archive findFile(String name, List<Archive> files) {
    for (Archive file : files) {
      if (file instanceof File && file.getName().equals(name)) {
        return file;
      }
    }
    return null;
  }

  /* rm --recursive */
  public void removeDirectory(Archive directory) {
    this.files.remove(directory);
  }
}
