package domain.model;

public class Favorite {
    private Long id;
    private Long memberId;
    private Long articleId;

    public Favorite(Long id, Long memberId, Long articleId) {
        this.id = id;
        this.memberId = memberId;
        this.articleId = articleId;
    }

    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public Long getArticleId() {
        return articleId;
    }
}
