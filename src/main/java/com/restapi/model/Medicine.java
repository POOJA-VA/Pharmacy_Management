package com.restapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    @Size(min = 5, message = "Title must have at least 5 characters")
    private String title;

    @Column(nullable = false, length = 200)
    @Size(min = 8, message = "Description should have at least 8 characters")
    private String description;

    @Column(nullable = false, length = 200)
    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be a positive value")
    private Double price;

    @Column(nullable = false, updatable = false, length = 200)
    @NotNull(message = "Date cannot be null")
    private Date date;

    @Transient
    private Integer count;

    @Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "medicine")
    private List<Cart> carts = new ArrayList<>();

    @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date expiryDate;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}