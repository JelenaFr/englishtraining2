package ee.team3.englishtraining.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "Word")
public class Word {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
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

	@PrePersist
	@PreUpdate
	public void codeToUpper() {
		inEnglish = inEnglish.toLowerCase().trim();
		inEstonian = inEstonian.toLowerCase().trim();
		inRussian = inRussian.toLowerCase().trim();
	}


}
