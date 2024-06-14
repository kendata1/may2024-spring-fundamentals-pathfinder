package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.data.RouteRepository;
import bg.softuni.pathfinder.models.Picture;
import bg.softuni.pathfinder.models.Route;
import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.dtos.RouteShortInfoDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    @Transactional
    public List<RouteShortInfoDto> getAllRoutes() {
       return routeRepository.findAll()
                .stream()
                .map(this::mapToShortInfo)
                .toList();
    }

    @Override
    public RouteShortInfoDto mapToShortInfo(Route route) {
        RouteShortInfoDto routeShortInfoDto = new RouteShortInfoDto();
        routeShortInfoDto.setId(route.getId());
        routeShortInfoDto.setDescription(route.getDescription());
        routeShortInfoDto.setName(route.getName());
        Optional<Picture> first = route.getPictures().stream().findFirst();
        routeShortInfoDto.setPictureUrl(first.get().getUrl());

        return routeShortInfoDto;
    }


}
