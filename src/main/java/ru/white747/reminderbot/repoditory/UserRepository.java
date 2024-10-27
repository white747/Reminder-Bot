package ru.white747.reminderbot.repoditory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.white747.reminderbot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}