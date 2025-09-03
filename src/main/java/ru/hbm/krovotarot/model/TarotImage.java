package ru.hbm.krovotarot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tarot_images")
public class TarotImage {
    private String minioObjectName;
    private String contentType;
    private Long fileSize;
    private String url;
}
