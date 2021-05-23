package pl.coderslab.charity.Entiy;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
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
  private LocalTime pickupTime;

  @NotNull(message = "Musisz podać datę!")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Future(message = "Data musi być w przyszłości!")
  private LocalDate pickupDate;

  private String pickUpComment;

  @Pattern(
      regexp =
          "^$|^(\\+48|\\+48 )?(([0-9]{9}|[0-9]{2} [0-9]{3} [0-9]{2} [0-9]{2}|[0-9]{2} [0-9]{3}-[0-9]{2}-[0-9]{2})|([0-9]{3} [0-9]{3} [0-9]{3}|([0-9]{3}-[0-9]{3}-[0-9]{3}|([0-9]{3}))))$",
      message = "Niepoprawny format numeru telefonu")
  private String phone;

  private boolean pickedUp;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate takeOverDate;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate created;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateOfActualizationOfPickUpDetails;

  @ManyToOne
  @JoinColumn(name = "institution_id")
  private Institution institution;

  @ManyToMany
  @JoinTable(
      name = "donations_categories",
      joinColumns = @JoinColumn(name = "donation_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id"))
  private List<Category> categories;
}
