package ru.white747.reminderbot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_", indexes = {
        @Index(name = "idx_user__tlg_id_name", columnList = "tlg_id, name")
})
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tlg_id")
    private long tlgId;

    @Column(name = "name")
    private String name;
}