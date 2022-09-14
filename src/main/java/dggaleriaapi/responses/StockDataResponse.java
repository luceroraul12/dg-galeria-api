package dggaleriaapi.responses;

import dggaleriaapi.models.StockData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StockDataResponse<Entity extends StockData> {
    private List<Entity> stockDataResult;
    private String message;
}
