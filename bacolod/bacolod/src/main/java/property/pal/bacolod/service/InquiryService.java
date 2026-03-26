package property.pal.bacolod.service;

import org.springframework.stereotype.Service;
import property.pal.bacolod.model.Inquiry;
import property.pal.bacolod.repository.InquiryRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
public class InquiryService {
    private final InquiryRepository inquiryRepository;

    public InquiryService(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    public List<Inquiry> findAll() {
        return inquiryRepository.findAll();
    }

    public Inquiry findById(Integer id) {
        return inquiryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inquiry not found"));
    }

    public Inquiry create(Inquiry inquiry) {
        return inquiryRepository.save(inquiry);
    }

    public Inquiry update(Integer id, Inquiry inquiry) {
        if (!inquiryRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inquiry not found");
        }
        inquiry.setInquiryId(id);
        return inquiryRepository.save(inquiry);
    }

    public void delete(Integer id) {
        if (!inquiryRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inquiry not found");
        }
        inquiryRepository.deleteById(id);
    }
}
