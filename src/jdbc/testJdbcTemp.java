package jdbc;



import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;

@SpringJUnitConfig(locations = {"classpath:Spring.xml"})
public class testJdbcTemp {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        System.out.println(jdbcTemplate.queryForObject("select count(*) from curriculum", Integer.class));
    }
}
