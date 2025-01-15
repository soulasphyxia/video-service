package org.soulasphyxia.videoservice.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.soulasphyxia.videoservice.dto.CreateVideoDto;
import org.soulasphyxia.videoservice.dto.UpdateVideoDto;
import org.soulasphyxia.videoservice.dto.VideoDto;
import org.soulasphyxia.videoservice.entity.Video;
import org.soulasphyxia.videoservice.mapper.VideoMapper;
import org.soulasphyxia.videoservice.repository.VideoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;
    private final VideoMapper videoMapper;

    @Override
    public Page<VideoDto> findAll(Pageable pageable) {
        Page<Video> videos = videoRepository.findAll(pageable);

        return new PageImpl<>(videoMapper.toDtos(videos.getContent()), pageable, videos.getTotalElements());
    }

    @Override
    public VideoDto findById(Long id) {
        return videoMapper.toDto(findVideoById(id));
    }

    @Override
    public VideoDto save(CreateVideoDto video) {
        // обращение к микросервисам обработки видео
        return null;
    }

    @Override
    public void deleteById(Long id) {
        if (videoRepository.existsById(id)) {
            videoRepository.deleteById(id);
        }
        throw new EntityNotFoundException(String.format("video with id '%s' not exists", id));
    }

    @Override
    public VideoDto update(UpdateVideoDto dto) {
        Video targetVideo = findVideoById(dto.id());
        if (dto.title() != null) {
            targetVideo.setTitle(dto.title());
        }
        if (dto.description() != null) {
            targetVideo.setDescription(dto.description());
        }
        videoRepository.save(targetVideo);
        return videoMapper.toDto(targetVideo);
    }

    private Video findVideoById(Long id) {
        return videoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("video with id '%s' not found", id)));
    }
}
