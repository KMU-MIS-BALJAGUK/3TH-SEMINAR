package com.baljaguk.assignment.controller.memo;

import com.baljaguk.assignment.service.memo.MemoService;
import org.springframework.web.bind.annotation.RestController;

/**
 * 메모 API를 위한 프레젠테이션 계층입니다.
 * 요청 매핑은 API 구현 단계에서 추가합니다.
 */
@RestController
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }
}
