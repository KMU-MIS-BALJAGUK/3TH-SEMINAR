package com.baljaguk.assignment.domain.memo.repository;

import com.baljaguk.assignment.domain.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
