# Tomcat JAR Scanner

## JAR Scanner
: JAR Scanner 는  JAR 파일이나 클레스 파일 디렉터리를 스캔하가 위해 사용되는 컴포넌트이다   
: 일반적으로 웹 어플리케이션 구동될 때 인식한다
: JAR Scanner 는 context.xml 파일에 선언된다.
: JAR Scanner 설정이 포함되어 있지 않으면 기본적으로 자동 생성된다.

```

```

## JAR Scanner Filter

jar scanner 결과가 어플리케이션으로 돌아가기 전에 결과를 필터하는 컴포넌트이다   
일반적으로는 자르 스캔을 스킵하는 용도로 쓰인다
-> 특정 자르들로 인한 종속성 출돌이 발생할 때도 사용가능

CATALINA_HOME/confg/catalina.properties 
jarstoSkip 에 스킵할 자르 파일을 입력
저장 후 재기동


