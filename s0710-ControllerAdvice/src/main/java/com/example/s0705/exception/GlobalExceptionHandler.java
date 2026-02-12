package com.example.s0705.exception;

import com.example.s0705.entity.ThongBaoLoi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Nơi bắt lỗi của tất cả các thành phần khác trong dự án
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ThongBaoLoi> batloi(StudentException se){
        ThongBaoLoi er = new ThongBaoLoi(HttpStatus.NOT_FOUND.value(), se.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    // Ko lên tự tiện dùng cách này
    @ExceptionHandler
    public ResponseEntity<ThongBaoLoi> batloitatca(Exception ex){
        ThongBaoLoi er = new ThongBaoLoi(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }
}
