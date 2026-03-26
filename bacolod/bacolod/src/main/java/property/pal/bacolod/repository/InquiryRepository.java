package property.pal.bacolod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import property.pal.bacolod.model.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
}
