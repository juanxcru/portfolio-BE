package com.juan.portfolio.client;

public record GitHubClientProps(
        String baseUrl,
        String token,
        String userAgent,
        String username) {}
