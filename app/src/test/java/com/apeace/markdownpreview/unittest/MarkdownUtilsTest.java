package com.apeace.markdownpreview.unittest;

import org.junit.Test;

import static org.junit.Assert.*;

import com.apeace.markdownpreview.util.MarkdownUtils;

public class MarkdownUtilsTest {

    @Test
    public void markdownToHtml() {
        String markdown = "This is **bold**";
        String html = "<p>This is <strong>bold</strong></p>";
        String result = MarkdownUtils.markdownToHtml(markdown);
        assertEquals(html, result);
    }

    @Test
    public void markdownConstructor() {
        // does nothing. just here to provide coverage of constructor
        MarkdownUtils mu = new MarkdownUtils();
    }

}