package com.happenings.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InviteEmailData {
    private String toEmail;
    private String recipientUsername;
    private String senderUsername;
    private String eventTitle;
    private String eventDescription;
    private String eventDateTime;
    private String eventLocation;
}
