package com.pluralsight.model.states;

import com.pluralsight.model.entities.Item;

/**
 * Represents the state of an item that has been reported as lost.
 * Part of the State pattern implementation for Item state management.
 * Disallows both borrowing and return operations since the item is not available.
 * Can only transition to available state through admin intervention.
 * 
 * Note: This state is currently not used in the system but is provided for future extension.
 *
 * @author Library Management System Team
 * @version 1.0
 */
public class LostState extends ItemState {
    public LostState(Item item) {
        super(item);
    }
    
    @Override
    public boolean borrow() {
        return false; // Cannot borrow a lost item
    }
    
    @Override
    public boolean returnItem() {
        return false; // Cannot return a lost item
    }
    
    @Override
    public String getStatus() {
        return "Lost";
    }
    
    @Override
    public boolean canBorrow() {
        return false;
    }
}