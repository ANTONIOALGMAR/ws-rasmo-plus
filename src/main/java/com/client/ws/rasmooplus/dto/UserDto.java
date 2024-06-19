package com.client.ws.rasmooplus.dto;

import com.client.ws.rasmooplus.model.SubscriptionsType;
import com.client.ws.rasmooplus.model.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long Id;

    @NotBlank(message = "valor nao pode ser nulo ou vazio")
    @Size(min = 6, message = "valor minimo igual a 6 caracteres")
    private String name;

    @Email(message = "Inválido")
    private String email;

    @Size(min = 11, message = "valor minimo igual a 11 digitos")
    private String phone;

    @CPF(message = "Inválido")
    private String cpf;


    private LocalDate dtSubscription = LocalDate.now();


    private LocalDate dtExpiration = LocalDate.now();


    @NotNull
    private Long userTypeId;


    private Long subscriptionsTypeId;
}
