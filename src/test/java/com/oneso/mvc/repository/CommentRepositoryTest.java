package com.oneso.mvc.repository;

import com.oneso.mvc.domain.Author;
import com.oneso.mvc.domain.Book;
import com.oneso.mvc.domain.Comment;
import com.oneso.mvc.domain.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.*;

@DataMongoTest
@ComponentScan({"com.oneso.mvc.repository", "com.oneso.mvc.events", "com.oneso.mvc.mongoConfig"})
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
@TestPropertySource(properties = {"spring.config.location = classpath:application-test.yml"})
@DisplayName("Репозиторий по работе с комментариями")
class CommentRepositoryTest {

    @Autowired
    private CommentRepository repository;

    @Autowired
    private MongoTemplate template;

    @Test
    @DisplayName("добавляет новый комментарий")
    void shouldAddNewComment() {
        Comment comment = new Comment("comment", "123",
                new Book("test", "123", new Author("test", "1"), new Genre("test", "1")));
        repository.save(comment);

        assertThat(template.findById("123", Comment.class))
                .isNotNull().isEqualToComparingOnlyGivenFields(comment, "text", "book.name");
    }

    @Test
    @DisplayName("удаляет комментарий")
    void shouldDeleteComment() {
        long expected = repository.count() - 1;

        repository.deleteById("1");

        assertThat(repository.count())
                .isEqualTo(expected);
    }
}
