package com.forogh.opinionPoll.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "phone_number", nullable = false, updatable = true)
    private String phoneNumber;

    @Column(name = "user_name", nullable = false, updatable = true)
    private String userName;

    @Column(name = "gender", nullable = false, updatable = true)
    private String gender;

    @Column(name = "total_answerSheet", nullable = true, updatable = true)
    private Integer totalAnswerSheet;

    @Column(name = "CREATED_AT", nullable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "UPDATE_AT", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChangedDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Questionnaire> questionnaires;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<AnswerSheet> answerSheets;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getTotalAnswerSheet() {
        return totalAnswerSheet;
    }

    public void setTotalAnswerSheet(Integer totalAnswerSheet) {
        this.totalAnswerSheet = totalAnswerSheet;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastChangedDate() {
        return lastChangedDate;
    }

    public void setLastChangedDate(Date lastChangedDate) {
        this.lastChangedDate = lastChangedDate;
    }

    public List<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public List<AnswerSheet> getAnswerSheets() {
        return answerSheets;
    }

    public void setAnswerSheets(List<AnswerSheet> answerSheets) {
        this.answerSheets = answerSheets;
    }

    @PrePersist
    public void setCreationDate() {
        this.createDate = new Date();
    }

    @PreUpdate
    public void setChangeDate() {
        this.lastChangedDate = new Date();
    }

}
