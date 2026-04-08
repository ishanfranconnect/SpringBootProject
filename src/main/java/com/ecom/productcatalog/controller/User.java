package com.ecom.productcatalog.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
  private Long id;
  private String name;
 @Column(unique=true)
   private String email;
  private String password;
}
