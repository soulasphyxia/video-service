package org.soulasphyxia.videoservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.soulasphyxia.videoservice.dto.VideoDto;
import org.soulasphyxia.videoservice.entity.Video;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VideoMapper {

    VideoDto toDto(Video video);

    Video toEntity(VideoDto videoDto);

    List<Video> toEntities(List<VideoDto> videoDtos);

    List<VideoDto> toDtos(List<Video> videos);
}
