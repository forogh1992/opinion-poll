package com.forogh.opinionPoll.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "question_option")
public class QuestionOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    private Question question;

    @OneToMany(mappedBy = "questionOption", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<AnswerOption> answerOptions;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "UPDATE_AT", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChangedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<AnswerOption> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<AnswerOption> answerOptions) {
        this.answerOptions = answerOptions;
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

    @PrePersist
    public void setCreationDate() {
        this.createDate = new Date();
    }

    @PreUpdate
    public void setChangeDate() {
        this.lastChangedDate = new Date();
    }


}
