package com.cinema.controller;

import com.cinema.dto.ApiResponse;
import com.cinema.dto.LoginRequest;
import com.cinema.dto.RegisterRequest;
import com.cinema.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/member")
@CrossOrigin(origins = "*") // 允许所有前端访问，开发时使用
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 会员登录接口
     */
    @PostMapping("/login")
    public ApiResponse<Map<String, Object>> login(@RequestBody LoginRequest request) {
        // 调用Service层处理登录
        Map<String, Object> result = memberService.login(
                request.getPhone(),
                request.getPassword()
        );

        // 包装成统一响应格式 - 修复类型问题
        if ((Boolean) result.get("success")) {
            String message = (String) result.get("message"); // 显式转换为String
            return ApiResponse.success(message, result);
        } else {
            String errorMessage = (String) result.get("message"); // 显式转换为String
            return ApiResponse.error(errorMessage);
        }
    }

    /**
     * 会员注册接口
     */
    @PostMapping("/register")
    public ApiResponse<Map<String, Object>> register(@RequestBody RegisterRequest request) {
        // 调用Service层处理注册
        Map<String, Object> result = memberService.register(
                request.getNick(),
                request.getPhone(),
                request.getPassword()
        );

        // 包装成统一响应格式 - 修复类型问题
        if ((Boolean) result.get("success")) {
            String message = (String) result.get("message"); // 显式转换为String
            return ApiResponse.success(message, result);
        } else {
            String errorMessage = (String) result.get("message"); // 显式转换为String
            return ApiResponse.error(errorMessage);
        }
    }

    /**
     * 获取会员信息
     */
    @GetMapping("/info/{audienceId}")
    public ApiResponse<Map<String, Object>> getMemberInfo(@PathVariable String audienceId) {
        Map<String, Object> result = memberService.getMemberInfo(audienceId);

        // 包装成统一响应格式 - 修复类型问题
        if ((Boolean) result.get("success")) {
            String message = (String) result.get("message"); // 显式转换为String
            return ApiResponse.success(message, result);
        } else {
            String errorMessage = (String) result.get("message"); // 显式转换为String
            return ApiResponse.error(errorMessage);
        }
    }
    @GetMapping("/test")
    public String testEndpoint() {
        return "测试端点正常工作 - " + System.currentTimeMillis();
    }
    /**
     * 健康检查接口（测试用）
     */
    @GetMapping("/health")
    public String healthCheck() {
        return "会员模块运行正常 - " + System.currentTimeMillis();
    }
}