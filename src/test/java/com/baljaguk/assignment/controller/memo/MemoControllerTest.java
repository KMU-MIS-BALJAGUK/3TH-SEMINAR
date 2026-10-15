package com.baljaguk.assignment.controller.memo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.baljaguk.assignment.domain.memo.entity.Memo;
import com.baljaguk.assignment.domain.memo.repository.MemoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MemoRepository memoRepository;

    @AfterEach
    void tearDown() {
        memoRepository.deleteAll();
    }

    @Test
    void deletesExistingMemo() throws Exception {
        Memo memo = memoRepository.save(new Memo("삭제할 메모", "내용"));

        mockMvc.perform(delete("/api/v1/memos/{memoId}", memo.getId()))
                .andExpect(status().isNoContent());

        assertThat(memoRepository.existsById(memo.getId())).isFalse();
    }

    @Test
    void returnsNotFoundWhenMemoDoesNotExist() throws Exception {
        mockMvc.perform(delete("/api/v1/memos/{memoId}", 999L))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("MEMO_NOT_FOUND"))
                .andExpect(jsonPath("$.message").value("메모를 찾을 수 없습니다."));
    }
}
