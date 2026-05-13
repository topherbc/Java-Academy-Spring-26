package com.pluralsight.model.states;

import com.pluralsight.model.entities.Item;

/**
 * Abstract base class for implementing the State pattern for Item status.
 * Defines the operations that all item states must support and maintains
 * a reference to the item whose state is being managed.
 * Concrete implementations include AvailableState, BorrowedState, and others.
 *
 * @author Library Management System Team
 * @version 1.0
 */
public abstract class ItemState {
    protected Item item;
    
    public ItemState(Item item) {
        this.item = item;
    }
    
    public abstract boolean borrow();
    public abstract boolean returnItem();
    public abstract String getStatus();
    public abstract boolean canBorrow();
}