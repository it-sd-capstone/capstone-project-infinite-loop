package com.happenings.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventRequest {

    // EVENT FIELDS
    private String title;
    private String description;
    private LocalDateTime eventDatetime;

    // CATEGORY FIELDS
    private Integer categoryId;
    private Integer createdByUserId;

    // LOCATION FIELDS
    private String venueName;
    private String address;
    private String city;
    private String state;
}
