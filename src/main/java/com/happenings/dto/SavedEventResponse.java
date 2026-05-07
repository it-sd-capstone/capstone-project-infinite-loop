package com.happenings.dto;

import com.happenings.entity.Location;

import java.time.LocalDateTime;

public class SavedEventResponse {

    private Integer savedEventId;
    private Integer userId;
    private Integer eventId;

    private String title;
    private String description;
    private LocalDateTime eventDatetime;
    private Location location;
    private Integer categoryId;

    // getters & setters

    public Integer getSavedEventId() { return savedEventId; }
    public void setSavedEventId(Integer savedEventId) { this.savedEventId = savedEventId; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public Integer getEventId() { return eventId; }
    public void setEventId(Integer eventId) { this.eventId = eventId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getEventDatetime() { return eventDatetime; }
    public void setEventDatetime(LocalDateTime eventDatetime) { this.eventDatetime = eventDatetime; }

    public Location getLocation() { return location;}
    public void setLocation(Location location) { this.location = location;}

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
}