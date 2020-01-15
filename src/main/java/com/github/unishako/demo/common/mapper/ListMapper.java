package com.github.unishako.demo.common.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ListMapper {

    private final ModelMapper modelMapper;

    public <T, U> List<U> convertDto(List<T> in, Class<U> type) {
        List<U> out = new ArrayList<>();
        for (T t : in) {
            out.add(modelMapper.map(t, type));
        }
        return out;
    }
}
