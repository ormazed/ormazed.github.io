package com.example.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Setter
//@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class) // 관련 변수들의 클래스 변수들은 snake case 로 매핑하겠다는 의미임.
public class UserRequest {
    // 최고의 사용법 : Simple is best
    // 예외적으로 필요한 경우에만  @JsonProperty("") 을 사용해서 매칭될 수 있도록 해주면 된다.
    private String userName; // user_name
    private Integer userAge;  // user_age
    private String email;
    private Boolean isKorean; //is_korean

/*    @JsonProperty("user_names")
    private String userName; // user_name
    @JsonProperty("user_age")
    private Integer userAge;  // user_age
    //@JsonProperty("user_email")
    @JsonProperty("email")
    private String email;
    @JsonProperty("is_korean")
    private Boolean isKorean; //is_korean
*//*
    public int gethumanAge(){
        return this.userAge;
    }

    public String getName(){
        return this.userName;
    }*//*

*//*    public void setUserNames(String name){
        this.userName = name;
    }*//*

    @Override
    public String toString() {
        return "UserRequest{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", email='" + email + '\'' +
                ", isKorean=" + isKorean +
                '}';
    }
    private UserRequest(){

    }
*//*
    @JsonIgnore
    public String getUser(){
        return userName;
    }
    public String getUserName() {
        return userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getIsKorean() {
        return isKorean;
    }*/
}
