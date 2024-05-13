# Docker 와 IntelliJ 를 연결하는 방법

- 테스트를 하던 중 로컬PC 에 Docker 를 설치하기 싫어졌다.
- 그래서 평소 사용하던 VMWARE 내 Docker 와 IntelliJ 를 연결하려니까 방법이 따로 존재하는 것으로 보였다.
- 고난과 역경을 추가한다.

[기본확인사항]
1. systemctl status firewalld <- 나는 내꺼니까 내 마음대로 shutdown 시켜버릴거다.
2. ping {VMWAREIP}
3. telnet {VMWAREIP} 2375

[IntelliJ]
- 입력방법 : tcp://{VMWAREIP}:2375
- 참고 : https://log-laboratory.tistory.com/190
