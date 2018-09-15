/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.armorplus.items.enums;

/**
 * @author Sokratis Fotkatzikis - TheDragonTeam
 **/
public enum MetalItems {
    ELECTRICAL_INGOT("electrical_ingot", 0),
    STEEL_INGOT("steel_ingot", 1);

    private final String name;

    private final int id;

    MetalItems(String nameIn, int ID) {
        this.name = nameIn;
        this.id = ID;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return id;
    }
}
