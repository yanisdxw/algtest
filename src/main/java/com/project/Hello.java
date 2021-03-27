package com.project;

import java.util.ArrayList;
import java.util.List;

public class Hello {

    private final String[] tags;

    public Hello(String[] tags) {
        this.tags = tags;
    }

    public List<String> say() {
        List<String> params = new ArrayList<>();

        if (tags != null) {
            for (int i = 0; i < tags.length; i++) {
                String tag = tags[i];
                if (tag != null) {
                    params.add("tags=" + tag);
                }
            }
        }
        return params;
    }
}
