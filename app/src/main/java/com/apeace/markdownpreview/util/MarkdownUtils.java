package com.apeace.markdownpreview.util;

import com.github.rjeschke.txtmark.Processor;

public class MarkdownUtils {

    public static String markdownToHtml(String html) {
        return Processor.process(html).trim();
    }

}
