package levi9.VehicleService.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FinishRentDto {
    private Long rentId;
    private Long addressId;
}
