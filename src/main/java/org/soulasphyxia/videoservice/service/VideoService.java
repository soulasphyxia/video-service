package org.soulasphyxia.videoservice.service;

import org.soulasphyxia.videoservice.dto.CreateVideoDto;
import org.soulasphyxia.videoservice.dto.UpdateVideoDto;
import org.soulasphyxia.videoservice.dto.VideoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VideoService {

    Page<VideoDto> findAll(Pageable pageable);

    VideoDto findById(Long id);

    VideoDto save(CreateVideoDto video);

    void deleteById(Long id);

    VideoDto update(UpdateVideoDto dto);
}
