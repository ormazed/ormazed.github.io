# Ch 08. 간단한 게시판 프로젝트
## 01. 간단한 게시판 시스템 설계
---

## 02. 간단한 게시판 테이블 설계
---

## 03. 간단한 게시판 개발하기 Entity 개발
---

#### ERROR
```
Caused by: javax.persistence.PersistenceException:
[PersistenceUnit: default] Unable to build Hibernate SessionFactory;
nested exception is org.hibernate.tool.schema.spi.SchemaManagementException:
Schema-validation: wrong column type encountered in column [content] in table [reply]; found [text (Types#LONGVARCHAR)], but expecting [varchar(255) (Types#VARCHAR)]
```
__@Column(columnDefinition = "TEXT")__   : 발생원인 - DB 에서는 TEXT 라고 작성했지만 JPA 에서는 단지 좀 큰 CHAR 로 인식하고 있어서 발생
-> 참고 : https://mycup.tistory.com/417   


## 04. 간단한 게시판 개발하기 API End Point 개발 - 1
---

## 05. 간단한 게시판 개발하기 API End Point 개발 - 2
---

## 06. 간단한 게시판 개발하기 API End Point 개발 - 3
---
#### 발생 에러
__[CASE1]__   
```
2024-05-10 01:13:29.027  WARN 12880 --- [nio-8080-exec-1] .w.s.m.s.DefaultHandlerExceptionResolver : 
Resolved [org.springframework.http.converter.HttpMessageNotReadableException: 
JSON parse error: Unexpected character ('"' (code 34)): was expecting a colon to separate field name and value; 
nested exception is com.fasterxml.jackson.core.JsonParseException: 
Unexpected character ('"' (code 34)): was expecting a colon to separate field name and value<EOL> 
at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 5, column: 11]]
```
> 호출한 API JSON Body 의 형식문제    

__[CASE2]__   
```
Caused by: javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is org.hibernate.MappingException: Could not determine type for: java.util.List, at table: post, for columns: [org.hibernate.mapping.Column(reply_list)]
```
> Entity 에 들어있는 변수들은 모두 DB 에 들어있다는 전제가 되어있는데 reply_list 가 DB 에 없기 때문에 발생한 에러   
> @Transient 을 달아서 DB 조회를 하지 않도록 제외할 수 있다.   


__[CASE3]__   
```
PostEntity.java:42: warning: @Builder will ignore the initializing expression entirely. 
If you want the initializing expression to serve as default, add @Builder.Default. 
If it is not supposed to be settable during building, make the field final.
    private List<ReplyEntity> replyList = Arrays.asList();
```
: 롬복의 @Builder 에 의해 발생한 경고문으로 롬복이 builder code 가 동작할 때 Arrays.asList() 초기화를 무시할 거라는 내용이다.   


## 07. 간단한 게시판 개발하기 JPA 연관관계 설정하기 -1
---

## 08. 간단한 게시판 개발하기 JPA 연관관계 설정하기 - 2
---


JPA 를 사용할 때 DB 와 연결짓는 방법으로 ORM 기술을 사용한다.   
@OneToOne, @OneToMany, @ManyToOne, @ManyToMany 등의 어노테이션은 N:N 관계를 스프링에게 알려주는 어노테이션이다



__[CASE01]__
Caused by: org.hibernate.AnnotationException: mappedBy reference an unknown target entity property: 
com.example.simpleboard.post.db.PostEntity.board in com.example.simpleboard.board.db.BoardEntity.postList
> 
boardEntity
```
    @OneToMany(
            mappedBy = "board"
    )
    private List<PostEntity> postList = List.of();
```
테이블 연관관계 매핑시 @OneToMany 어노테이션에 mappedBy 속성을 추가하였고 
PostEntity
```
private BoardEntity boardEntity; 
```
로 선언하는 바람에 mappedBy 가 board 를 찾아서 발생하는 현상이었다.


__[CASE02]__
```
Caused by: javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; 
nested exception is org.hibernate.MappingException: Could not determine type for: 
com.example.simpleboard.board.db.BoardEntity, at table: post, for columns: [org.hibernate.mapping.Column(board_entity)]
```
DB 에서 board_entity 를 찾지 못해서 발생하는 현상
```
@ManyToOne
private BoardEntity boardEntity; 
```



__[CASE03]__
Caused by: javax.persistence.PersistenceException: 
[PersistenceUnit: default] Unable to build Hibernate SessionFactory; 
nested exception is org.hibernate.tool.schema.spi.SchemaManagementException: Schema-validation: missing column [board_entity_id] in table [post]
```
@ManyToOne
private BoardEntity board;  // boardEntity 에서 board 로 다시 변경 @ManyToOne 을 사용하면 변수 자체를 컬럼으로 인식하기 때문에 [board_entity_id] 라는 명칭을 찾게된다.
```


