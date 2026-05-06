package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    //lowerCamelCase - methods and variables
    //UpperCamelCase or PasCalCase - Classes
    //snake_case - unit tests, file names, other things
    //kebab-case - java project names / repo names

    @Test
    void checkIn_should_make_room_unavailable() {
        //arrange
        Room testRoom = new Room(1, 149.00, false, false);

        //act
        testRoom.checkIn();

        //assert
        assertFalse(testRoom.isAvailable());
        assertEquals(testRoom.isAvailable(), false);
    }

    @org.junit.jupiter.api.Test
    void checkIn_shouldnt_make_room_available() {
        //arrange
        Room testRoom = new Room(1, 149.00, false, false);

        //act
        testRoom.checkIn();

        //assert
        assertTrue(!testRoom.isAvailable());
        assertEquals(true, !testRoom.isAvailable());
    }

    @org.junit.jupiter.api.Test
    void checkout_should_make_room_unoccupied() {
        //arrange a room that is currently checked in
        Room testRoom = new Room(1, 149.00, true, true);

        //act

        testRoom.checkOut();

        //assert
        assertFalse(testRoom.isOccupied());
        assertFalse(testRoom.isAvailable());
    }

    @org.junit.jupiter.api.Test
    void cleanroom_should_make_room_not_dirty() {
        //arrange a room that is currently checked in
        Room testRoom = new Room(1, 149.00, true, true);

        //act
        testRoom.cleanRoom();

        //assert
        assertFalse(testRoom.isDirty());
    }
}