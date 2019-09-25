package com.epam.rd.spring2019.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class SecurityConfig {

    private Set<String> protectedURLs = new HashSet<>();

    public SecurityConfig() {
        protectedURLs.add("/add");
    }

    public Set<String> getProtectedURLs() {
        return Collections.unmodifiableSet(protectedURLs);
    }
}
