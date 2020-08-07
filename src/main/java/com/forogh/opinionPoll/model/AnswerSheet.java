package com.forogh.opinionPoll.model;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "answer_sheet")
public class AnswerSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "UPDATE_AT", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChangedDate;

    @ManyToOne
    private Questionnaire questionnaire;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "answerSheet", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Answer> answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
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
