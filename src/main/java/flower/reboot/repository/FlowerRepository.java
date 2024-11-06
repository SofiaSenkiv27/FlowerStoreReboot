package flower.reboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import flower.reboot.model.Flower;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Integer> {
}