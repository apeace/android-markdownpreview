package com.apeace.markdownpreview.unittest;

import org.junit.Test;

import static org.junit.Assert.*;

import com.apeace.markdownpreview.util.Optional;

import java.util.NoSuchElementException;

public class OptionalTest {

    @Test
    public void emptyIsPresent() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    public void emptyOrElse() {
        Optional<String> empty = Optional.empty();
        assertEquals(empty.orElse("other"), "other");
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyGet() {
        Optional<String> empty = Optional.empty();
        empty.get();
    }

    @Test
    public void ofIsPresent() {
        Optional<String> nonEmpty = Optional.of("something");
        assertTrue(nonEmpty.isPresent());
    }

    @Test
    public void ofOrElse() {
        Optional<String> nonEmpty = Optional.of("something");
        assertEquals(nonEmpty.orElse("other"), "something");
    }

    @Test
    public void ofGet() {
        Optional<String> nonEmpty = Optional.of("something");
        assertEquals(nonEmpty.get(), "something");
    }

    @Test(expected = NullPointerException.class)
    public void ofNull() {
        Optional.of(null);
    }

    @Test
    public void ofNullableNull() {
        Optional<String> empty = Optional.ofNullable(null);
        assertFalse(empty.isPresent());
    }

    @Test
    public void ofNullableNonNull() {
        Optional<String> empty = Optional.ofNullable("something");
        assertTrue(empty.isPresent());
    }

}
