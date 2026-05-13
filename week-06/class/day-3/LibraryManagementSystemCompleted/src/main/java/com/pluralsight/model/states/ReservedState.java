package com.pluralsight.model.states;

import com.pluralsight.model.entities.Item;

/**
 * Represents the state of an item that is reserved for a future borrowing.
 * Part of the State pattern implementation for Item state management.
 * Allows borrowing operations (transition to BorrowedState) but disallows return operations.
 * 
 * Note: This state is currently not used in the system but is provided for future extension.
 *
 * @author Library Management System Team
 * @version 1.0
 */
public class ReservedState extends ItemState {
    public ReservedState(Item item) {
        super(item);
    }
    
    @Override
    public boolean borrow() {
        item.setState(new BorrowedState(item));
        return true;
    }
    
    @Override
    public boolean returnItem() {
        return false; // Cannot return a reserved item
    }
    
    @Override
    public String getStatus() {
        return "Reserved";
    }
    
    @Override
    public boolean canBorrow() {
        return true; // Reserved items can be borrowed by the person who reserved them
    }
}