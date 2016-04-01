package com.apeace.markdownpreview.util;

import com.github.rjeschke.txtmark.Processor;

public final class MarkdownUtils {

    public static String markdownToHtml(String html) {
        return Processor.process(html).trim();
    }

}
