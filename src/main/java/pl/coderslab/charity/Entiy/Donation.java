package pl.coderslab.charity.Entiy;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Donation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Pole nie może być puste")
  @Min(value = 1, message = "Musi być przynajmniej jeden worek")
  private Integer quantity;

  @NotBlank(message = "Pole nie może być puste! Podaj ulicę.")
  private String street;

  @NotBlank(message = "Pole nie może być puste! Podaj miasto.")
  private String city;

  @Pattern(regexp = "^$|^([0-9]){2}-([0-9]){3}$", message = "Nie poprawny format kodu pocztowego!")
  @NotBlank(message = "Pole nie może być psuste! Podaj kod pocztowy")
  private String zipCode;

  @NotNull(message = "Musisz podać czas!")
  private LocalTime pickUpTime;

  @NotNull(message = "Musisz podać datę!")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Future(message = "Data musi być w przyszłości!")
  private LocalDate pickUpDate;

  private String pickUpComment;

  @ManyToOne
  @JoinColumn(name = "institution_id")
  private Institution institution;

  @ManyToMany private List<Category> categories = new ArrayList<>();
}
