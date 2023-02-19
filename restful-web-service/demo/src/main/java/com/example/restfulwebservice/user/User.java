package com.example.restfulwebservice.user;

import com.example.restfulwebservice.post.Post;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password"})
//@JsonFilter("UserInfo")
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
@Entity
public class User { // User예약어 임 바꾸어야 함. 강제로 되게 옵션처리 함.

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message = "Name은 2글자이상 입력 해 주세요.")
    @ApiModelProperty(notes = "사용자 이름을 입력해 주세요.")
    private String name;

    @Past
    @ApiModelProperty(notes = "사용자 등록일을 입력해 주세요.")
    private Date joindate;

//    @JsonIgnore
    @ApiModelProperty(notes = "사용자 패스워드을 입력해 주세요.")
    private String password;

//    @JsonIgnore
    @ApiModelProperty(notes = "사용자 주민번호를 입력해 주세요.")
    private String ssn;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Post> posts;


    public User(int i, String alice, Date date, String pass2, String s) {
        this.id = i;
        this.name = alice;
        this.joindate = date;
        this.password = pass2;
        this.ssn = s;
    }
}
