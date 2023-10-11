package com.example.models;

import java.util.Objects;

public class Point {
  private final double x;
  private final double y;
  private final int r;

  private final boolean isInArea;

  public Point(double x, double y, int r) {
    this.x = x;
    this.y = y;
    this.r = r;
    this.isInArea = isInside(x, y, r);
  }

  private boolean isInside(double x, double y, double r) {
    // Top-right quadrant
    if (x >= 0 && y >= 0) {
      return (x * x + y * y) <= (r * r);
    }
    // Top-left quadrant
    if (x < 0 && y >= 0) {
      return (x >= -r / 2) && (y <= r / 2) && (2 *y - 2*x <= r);
    }
    // Bottom-left quadrant
    if (x < 0 && y < 0) {
      return (x >= -r / 2) && (y >= -r);
    }

    // Bottom-left quadrant
    return false;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public int getR() {
    return r;
  }

  public boolean isInArea() {
    return isInArea;
  }

}
