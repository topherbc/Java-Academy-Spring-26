package com.yearup.conferenceapp.controller;

import com.yearup.conferenceapp.model.Session;
import com.yearup.conferenceapp.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable Long id) {
        return sessionService.getSessionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/track/{track}")
    public List<Session> getSessionsByTrack(@PathVariable String track) {
        return sessionService.getSessionsByTrack(track);
    }

    @GetMapping("/speaker/{speaker}")
    public List<Session> getSessionsBySpeaker(@PathVariable String speaker) {
        return sessionService.getSessionsBySpeaker(speaker);
    }

    @PostMapping
    public Session createSession(@RequestBody Session session) {
        return sessionService.createSession(session);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }



}
