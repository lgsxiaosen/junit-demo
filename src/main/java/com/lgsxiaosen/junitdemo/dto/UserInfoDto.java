package com.lgsxiaosen.junitdemo.dto;

/**
 * @author liuguisen
 * @date 2020/11/25
 **/
public class UserInfoDto {

    private String username;

    private String password;

    private Integer id;

    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfoDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }


    public static final class UserInfoDtoBuilder {
        private UserInfoDto userInfoDto;

        private UserInfoDtoBuilder() {
            userInfoDto = new UserInfoDto();
        }

        public static UserInfoDtoBuilder anUserInfoDto() {
            return new UserInfoDtoBuilder();
        }

        public UserInfoDtoBuilder username(String username) {
            userInfoDto.setUsername(username);
            return this;
        }

        public UserInfoDtoBuilder password(String password) {
            userInfoDto.setPassword(password);
            return this;
        }

        public UserInfoDtoBuilder id(Integer id) {
            userInfoDto.setId(id);
            return this;
        }

        public UserInfoDtoBuilder age(Integer age) {
            userInfoDto.setAge(age);
            return this;
        }

        public UserInfoDto build() {
            return userInfoDto;
        }
    }
}
