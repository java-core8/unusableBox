package ru.tcreator;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    Box box = new Box();
    User user = new User(box);

    Thread userThread = new Thread(user);

    userThread.start();
    userThread.join();
  }
}
