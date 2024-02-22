package forum.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

public class PeriodDto {

	LocalDate dateFrom;
    LocalDate dateTo;
    
//	public PeriodDto(String dateFrom, String dateTo) {
//		
//		//DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		
//		this.dateFrom = LocalDate.parse(dateFrom);
//		this.dateTo = LocalDate.parse(dateTo);
//	}
    
    
	
}
