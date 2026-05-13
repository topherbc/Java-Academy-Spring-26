package com.pluralsight.model.states;

import com.pluralsight.model.entities.Item;

/**
 * Represents the state of an item that is available for borrowing.
 * Part of the State pattern implementation for Item state management.
 * Allows borrowing operations but disallows return operations.
 *
 * @author Library Management System Team
 * @version 1.0
 */
public class AvailableState extends ItemState {
    public AvailableState(Item item) {
        super(item);
    }
    
    @Override
    public boolean borrow() {
        item.setState(new BorrowedState(item));
        return true;
    }
    
    @Override
    public boolean returnItem() {
        return false; // Cannot return an available item
    }
    
    @Override
    public String getStatus() {
        return "Available";
    }
    
    @Override
    public boolean canBorrow() {
        return true;
    }
}