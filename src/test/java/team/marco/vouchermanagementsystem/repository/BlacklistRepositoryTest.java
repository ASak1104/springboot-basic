package team.marco.vouchermanagementsystem.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import team.marco.vouchermanagementsystem.configuration.PropertyConfiguration;
import team.marco.vouchermanagementsystem.model.BlacklistUser;
import team.marco.vouchermanagementsystem.properties.FilePathProperties;

@TestPropertySource("classpath:application.yml")
@SpringBootTest(classes = {PropertyConfiguration.class, BlacklistRepository.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BlacklistRepositoryTest {
    private static final String SETUP_DATA = """
            id,name
            461b8847-578d-43c7-8472-d9374bbac41a,test1
            461b8847-578d-43c7-8472-d9374bbac42b,test2""";

    @Autowired
    private FilePathProperties filePathProperties;
    @Autowired
    private BlacklistRepository blacklistRepository;

    @BeforeAll
    void setup() {
        try (FileWriter fileWriter = new FileWriter(filePathProperties.blacklist())) {
            fileWriter.write(SETUP_DATA);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Test
    @DisplayName("레포지토리 생성 시 저장된 데이터를 로드해야한다.")
    void testFindAll() {
        // given
        BlacklistRepository repository = blacklistRepository;

        // when
        List<BlacklistUser> blacklistUsers = repository.findAll();

        // then
        assertThat(blacklistUsers, not(empty()));
    }
}