package com.github.unishako.demo.common.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MapperUtils {

    private final ModelMapper modelMapper;

    public <T, U> List<U> convertList(List<T> in, Class<U> type) {
        List<U> out = new ArrayList<>();
        in.forEach(e -> out.add(modelMapper.map(e, type)));
        return out;
    }
}
