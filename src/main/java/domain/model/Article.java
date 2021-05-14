package domain.model;

import java.sql.Date;
import java.time.LocalDateTime;

public class Article {
    private Long id;
    private String category;
    private String contents;
    private int price;
    private Long memberId;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    public Article(Long id, String category, String contents, int price, Long memberId, LocalDateTime createdTime, LocalDateTime modifiedTime) {
        this.id = id;
        this.category = category;
        this.contents = contents;
        this.price = price;
        this.memberId = memberId;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getContents() {
        return contents;
    }

    public int getPrice() {
        return price;
    }

    public Long getMemberId() {
        return memberId;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }
}
