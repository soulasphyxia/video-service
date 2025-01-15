package org.soulasphyxia.videoservice.controller;

import lombok.RequiredArgsConstructor;
import org.soulasphyxia.videoservice.dto.VideoDto;
import org.soulasphyxia.videoservice.service.VideoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/videos")
public class VideoController {
    private final VideoService videoService;

    @GetMapping
    public Page<VideoDto> getAllVideos(@RequestParam(defaultValue = "${paging.page}") int size,
                                       @RequestParam(defaultValue = "${paging.size}") int page) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return videoService.findAll(pageable);
    }
}
