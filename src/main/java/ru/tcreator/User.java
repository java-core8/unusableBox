package ru.tcreator;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class User implements Runnable {
  protected Box box;

  public User(Box box) {
    this.box = box;
    Thread boxThread = new Thread(this.box);
    boxThread.setDaemon(true);
    boxThread.start();
  }

  @Override
  public void run() {
    int COUNT_TURN_ON = 7;
    for (int i = 0; i < COUNT_TURN_ON; i++) {
      try {
        TimeUnit.MILLISECONDS.sleep(randomDelayMs(2000,6000));
        box.click();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private int randomDelayMs(int min, int max) {
    Random random = new Random();
    return random.nextInt((max - min) + 1) + min;
  }
}
