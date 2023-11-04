package com.BookMyShowApplication.BookMyShow.Transformers;

import com.BookMyShowApplication.BookMyShow.DTO.ShowDto;
import com.BookMyShowApplication.BookMyShow.Entity.Show;

public class ShowTransformer {
    public static Show createDtoToEntity(ShowDto showDto){
        return Show.builder().showDate(showDto.getShowDate())
                .showTime(showDto.getShowTime())
                .build();
    }
}
