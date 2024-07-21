package com.rahul.crack_your_placement.string;

import java.util.ArrayDeque;

public class Q08_SimplifyPath {
    public String simplifyPath(String path) {
        ArrayDeque<String> dirs = new ArrayDeque<>();


        int index = 0;
        int len = path.length();
        while(index < len) {
            index++;

            int start = index;
            while(index < len && path.charAt(index) != '/')
                index++;

            String dir = path.substring(start, index);

            if(dir.equals(".."))
                dirs.pollLast();
            else if (!dir.equals(".") && !dir.isEmpty())
                dirs.offer(dir);
        }

        if(dirs.isEmpty()) return "/";

        dirs.offerFirst("");
        return String.join("/", dirs);
    }
}
