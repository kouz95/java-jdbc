import domain.model.Article;
import domain.model.ArticleRepository;
import domain.model.Member;
import domain.model.MemberRepository;
import infra.ConnectionFactory;
import infra.JdbcArticleRepository;
import infra.JdbcMemberRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.IntStream;

public class Application {

    private static final int FIXTURE_COUNT = 100;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Connection connection = ConnectionFactory.create();
        MemberRepository memberRepository = new JdbcMemberRepository(connection);
        ArticleRepository articleRepository = new JdbcArticleRepository(connection);

        IntStream.rangeClosed(1, FIXTURE_COUNT)
                .mapToObj(i -> new Member((long) i, "avatar-" + i, "nickname", "password-" + i))
                .forEach(memberRepository::save);

        IntStream.rangeClosed(1, FIXTURE_COUNT)
                .mapToObj(i -> new Article((long) i, "category", "contents-" + i, 10_000, (long) (RANDOM.nextInt(FIXTURE_COUNT) + 1), LocalDateTime.now(), LocalDateTime.now()))
                .forEach(articleRepository::save);

        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
