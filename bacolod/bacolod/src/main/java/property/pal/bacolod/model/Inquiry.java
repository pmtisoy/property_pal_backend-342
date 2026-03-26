package property.pal.bacolod.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "inquiries")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inquiry_id")
    private Integer inquiryId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    @Column(name = "sender_id", nullable = false)
    private Integer senderId;

    @Enumerated(EnumType.STRING)
    @Column(name = "sender_type", nullable = false)
    private InquiryParticipantType senderType;

    @Column(name = "receiver_id", nullable = false)
    private Integer receiverId;

    @Enumerated(EnumType.STRING)
    @Column(name = "receiver_type", nullable = false)
    private InquiryParticipantType receiverType;

    @Column(name = "message_content", nullable = false, columnDefinition = "TEXT")
    private String messageContent;

    @Column(name = "is_read", nullable = false)
    private Boolean isRead;

    @Column(name = "sent_at", nullable = false)
    private LocalDateTime sentAt;

    @PrePersist
    public void prePersist() {
    this.sentAt = LocalDateTime.now();
}

    public Inquiry() {}

    public Integer getInquiryId() { return inquiryId; }
    public void setInquiryId(Integer inquiryId) { this.inquiryId = inquiryId; }
    public Unit getUnit() { return unit; }
    public void setUnit(Unit unit) { this.unit = unit; }
    public Integer getSenderId() { return senderId; }
    public void setSenderId(Integer senderId) { this.senderId = senderId; }
    public InquiryParticipantType getSenderType() { return senderType; }
    public void setSenderType(InquiryParticipantType senderType) { this.senderType = senderType; }
    public Integer getReceiverId() { return receiverId; }
    public void setReceiverId(Integer receiverId) { this.receiverId = receiverId; }
    public InquiryParticipantType getReceiverType() { return receiverType; }
    public void setReceiverType(InquiryParticipantType receiverType) { this.receiverType = receiverType; }
    public String getMessageContent() { return messageContent; }
    public void setMessageContent(String messageContent) { this.messageContent = messageContent; }
    public Boolean getIsRead() { return isRead; }
    public void setIsRead(Boolean isRead) { this.isRead = isRead; }
    public LocalDateTime getSentAt() { return sentAt; }
    public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }
}
