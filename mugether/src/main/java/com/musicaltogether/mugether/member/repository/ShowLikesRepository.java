package com.musicaltogether.mugether.member.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ShowLikesRepository {

    private final EntityManager em;
}
