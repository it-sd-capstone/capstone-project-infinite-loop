package com.happenings.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InviteRequest {
    private String email;
    private Integer eventId;
}

