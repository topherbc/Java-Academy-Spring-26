package com.yearup.conferenceapp.repository;

import com.yearup.conferenceapp.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByTrackIgnoreCase(String track);
    List<Session> findBySpeakerContainingIgnoreCase(String speaker);
}
