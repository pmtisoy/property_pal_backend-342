package property.pal.bacolod.dto;

import java.time.LocalDateTime;
import property.pal.bacolod.model.InquiryParticipantType;

public class InquiryDto {
    public Integer inquiryId;
    public Integer unitId;
    public Integer senderId;
    public InquiryParticipantType senderType;
    public Integer receiverId;
    public InquiryParticipantType receiverType;
    public String messageContent;
    public Boolean isRead;
    public LocalDateTime sentAt;
}
