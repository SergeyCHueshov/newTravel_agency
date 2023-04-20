package by.it.academy.travelagency.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "ITEMS")
@NoArgsConstructor
@AllArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "TOUR_NAME", nullable = false, length = 50)
    private String tourName;

    @Column(name = "STATE", nullable = false)
    private String state;

    @Column(name = "HOTEL", nullable = false, length = 50)
    private String hotel;

    @Column(name = "COST")
    private Integer cost;

    @Column(name = "ADDITIONAL_INF", nullable = false, length = 50)
    private String additionalInformation;

}
