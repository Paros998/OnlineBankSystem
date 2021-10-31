package com.OBS.controller;

import com.OBS.entity.Announcement;
import com.OBS.service.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/announcements")
@AllArgsConstructor
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @GetMapping(path = "")
    public List<Announcement> getAnnouncements() {
        return announcementService.getAnnouncements();
    }

    @GetMapping(path = "{id}")
    public Announcement getAnnouncement(@PathVariable("id") Long id) {
        return announcementService.getAnnouncement(id);
    }

    @PostMapping(path = "")
    public void addAnnouncement(@RequestBody Announcement announcement) {
        announcementService.addAnnouncement(announcement);
    }

    @PutMapping(path = "{id}")
    public void updateAnnouncement(@PathVariable("id") Long id, @RequestBody Announcement announcement) {
        announcementService.updateAnnouncement(id, announcement);
    }
}
