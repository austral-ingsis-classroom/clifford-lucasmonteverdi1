package edu.austral.ingsis.clifford.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory implements Archive {
  private List<Archive> files;
  private Directory parent;
  private String name;
  private String path;

  public Directory(String name, String path, Directory parent) {
    this.name = name;
    this.path = path;
    this.parent = parent;
    this.files = new ArrayList<>();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Directory directory)) return false;
    return Objects.equals(parent, directory.parent)
        && Objects.equals(name, directory.name)
        && Objects.equals(path, directory.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parent, name, path);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getPath() {
    return path;
  }

  public Directory getParent() {
    return parent;
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
    for (Archive file : files) {
      if (file.getName().equals(name) && file instanceof File) {
        files.remove(file);
        return;
      }
    }
  }

  public Archive findArchive(String name) {
    for (Archive file : files) {
      if (file.getName().equals(name)) {
        return file;
      }
    }
    return null;
  }

  /* rm --recursive */
  public void removeDirectory(Archive directory) {
    files.remove(directory);
  }
}
