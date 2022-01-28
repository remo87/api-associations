package com.remo.associationsapi.controllers;

import com.remo.associationsapi.dtos.DataListItemDto;
import com.remo.associationsapi.dtos.ScoresDto;
import com.remo.associationsapi.mappers.IAssociationMapper;
import com.remo.associationsapi.models.AssociationScore;
import com.remo.associationsapi.models.Datatypes;
import com.remo.associationsapi.models.Datum;
import com.remo.associationsapi.services.IAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/scores")
public class ScoresController {
    @Autowired
    private IAssociationService associationService;

    private IAssociationMapper associationMapper = IAssociationMapper.MAPPER;

    @GetMapping
    public ResponseEntity<List<DataListItemDto>> getAllData() {
        List<Datum> datumList = associationService.getData();
        List<DataListItemDto> data = datumList
                .stream()
                .map(datum ->
                        associationMapper.toListItem(datum)
                )
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScoresDto> getScoresById(@PathVariable String id) {
        Datatypes datatypes = associationService.getScoresById(id);
        ScoresDto scores = associationMapper.toScores(datatypes);
        return ResponseEntity.ok().body(scores);
    }
}
