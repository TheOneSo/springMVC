package com.oneso.mvc.events;

import com.oneso.mvc.domain.Author;
import com.oneso.mvc.repository.BookRepository;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.stereotype.Component;

@Component
public class MongoAuthorCascadeDeleteEventsListener extends AbstractMongoEventListener<Author> {

    private final BookRepository bookRepository;

    public MongoAuthorCascadeDeleteEventsListener(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<Author> event) {
        super.onAfterDelete(event);

        Document source = event.getSource();
        String id = source.get("_id").toString();
        bookRepository.deleteBookByAuthorId(id);
    }
}
