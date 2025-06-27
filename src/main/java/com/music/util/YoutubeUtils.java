package com.music.util;

import org.springframework.stereotype.Component;

@Component
public class YoutubeUtils {
    public static String extractYoutubeId(String url) {
        if (url == null || !url.contains("/embed/")) return null;
        return url.substring(url.indexOf("/embed/") + "/embed/".length());
    }
}
