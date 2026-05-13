package com.pluralsight.model.states;

import com.pluralsight.model.entities.Item;

/**
 * Represents the state of an item that is currently borrowed.
 * Part of the State pattern implementation for Item state management.
 * Allows return operations but disallows additional borrowing operations.
 *
 * @author Library Management System Team
 * @version 1.0
 */
public class BorrowedState extends ItemState {
    public BorrowedState(Item item) {
        super(item);
    }
    
    @Override
    public boolean borrow() {
        return false; // Cannot borrow an already borrowed item
    }
    
    @Override
    public boolean returnItem() {
        item.setState(new AvailableState(item));
        return true;
    }
    
    @Override
    public String getStatus() {
        return "Borrowed";
    }
    
    @Override
    public boolean canBorrow() {
        return false;
    }
}