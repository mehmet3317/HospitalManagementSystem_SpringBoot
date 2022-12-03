package springjwt.repository;

import com.bezkoder.springjwt.models.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization,Long> {
}
