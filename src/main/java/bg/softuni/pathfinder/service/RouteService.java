package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.models.Route;
import bg.softuni.pathfinder.service.dtos.RouteShortInfoDto;

import java.util.List;

public interface RouteService {

    List<RouteShortInfoDto> getAllRoutes ();

    RouteShortInfoDto mapToShortInfo (Route route);

}
