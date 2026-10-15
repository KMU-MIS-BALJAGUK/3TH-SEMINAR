package com.baljaguk.assignment.controller.memo;

import com.baljaguk.assignment.service.memo.MemoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 메모 API를 위한 프레젠테이션 계층입니다.
 */
@RestController
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @Operation(summary = "메모 삭제")
    @DeleteMapping("/api/v1/memos/{memoId}")
    public ResponseEntity<Void> delete(@PathVariable Long memoId) {
        memoService.delete(memoId);
        return ResponseEntity.noContent().build();
    }
}
