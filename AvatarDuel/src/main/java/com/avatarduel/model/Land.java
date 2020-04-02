package com.avatarduel.model;

public class Land {
  private String name;
  private String description;
  private String imagePath;
  private Element element;

  public Land() {
    this.name = "";
    this.description = "";
    this.imagePath = "";
    this.element = Element.AIR;
  }

  public Land(String name, String description, Element element, String imagePath) {
    this.name = name;
    this.description = description;
    this.element = element;
    this.imagePath = imagePath;
  }
}