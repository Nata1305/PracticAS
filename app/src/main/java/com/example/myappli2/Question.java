package com.example.myappli2;

public class Question {
    private int questionRecId;
    private boolean answerTrue;

    public int getQuestionRecId() {
        return questionRecId;
    }

    public void setQuestionRecId(int questionRecId) {
        this.questionRecId = questionRecId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }

    public Question(int questionRecId, boolean answerTrue) {
        this.questionRecId = questionRecId;
        this.answerTrue = answerTrue;
    }
}
