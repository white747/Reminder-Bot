//package ru.white747.reminderbot.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.Date;
//import java.util.UUID;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "boss_setting")
//@AllArgsConstructor
//@NoArgsConstructor
//public class BossSetting {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name = "id", nullable = false)
//    private UUID id;
//
//    @Column(name = "region")
//    private String region;
//
//    @Column(name = "boss_name")
//    private String bossName;
//
//    @Column(name = "chance")
//    private int chance;
//
//    @Column(name = "respawn_hours")
//    private int respawnHours;
//
//    @Column(name = "location")
//    private String location;
//
//    @Column(name = "respawn_date_time")
//    private Date respawnDateTime;
//}