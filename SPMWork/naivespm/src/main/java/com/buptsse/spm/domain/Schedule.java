package com.buptsse.spm.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "schedule")
@IdClass(SchedulePK.class)
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "chapter_id", nullable = false)
    private int chapterId;

    @Id
    @Column(name = "video_step_order", nullable = false)
    private int videoStepOrder;

    @Id
    @Column(name = "userId", nullable = false, length = 45)
    private String userId;

    @Column(name = "percent")
    private int percent;

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getVideoStepOrder() {
        return videoStepOrder;
    }

    public void setVideoStepOrder(int videoStepOrder) {
        this.videoStepOrder = videoStepOrder;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
