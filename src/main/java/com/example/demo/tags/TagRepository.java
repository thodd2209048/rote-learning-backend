package com.example.demo.tags;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    @Query("SELECT t FROM Tag t WHERE t.name = ?1")
    Optional<Tag> findTagByTagName(String name);

    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN TRUE ELSE FALSE END FROM Tag t WHERE t.name = ?1")
    boolean isTagExists(String name);
    @Query("SELECT t.name FROM Tag t")
    List<String> getTagNames();
}
