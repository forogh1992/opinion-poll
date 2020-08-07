package com.forogh.opinionPoll.dto;

import io.swagger.annotations.ApiModelProperty;

public class UserDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true)
    private String phoneNumber;

    @ApiModelProperty(required = true)
    private String userName;

    @ApiModelProperty(required = true)
    private String gender;

    @ApiModelProperty(required = false,hidden = true)
    private Long totalAnswerSheet;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getTotalAnswerSheet() {
        return totalAnswerSheet;
    }

    public void setTotalAnswerSheet(Long totalAnswerSheet) {
        this.totalAnswerSheet = totalAnswerSheet;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
