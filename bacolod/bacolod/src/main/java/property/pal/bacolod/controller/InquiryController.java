package property.pal.bacolod.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import property.pal.bacolod.dto.InquiryDto;
import property.pal.bacolod.model.Unit;
import property.pal.bacolod.model.Inquiry;
import property.pal.bacolod.repository.UnitRepository;
import property.pal.bacolod.service.InquiryService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/inquiries")
public class InquiryController {
    private final InquiryService inquiryService;
    private final UnitRepository unitRepository;

    public InquiryController(InquiryService inquiryService, UnitRepository unitRepository) {
        this.inquiryService = inquiryService;
        this.unitRepository = unitRepository;
    }

    @GetMapping
    public List<Inquiry> findAll() {
        return inquiryService.findAll();
    }

    @GetMapping("/{id}")
    public Inquiry findById(@PathVariable Integer id) {
        return inquiryService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Inquiry> create(@RequestBody InquiryDto inquiryDto) {
        Unit unit = unitRepository.findById(inquiryDto.unitId)
            .orElseThrow(() -> new RuntimeException("Unit not found"));

        Inquiry inquiry = new Inquiry();
        inquiry.setUnit(unit);
        inquiry.setSenderId(inquiryDto.senderId);
        inquiry.setSenderType(inquiryDto.senderType);
        inquiry.setReceiverId(inquiryDto.receiverId);
        inquiry.setReceiverType(inquiryDto.receiverType);
        inquiry.setMessageContent(inquiryDto.messageContent);
        inquiry.setIsRead(inquiryDto.isRead);
        inquiry.setSentAt(inquiryDto.sentAt);

        Inquiry saved = inquiryService.create(inquiry);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public Inquiry update(@PathVariable Integer id, @RequestBody Inquiry inquiry) {
        return inquiryService.update(id, inquiry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        inquiryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
