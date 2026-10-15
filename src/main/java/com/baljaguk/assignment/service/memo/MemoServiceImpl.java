package com.baljaguk.assignment.service.memo;

import com.baljaguk.assignment.domain.memo.repository.MemoRepository;
import com.baljaguk.assignment.common.exception.MemoNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemoServiceImpl implements MemoService {

    private final MemoRepository memoRepository;

    public MemoServiceImpl(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    @Override
    public void delete(Long memoId) {
        var memo = memoRepository.findById(memoId)
                .orElseThrow(MemoNotFoundException::new);

        memoRepository.delete(memo);
    }
}
