package ru.tcreator;

import java.util.concurrent.TimeUnit;

public class Box implements Runnable {
  protected volatile boolean checkOn = false;

  public void click() throws InterruptedException {
    if(!checkOn) {
      System.out.print("<<``` CLICK ```>>" + "\r");
      TimeUnit.MILLISECONDS.sleep(1500);
      checkOn = true;
    }
  }

  @Override
  public void run() {
    while (true) {
      if(checkOn) {
        closeBox();
        checkOn = false;
      }
    }
  }

  private void closeBox() {
    System.out.print("ヽ(￢_￢)ノ" + "\r");
    try {
      TimeUnit.MILLISECONDS.sleep(1500);
      System.out.print("(」°ロ°)」" + "\r");
      TimeUnit.MILLISECONDS.sleep(400);
      System.out.print("(╭°ロ°)╭" + "\r");
      TimeUnit.MILLISECONDS.sleep(400);
      System.out.print("(￢°ロ°)￢ <<BAM>>"  + "\r");
      TimeUnit.MILLISECONDS.sleep(400);
      System.out.print("\t\tBox was closed\t\t" + "\r");
      TimeUnit.MILLISECONDS.sleep(400);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
