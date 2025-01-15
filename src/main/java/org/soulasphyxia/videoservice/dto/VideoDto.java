package org.soulasphyxia.videoservice.dto;

import java.time.LocalDateTime;

public record VideoDto(Long id,
                       String title,
                       String description,
                       String url,
                       LocalDateTime createdAt,
                       LocalDateTime updatedAt) {
}
