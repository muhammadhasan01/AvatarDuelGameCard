/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avatarduel.factory;

import com.avatarduel.model.*;

/**
 *
 * @author Muhammad Hasan - 13518012
 */
public interface CardFactory {
    public Card makeCard(String name, String desc, String path, Element element);
}
