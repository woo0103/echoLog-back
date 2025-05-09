package com.deli.echolog.config;

import com.deli.echolog.interceptor.LoginCheckInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns(
                        "http://localhost:[*]", // 로컬 개발 (모든 포트 허용)
                        "https://your-app-domain.com", // 실제 배포 도메인
                        "http://192.168.1.*" // 로컬 네트워크 테스트 (예: 모바일 기기)
                ) // 모든 경로 요청 허용
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/api/**") // 모든 API에 적용
                .excludePathPatterns(
                        "/api/auth/login",         // 로그인
                        "/api/auth/logout",        // 로그아웃
                        "/api/members",       // 회원가입
                        "/error",             // 에러 경로
                        "/css/**", "/js/**", "/images/**" // 정적 리소스
                );
    }
}
