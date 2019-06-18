package com.oneso.mvc.services;

import com.oneso.mvc.domain.Comment;

import java.util.List;

public interface CommentService {

    void addComment(String text, String bookId);

    List<Comment> getAllCommentsByBookId(String id);

    void deleteById(String id);
}
