package com.example.demo.features.article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT a FROM Article a WHERE a.url = ?1")
    Optional<Article> findArticleByUrl(String url);

    @Query("SELECT a FROM Article a WHERE a.title = ?1")
    Optional<Article> findArticleByTitle(String title);

    @Query("SELECT DISTINCT a.subject FROM Article a")
    List<String> getAllSubject();

        @Query(" SELECT a FROM Article a WHERE " +
                " (CAST(:date AS LOCALDATE) IS NULL OR (a.lastTimeRead + a.nextPeriod) <= :date) " +
                " AND (:search IS NULL OR LOWER(a.title) LIKE '%' || LOWER(:search) || '%') " +
                " AND (:tag IS NULL OR :tag MEMBER OF a.tags )")
        Page<Article> findAllByNextTimeReadBeForeNow(Pageable pageable, LocalDate date, String search, String tag);

}
