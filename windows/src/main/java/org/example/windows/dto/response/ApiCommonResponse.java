package org.example.windows.dto.response;

public record ApiCommonResponse<T>(
        String status,
        String message,
        T data
) {
    public static <T> ApiCommonResponse<T> success(T data) {
        return new ApiCommonResponse<>("200", "success", data);
    }

    public static <T> ApiCommonResponse<T> fail(String message) {
        return new ApiCommonResponse<>("500", message, null);
    }
}