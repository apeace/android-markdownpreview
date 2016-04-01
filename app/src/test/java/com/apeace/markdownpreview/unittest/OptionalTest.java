package com.apeace.markdownpreview.unittest;

import org.junit.Test;

import static org.junit.Assert.*;

import com.apeace.markdownpreview.util.Optional;

import java.util.NoSuchElementException;

public class OptionalTest {

    @Test
    public void empty_isPresent() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    public void empty_orElse() {
        Optional<String> empty = Optional.empty();
        assertEquals(empty.orElse("other"), "other");
    }

    @Test(expected = NoSuchElementException.class)
    public void empty_get() {
        Optional<String> empty = Optional.empty();
        empty.get();
    }

    @Test
    public void of_isPresent() {
        Optional<String> nonEmpty = Optional.of("something");
        assertTrue(nonEmpty.isPresent());
    }

    @Test
    public void of_orElse() {
        Optional<String> nonEmpty = Optional.of("something");
        assertEquals(nonEmpty.orElse("other"), "something");
    }

    @Test
    public void of_get() {
        Optional<String> nonEmpty = Optional.of("something");
        assertEquals(nonEmpty.get(), "something");
    }

    @Test(expected = NullPointerException.class)
    public void of_null() {
        Optional.of(null);
    }

    @Test
    public void ofNullable_null() {
        Optional<String> empty = Optional.ofNullable(null);
        assertFalse(empty.isPresent());

    }

    @Test
    public void ofNullable_nonNull() {
        Optional<String> empty = Optional.ofNullable("something");
        assertTrue(empty.isPresent());

    }

}
