##기능 목록

### 입력을 담당하는 클래스 ClassName - InputView
- [ ] 메인 입력 받기 - #insertMain()
- [ ] 기능 입력 받기 - #intsertFunction()
- [ ] 출발역 입력받기 - #insertStart()
- [ ] 도착역 입력 받기 - #insertDestination()
---
### 출력을 담당하는 클래스 ClassName - OutputView 
- [ ] 메인 화면 - #showMain()
- [ ] 기능 선택 - #askFunction()
- [ ] 기준 선택 - #askDomain()
- [ ] 출발역 요청 - #askStart()
- [ ] 도착역 요청 - #askDestination()
- [ ] 결과 출력 - #printResult()
---
### 역의 정보를 저장하는 클래스 ClassName - Station
- 서비스 - StationService
  - [x] 역 생성 - #createStations()
- 레포지토리 - StationRepository
  - [x] 역 전체 저장 - #saveAll()
---
### 노선의 정보를 저장하는 클래스 ClassName - Line
- 서비스 - LineService
  - [x] 노선 생성 - #createLine()
  - [x] 역 이름으로 노선 조회 - #getLinesByStationName()
- 레포지토리 - LineRepository
  - [x] 노선 전체 저장 - #saveAll()
  - [x] 역 이름으로 노선 조회 - #findLinesByStationName()
---
### 환승 역들을 기준으로 구간들을 나누어 저장 ClassName - Section
- 도메인 - Section
  - [x] 소요 시간 조회 - #getTime()
  - [x] 거리 조회 - #getDistance()
  
- 서비스 - SectionService
  - [x] 구간 생성 - #createSection()
  - [x] 구간의 시작점 조회 - #getSectionStart()
  - [x] 구간의 종료지점 조회 - #getSectionEnd()
  - [ ] 구간의 소요 시간 조회 - #getSectionTime()
  - [ ] 구간의 거리 조회 - #getSectionDistance()
- 레포지토리 - SectionRepository
  - [ ] 구간 저장 - #save()
  - [ ] 구간의 시작점으로 조회 - #findSectionsByStart()
  - [ ] 구간의 종료지점으로 조회 - #findSectionsByEnd()
---

