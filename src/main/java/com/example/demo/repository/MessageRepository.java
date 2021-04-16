package com.example.demo.repository;

import com.example.demo.entity.Message;
import com.example.demo.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    Page<Message> findByTag(String tag, Pageable pageable);
    Page<Message> findAll(Pageable pageable);

    @Query("from Message m where m.author = :author")
    Page<Message> findByUser(Pageable pageable,@Param("author") Users author);
}
