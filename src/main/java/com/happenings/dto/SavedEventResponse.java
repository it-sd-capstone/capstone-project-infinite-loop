package com.happenings.dto;

import lombok.Data;

@Data
public class SavedEventResponse {
    private Integer savedEventId;
    private Integer userId;
    private Integer eventId;
}
