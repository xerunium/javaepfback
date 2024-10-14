package com.takima.backskeleton.service;

import com.takima.backskeleton.DAO.ChoixDao;
import com.takima.backskeleton.models.Choix;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
@RequiredArgsConstructor
public class ChoixService {

    private final ChoixDao choixDao;
}
