package domain.model;

public class Member {
    private Long id;
    private String avatar;
    private String nickname;
    private String password;

    public Member(Long id, String avatar, String nickname, String password) {
        this.id = id;
        this.avatar = avatar;
        this.nickname = nickname;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }
}
