package pl.coderslab.charity.Entiy;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ToString.Exclude
  @ManyToMany(mappedBy = "categories")
  private List<Donation> donations;
}
