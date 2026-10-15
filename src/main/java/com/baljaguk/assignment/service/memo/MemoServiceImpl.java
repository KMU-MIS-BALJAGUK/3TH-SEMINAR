package com.baljaguk.assignment.service.memo;

import com.baljaguk.assignment.domain.memo.repository.MemoRepository;
import org.springframework.stereotype.Service;

@Service
public class MemoServiceImpl implements MemoService {

    private final MemoRepository memoRepository;

    public MemoServiceImpl(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }
}
