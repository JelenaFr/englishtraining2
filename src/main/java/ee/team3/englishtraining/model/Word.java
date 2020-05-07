package ee.team3.englishtraining.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "Words") // class i tablicu vsegda nazivai odinakovo
public class Word {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "wordid", updatable = false, nullable = false)
	private Long wordId;
	@NonNull
	private String inEnglish;
	@NonNull
	private String inEstonian;
	@NonNull
	private String inRussian;
	@NonNull
	@Enumerated(EnumType.STRING)
	private Complexity complexity;
	@Transient
	private String translation;



}
