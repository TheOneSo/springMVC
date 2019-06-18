package com.oneso.mvc.repository;

import com.oneso.mvc.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findCommentByBookName(String name);

    List<Comment> findCommentByBookId(String id);
}
