/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.factory;

import com.avatarduel.model.Card;
import com.avatarduel.model.Element;
import com.avatarduel.model.Land;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public class LandFactory implements CardFactory {
    @Override
    public Land makeCard(String name, String desc, String path, Element element) {
        return new Land(name, desc, path, element);
    }
}
