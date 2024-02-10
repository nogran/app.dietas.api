package com.nogran.app.dietas.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

  private String name;
  private String email;
  private String password;
  private LocalDate birthDate;
  private float weight;
  private int height;
  private String gender;
  private String goal;
  private List<Meal> meals;
  private Metabolism metabolism;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

//  var metabolismo =
//          metabolismService.calcularMetabolismoBasal(
//                  user.getBirthDate(), user.getGender(), user.getWeight(), user.getHeight());
//    user.getMetabolism().setBasalMetabolicRate(metabolismo);

  //  public float calcularMetabolismoBasal(
  //          LocalDate dataNascimento, String sexo, float peso, float altura) {
  //    int idade = calcularIdade(dataNascimento);
  //
  //    int coeficiente = 0;
  //    if (sexo.equals('M')) {
  //      coeficiente = 5;
  //    } else if (sexo.equals("F")) {
  //      coeficiente = -161;
  //    }
  //    return (10 * peso) * 6.25F * altura - (5 * idade) + coeficiente;
  //  }
  //
  //  private Integer calcularIdade(LocalDate date) {
  //    Calendar cal = GregorianCalendar.getInstance();
  //    int anoAtual = cal.get(Calendar.YEAR);
  //    int idade = anoAtual - date.getYear(); // Calcula a idade apenas com os anos
  //    int diaAtual = cal.get(Calendar.DAY_OF_MONTH);
  //    int mesAtual = cal.get(Calendar.MONTH);
  //
  //    if (date.getDayOfMonth() >= diaAtual && date.getMonth().getValue() >= mesAtual) {
  //      idade--;
  //    }
  //    return idade;
  //  }

}
