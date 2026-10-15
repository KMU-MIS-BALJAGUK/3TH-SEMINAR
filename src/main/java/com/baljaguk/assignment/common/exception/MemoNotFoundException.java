package com.baljaguk.assignment.common.exception;

public class MemoNotFoundException extends RuntimeException {

    public MemoNotFoundException() {
        super("메모를 찾을 수 없습니다.");
    }
}
