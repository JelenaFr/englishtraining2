package ee.team3.englishtraining.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Table(name = "words") // class i tablicu vsegda nazivai odinakovo
public class Word {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long wordId; // takze kak i s tablicoi, nazivai odinakogo -> id
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
