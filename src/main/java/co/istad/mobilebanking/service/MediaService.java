package co.istad.mobilebanking.service.impl;

import co.istad.mobilebanking.dto.MediaResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MediaService {

    MediaResponse upload(MultipartFile file);

}
