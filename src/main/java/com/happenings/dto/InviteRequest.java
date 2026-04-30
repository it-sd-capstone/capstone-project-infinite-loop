package com.happenings.dto;


public class InviteRequest {
    private String email;
    private Integer eventId;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getEventId() { return eventId; }
    public void setEventId(Integer eventId) { this.eventId = eventId; }
}
