package com.apeace.markdownpreview;

import org.junit.Test;

import static org.junit.Assert.*;

import com.apeace.markdownpreview.util.MarkdownUtils;

public class MarkdownUtilsTest {

    @Test
    public void markdownToHtml() throws Exception {
        String markdown = "This is **bold**";
        String html = "<p>This is <strong>bold</strong></p>";
        String result = MarkdownUtils.markdownToHtml(markdown);
        assertEquals(html, result);
    }

}