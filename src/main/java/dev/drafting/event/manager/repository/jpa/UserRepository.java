package dev.drafting.event.manager.repository.jpa;

import dev.drafting.event.manager.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