__[CASE04]__
```
java.lang.IllegalStateException: Cannot call sendError() after the response has been committed
	at org.apache.catalina.connector.ResponseFacade.checkCommitted(ResponseFacade.java:529) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.catalina.connector.ResponseFacade.sendError(ResponseFacade.java:362) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver.sendServerError(DefaultHandlerExceptionResolver.java:552) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver.handleHttpMessageNotWritable(DefaultHandlerExceptionResolver.java:442) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver.doResolveException(DefaultHandlerExceptionResolver.java:209) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver.resolveException(AbstractHandlerExceptionResolver.java:142) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.handler.HandlerExceptionResolverComposite.resolveException(HandlerExceptionResolverComposite.java:80) ~[spring-webmvc-5.3.30.jar:5.3.30]
```
BoardEntity 와 PostEntity 가 서로를 무한히 호출하게 되면서 발생하는 현상
PostEntity 에 @JsonIgnore 추가
```
    @ManyToOne
    @JsonIgnore
    private BoardEntity board;	
```


__[CASE05]__	
```
SLF4J: Failed toString() invocation on an object of type [com.example.simpleboard.board.db.BoardEntity]
Reported exception:
java.lang.StackOverflowError
	at com.example.simpleboard.post.db.PostEntity.toString(PostEntity.java:18)
	at java.base/java.lang.String.valueOf(String.java:4215)
	at java.base/java.lang.StringBuilder.append(StringBuilder.java:169)
	at java.base/java.util.AbstractCollection.toString(AbstractCollection.java:457)
	at org.hibernate.collection.internal.PersistentBag.toString(PersistentBag.java:622)
	at java.base/java.lang.StringConcatHelper.stringOf(StringConcatHelper.java:453)
	at com.example.simpleboard.board.db.BoardEntity.toString(BoardEntity.java:14)
	at java.base/java.lang.StringConcatHelper.stringOf(StringConcatHelper.java:453)
	at com.example.simpleboard.post.db.PostEntity.toString(PostEntity.java:18)
	... (반복)...
	at java.base/java.lang.String.valueOf(String.java:4215)
	at java.base/java.lang.StringBuilder.append(StringBuilder.java:169)
	at java.base/java.util.AbstractCollection.toString(AbstractCollection.java:457)
	at org.hibernate.collection.internal.PersistentBag.toString(PersistentBag.java:622)
	at java.base/java.lang.StringConcatHelper.stringOf(StringConcatHelper.java:453)
	at com.example.simpleboard.board.db.BoardEntity.toString(BoardEntity.java:14)
	at java.base/java.lang.StringConcatHelper.stringOf(StringConcatHelper.java:453)
```	 
BoardEntity 와 PostEntity 가 서로를 무한히 호출하게 되면서 발생하는 현상
PostEntity 에 @ToString.Exclude 를 추가하여 해결
```
    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private BoardEntity board;	
```
API 에서 Entity 를 내리는게 아니라 상응하는 DTO 를 사용하여 Entity 가 처리되도록 하는 것이 중요하다


__[CASE06]__	
기존에  postService 에서 관리자 계정이 post 에 대하여 reply 단 것이 확인될 수 있도록 하는 것을 Dto 로 처리할 수 있도록 코드를 변환하는 과정에서 replyList 값이 안 보이는 현상이 발생하였다.   
원인파악을 위하여 갖은 확인을 하던 중 @Transient 가 활성화되어 있던 게 원인이라는 것을 알 수 있었다.   

##### postService
```
            // 관리자 계정에서 달아둔 회신도 확인할 수 있도록 함.
            // var replyList = replyService.findAllByPostId(it.getId()); //  ;; PostEntity 가 OneToMany 관계가 되었기 때문에 작성 필요X
            //it.setReplyList(replyList); // PostEntity 에 선언되어 있음. ;; PostEntity 가 OneToMany 관계가 되었기 때문에 작성 필요X
            return it;
```

##### PostEntity
```
public class PostEntity {
    // @Transient  // 20240512_error 주석처리
    @OneToMany(
            mappedBy = "post"
    )
    @Builder.Default
    private List<ReplyEntity> replyList = new ArrayList<>();
	}
```	

@Transient는 엔티티 객체의 데이터와 테이블의 컬럼(column)과 매핑하고 있는 관계를 제외하기 위해 사용합니다.   
> Aㅏ....@Transient 는 매핑을 제외하기 위한 용도이다 보니 이게 활성화 되어 있음으로서 post 와 replyList 가 매핑이 되지 못해서 그런거였구나...    

