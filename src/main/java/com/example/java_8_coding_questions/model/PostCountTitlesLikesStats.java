package com.example.java_8_coding_questions.model;

import java.util.IntSummaryStatistics;

public class PostCountTitlesLikesStats {
    private long postCount;
    private String titles;
    private IntSummaryStatistics likesStats;

    public PostCountTitlesLikesStats(long postCount, String titles, IntSummaryStatistics likesStats) {
        this.postCount = postCount;
        this.titles = titles;
        this.likesStats = likesStats;
    }

    public long getPostCount() {
        return postCount;
    }

    public String getTitles() {
        return titles;
    }

    public IntSummaryStatistics getLikesStats() {
        return likesStats;
    }

    @Override
    public String toString() {
        return "PostCountTitlesLikesStats{" +
                "postCount=" + postCount +
                ", titles='" + titles + '\'' +
                ", likesStats=" + likesStats +
                '}';
    }
}
