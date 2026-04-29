package com.happenings.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class SavedEventId implements Serializable {
  private Integer eventId;
  private Integer userId;
}
