package ru.hbm.krovotarot.controller.v1;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hbm.krovotarot.dto.CardTaroInfoDto;
import ru.hbm.krovotarot.dto.PredictionResultDto;
import ru.hbm.krovotarot.dto.PredictionType;
import ru.hbm.krovotarot.error.ErrorDto;

import java.util.List;

@Tag(
        name = "Контроллер карт Таро и гаданий по Таро",
        description = "Контроллер для получения информации о картах Таро и гаданий по 1 или 3 карте"
)
@RequestMapping("/api/v1/tarot")
public interface TarotController {

    @Operation(summary = "Получить все карт Таро")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешное получение списка карт",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = List.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка сервера",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    )
            }
    )
    @GetMapping("/cards")
    List<CardTaroInfoDto> getAllCards();

    @Operation(
            summary = "Получить карту Таро по ID",
            parameters = @Parameter(
                    name = "ID",
                    description = "ID карты Таро в БД",
                    in = ParameterIn.PATH,
                    required = true
            )
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешное получение карты Таро",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CardTaroInfoDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Не найдена карта по ID",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка сервера",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    )
            }
    )
    @GetMapping("/cards/{id}")
    CardTaroInfoDto getCardById(@PathVariable Long id);

    @Operation(
            summary = "Получить предсказание по 1 карте Таро",
            parameters = @Parameter(
                    name = "Type",
                    description = "Тип предсказаний (общее, любовное, по вопросу, на день). Если не указано, то по всем трактовкам",
                    in = ParameterIn.QUERY,
                    required = false,
                    schema = @Schema(implementation = PredictionType.class)
            )
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешное получение предсказания",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PredictionResultDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Не верный тип предсказания",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка сервера",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    )
            }
    )
    @GetMapping("/predict/single")
    PredictionResultDto predictByOneCard(@RequestParam PredictionType type);

    @Operation(
            summary = "Получить предсказание по 3 картам Таро",
            parameters = @Parameter(
                    name = "Type",
                    description = "Тип предсказаний (общее, любовное, по вопросу, на день). Если не указано, то по всем трактовкам",
                    in = ParameterIn.QUERY,
                    required = false,
                    schema = @Schema(implementation = PredictionType.class)
            )
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешное получение предсказания",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PredictionResultDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Не верный тип предсказания",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка сервера",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    )
            }
    )
    @GetMapping("/predict/three")
    PredictionResultDto predictByThreeCards(@RequestParam PredictionType type);
}
