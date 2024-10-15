package com.takima.backskeleton.choix;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChoixService {

    private final ChoixDao choixDao;
}
