# 메모 API 명세

## 공통

- Base URL: `/api/v1/memos`
- Content-Type: `application/json`
- 날짜 형식: ISO-8601 UTC (`2026-10-15T09:30:00Z`)

### Memo 객체

| 필드 | 타입 | 설명 |
| --- | --- | --- |
| `id` | `Long` | 메모 식별자 |
| `title` | `String` | 제목 (1~100자) |
| `content` | `String` | 내용 (1~2,000자) |
| `createdAt` | `String` | 생성 시각 |
| `updatedAt` | `String` | 마지막 수정 시각 |

---

## 1. 메모 생성

`POST /api/v1/memos`

### 요청 본문

```json
{
  "title": "장보기",
  "content": "우유, 계란, 빵"
}
```

### 성공 응답 — 201 Created

```json
{
  "id": 1,
  "title": "장보기",
  "content": "우유, 계란, 빵",
  "createdAt": "2026-10-15T09:30:00Z",
  "updatedAt": "2026-10-15T09:30:00Z"
}
```

## 2. 메모 목록 조회

`GET /api/v1/memos`

### 성공 응답 — 200 OK

```json
[
  {
    "id": 1,
    "title": "장보기",
    "content": "우유, 계란, 빵",
    "createdAt": "2026-10-15T09:30:00Z",
    "updatedAt": "2026-10-15T09:30:00Z"
  }
]
```

## 3. 메모 단건 조회

`GET /api/v1/memos/{memoId}`

### 경로 변수

| 이름 | 타입 | 설명 |
| --- | --- | --- |
| `memoId` | `Long` | 조회할 메모 ID |

### 성공 응답 — 200 OK

```json
{
  "id": 1,
  "title": "장보기",
  "content": "우유, 계란, 빵",
  "createdAt": "2026-10-15T09:30:00Z",
  "updatedAt": "2026-10-15T09:30:00Z"
}
```

## 4. 메모 수정

`PUT /api/v1/memos/{memoId}`

### 요청 본문

```json
{
  "title": "마트 장보기",
  "content": "우유, 계란, 빵, 커피"
}
```

### 성공 응답 — 200 OK

```json
{
  "id": 1,
  "title": "마트 장보기",
  "content": "우유, 계란, 빵, 커피",
  "createdAt": "2026-10-15T09:30:00Z",
  "updatedAt": "2026-10-15T10:00:00Z"
}
```

## 5. 메모 삭제

`DELETE /api/v1/memos/{memoId}`

### 성공 응답 — 204 No Content

응답 본문이 없습니다.

---

## 오류 응답

### 400 Bad Request — 유효성 검증 실패

```json
{
  "code": "VALIDATION_ERROR",
  "message": "title은 1자 이상 100자 이하여야 합니다."
}
```

### 404 Not Found — 메모 없음

```json
{
  "code": "MEMO_NOT_FOUND",
  "message": "메모를 찾을 수 없습니다."
}
```
