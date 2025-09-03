package ru.hbm.krovotarot.controller.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.hbm.krovotarot.exception.ErrorDto;

import java.util.List;

@Tag(
        name = "Контроллер для получения справочников",
        description = "Контроллер для получения необходимых данных для запросов к системе"
)
@RequestMapping("/api/v1/dictionaries")
public interface DictionariesController {

    @Operation(summary = "Получить доступные типы предсказаний")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешное получение списка типов предсказаний",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = List.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка сервера",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    )
            }
    )
    @GetMapping("/predicate-types")
    List<String> getPredicateTypes();
}
