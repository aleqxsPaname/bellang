package com.bellang.service;

import com.bellang.model.entity.Diaporama;
import com.bellang.model.entity.Version;
import com.bellang.model.entity.VirtualSentence;
import com.bellang.model.repository.DiaporamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DiaporamaService {

    @Autowired
    private DiaporamaRepository diaporamaRepository;

    public Diaporama getDiaporamaFromId(Long id){
        Diaporama diaporama = diaporamaRepository.findById(id).orElse(new Diaporama());

        return diaporama;
    }

    public List<VirtualSentence> getOnlySentencesOfDiaporama(Diaporama diaporama){
        List<VirtualSentence> virtualSentences = diaporama.getSlides().stream()
                                        .map(s -> s.getVirtualSentences())
                                        .flatMap(List::stream)
                                        .collect(toList());
        return virtualSentences;
    }

    public List<Version> getOnlyVersionOfDiaporama(Diaporama diaporama){
        List<Version> versions = diaporama.getSlides().stream()
                                    .map(slide -> slide.getVirtualSentences())
                                    .flatMap(List::stream)
                                    .map(virtualSentence -> virtualSentence.getVersions())
                                    .flatMap(List::stream)
                                    .collect(toList());
        return versions;
    }

}
