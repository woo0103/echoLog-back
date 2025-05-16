package com.deli.echolog.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtil {
    public static Long getLoginMemberId() {
        return (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
