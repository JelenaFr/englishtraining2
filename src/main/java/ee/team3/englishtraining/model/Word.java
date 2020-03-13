package ee.team3.englishtraining.model;

import ee.team3.englishtraining.repo.WordRepo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "words")
public class Word implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable =  false, nullable = false)
    private Long wordId;
    @NonNull
    private String inEnglish;
    @NonNull
    private String inEstonian;
    @NonNull
    private String inRussian;
//    @NonNull
//    @ElementCollection(targetClass = ComplexityLevel.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "complexity", joinColumns = @JoinColumn(name = "wordId"))
//    @Enumerated(EnumType.STRING)
//    private Set<ComplexityLevel> complexitySet  = new HashSet<>();
    @NonNull
    @Enumerated(EnumType.STRING)
    private ComplexityLevel complexityLevel;


//    @Override
//    public Collection<Word> findRandomEnglishWord() {
//        return ;
//    }
}
