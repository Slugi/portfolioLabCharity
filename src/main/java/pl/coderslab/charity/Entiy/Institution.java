package pl.coderslab.charity.Entiy;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
public class Institution {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String name;

  @NotBlank
  private String description;

  @OneToMany(mappedBy = "institution")
  private List<Donation> donations;

  private boolean activeParntership;
}
