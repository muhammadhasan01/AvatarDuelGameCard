/**
 * Class to handle card land
 */
package com.avatarduel.model;

public class Land extends Card {

  public Land() {
    super();
  }
  
  public Land(Land LL) {
      super(LL);
  }

  public Land(String name, String description, String imagePath, Element element) {
    super(name, description, imagePath, element);
  }
}