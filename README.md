# 🧭 수지네 심리 탐험소
## 📝 개요
심리 테스트를 통해 나를 이해할 수 있는 프로그램

## 🚀 실행 방법
1. 컴파일
```bash
javac -cp "lib/*" -d out src/**/*.java
```
2. 실행
```bash
# Linux/Mac
java -cp "lib/*:out" Main
# Windows
java -cp "lib/*;out" Main
```
## 🎬 실행화면
![Image](https://github.com/user-attachments/assets/3c09ef72-4751-4c82-a9a2-8900404de295)

## 👥 유저 시나리오

1. 심리 테스트 목록 조회
2. 심리 테스트 선택
3. 심리 테스트 진행
4. 심리 테스트 결과 조회
5. 새로운 심리 테스트 진행 또는 종료

## ⭐ 주요 기능
- [x] 심리 테스트 목록 조회
- [x] 심리 테스트 진행
- [x] 심리 테스트 결과 조회
- [x] 새로운 심리 테스트 진행 또는 종료
- [x] 입력 예외처리

## 📁 폴더 구조
```
├── README.md
├── lib
│   └── gson-2.10.1.jar
└── src
    ├── Main.java
    ├── manager
    │   └── FlowManager.java
    └── surveys
        ├── Survey.java
        ├── answer
        │   ├── FiveLevelAnswer.java
        │   └── ThreeLevelAnswer.java
        └── types
            ├── LifeSatisfactionSurvey.java
            ├── LoveTypeSurvey.java
            ├── StressSurvey.java
            └── surveys.json
```
## 📊 클래스 다이어 그램
![class diagram](https://github.com/user-attachments/assets/b9830383-0573-43c9-a0e3-0c013f8b95c3)

## 📚 외부 라이브러리
### Gson 2.10.1
- 위치 : `lib/gson-2.10.1.jar`
- 용도 : JSON 파싱

## 💭 회고

실제 서비스가 된다면 어떤 부분을 신경 써야할지 확장성과 유지보수성 측면에서 고민을 했습니다. 

### 1. 심리 테스트 종류 추가

새로운 심리 테스트를 쉽게 추가할 수 있도록 설계하였습니다.

**구현 방식:**
- 추상 클래스를 통한 필수 메서드 명시
- 공통 기능은 최상위 부모 클래스에서 구현
- 하위 설문 클래스는 설문별 특화 로직만 구현
- FlowManager에서 생성자 인수로 새로운 심리 테스트를 추가하면 즉시 적용되도록 구현

### 2. 응답 선택지 변동

응답 선택지 수준을 유연하게 변경할 수 있도록 설계하였습니다.
(예: 3점 척도 → 5점 척도)

**구현 방식:**
- 응답 선택지 타입을 상속 구조로 설계
- FiveLevelAnswer, ThreeLevelAnswer 등 선택지 클래스 구현
- 선택지 변경 시 해당 클래스만 수정하면 되도록 설계

### 3. 심리 테스트 문항 문구 변동

테스트 문항 문구를 유연하게 관리할 수 있도록 설계하였습니다.

**구현 방식:**
- 문항과 결과 문구를 JSON 파일로 외부 관리
- 설문 내용 수정 시 소스 코드 변경 없이 JSON 파일만 수정

C++ 경험은 있지만 자바는 처음이었어서 컨벤션, Scanner, 외부 라이브러리 (gson) 추가할 때 어려움을 겪었었습니다.

### 기타 사항

- 심리 테스트 문항과 결과 문구는 Claude 의 도움을 받아 작성되었습니다.