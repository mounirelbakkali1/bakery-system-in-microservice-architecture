package ma.bakery.repositories;

import ma.bakery.entities.Bakery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BakeryRepository extends JpaRepository<Bakery, Long> {
    default Bakery updateBakery(Bakery bakery) {
        Bakery existingBakery = findById(bakery.getId())
                .orElseThrow(() -> new IllegalArgumentException("Bakery with ID " + bakery.getId() + " not found"));
        existingBakery.setName(bakery.getName());
        existingBakery.setAddress(bakery.getAddress());
        existingBakery.setBakeryStatus(bakery.getBakeryStatus());
        existingBakery.setBusiness_phone(bakery.getBusiness_phone());
        existingBakery.setImages(bakery.getImages());
        existingBakery.setPrimary_image(bakery.getPrimary_image());
        existingBakery.setOpeningHours(bakery.getOpeningHours());
        save(existingBakery);
        return existingBakery ;

    }
}
