package com.example.restapi;

import com.example.restapi.model.UserRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
	/*
		// TEST1
		var user = new UserRequest();
		user.setUserName("홍길동");
		user.setUserAge(10);
		user.setEmail("hong@gmail.com");
		user.setIsKorean(true);


		// 직렬화 : dto => josn
		// 결과 : JSON = {"user_name":"홍길동","user_age":10,"email":"hong@gmail.com","is_korean":true}
		var json = objectMapper.writeValueAsString(user);
		System.out.println("JSON = " + json);

		// 역직렬화 : JSON -> DTO
		//DTO = UserRequest(userName=홍길동, userAge=10, email=hong@gmail.com, isKorean=true)
		// var dto = objectMapper.readValue(json, UserRequest.class);
		// System.out.println("DTO = " + dto);


		//TEST2
		// 결과 : com.example.restapi.model.UserRequest@49ced9c7
		//JSON = {}
		var user = new UserRequest("홍길동",12,"hong12@gamil.com",true);
		System.out.println(user);
		var json = objectMapper.writeValueAsString(user);
		System.out.println("JSON = " + json);

		// TEST3 : UserRequest.java 에 toString() 추가 후
		// UserRequest{userName='홍길동', userAge=12, email='hong12@gamil.com', isKorean=true}
		// JSON = {}
		// ObjectMapper 가 동작하는 방식은 변수에 매칭되는 게 아닌 메서드에 매칭이 된다.
		var user = new UserRequest("홍길동",12,"hong12@gamil.com",true);
		System.out.println(user);
		var json = objectMapper.writeValueAsString(user);
		System.out.println("JSON = " + json);

		// TEST4 : getName(), gethumanAge 추가 후
		// 결과 : UserRequest{userName='홍길동', userAge=12, email='hong12@gamil.com', isKorean=true}
		//       JSON = {"name":"홍길동","human_age":12}
		// 변수에 매칭되는 게 아니라 get*() 이라는 메서드들을 snake_case 로 변환함.
		var user = new UserRequest("홍길동",12,"hong12@gamil.com",true);
		System.out.println(user);
		var json = objectMapper.writeValueAsString(user);
		System.out.println("JSON = " + json);
		// ObjectMapper 는 직렬화를 해줄 때 변수 기준이아닌 get 이라는 명의 메서드들을 참고한다는 것을 알 수 있다.
		// => 간혹 가다가 특정 필드를 못 찾는 케이스는 대게 애린 클래스에 특정 get 메서드를 만들어둔 케이스이다.

		// TEST5 : public String getUser() 추가 후 => 원하지않는 "user":"홍길동" 가 추가된 것을 확인할 수 있다.
		//JSON = {"user_name":"홍길동","user_age":12,"email":"hong12@gamil.com","is_korean":true,"user":"홍길동"}
		// @JsonIgnore 추가
		// JSON = {"user_name":"홍길동","user_age":12,"email":"hong12@gamil.com","is_korean":true}

		// => 예상치 못한 결과가 나오게 될 수 있기 때문에 반드시 objectMapper 가 관여하는 클래스에 get 메서드가 들어가게 된다
		// json 을 사용하지 않고자 한다면 반드시 @JsonIgnore 를 추가해줘야 한다.

		// TEST6 :  @JosnProperty 를 사용하면 변수명을 강제할 수 있다. @JsonProperty("user_email")
		var user = new UserRequest("홍길동",12,"hong12@gamil.com",true);
		System.out.println(user);
		var json = objectMapper.writeValueAsString(user);
		System.out.println("JSON = " + json);
		// 추가 전 : JSON = {"user_name":"홍길동","user_age":12,"email":"hong12@gamil.com","is_korean":true,"user":"홍길동"}
		// 추가 후 : JSON = {"user_name":"홍길동","user_age":12,"is_korean":true,"user_email":"hong12@gamil.com"}
*/

		// TEST 7 : 기본 클래스 환경일 때의 readValue() 동작 확인
		var json = "{\"user_names\":\"홍길동\",\"user_age\":12,\"email\":\"hong12@gamil.com\",\"is_korean\":true}";
		System.out.println(json);
		var dto = objectMapper.readValue(json, UserRequest.class);  // objectMapper 는 relaction 기반으로 동작하기 때문에 Consturctor 가 막히더라도 인스턴스 생성이 가능하다
		System.out.println(dto);
		// {"user_name":"홍길동","user_age":12,"email":"hong12@gamil.com","is_korean":true}
		// UserRequest{userName='null', userAge=null, email='null', isKorean=null}
	}

	// readValue (json --> dto 변환) 할 때는 set 메서드를 참고하는데 setter 메서드가 없다면 get 메서드를 통해서도 세팅이 가능하다는 사실을 알 수 있다.
	// getter/setter 를 두지 않으려면 @JsonProperty() 설정을 통해 가능해진다.

}
