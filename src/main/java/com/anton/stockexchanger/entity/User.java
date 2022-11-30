package com.anton.stockexchanger.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

   @NotNull
   @Column(name ="login")
   @Length(min = 4 , max = 15, message = "Login should be from 4 to 15 characters")
    private String Login;

   @NotNull
   @Column(name = "password")
   @Length(min = 8 , max = 20 , message = "Password should be from 8 to 20 characters")
   @Pattern(regexp = "[A-Za-z]+[0-9]+[!@#$%^&*]+", message = "Password should atleast contain a digit and a special character")
   private String password;





}
