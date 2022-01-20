package ru.kastricyn.web4.mapper;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.kastricyn.web4.service.PointService;

@Component
public class UserMapper  extends ResponseEntityExceptionHandler {
    private final PointService areaService;
    private final UserRepository userRepository;

    public ShotMapper(AreaService areaService, UserRepository userRepository) {
        this.areaService = areaService;
        this.userRepository = userRepository;
        this.areaService.addShape(new LittleCircle(Quarter.FIRST));
        this.areaService.addShape(new VerticalRect(Quarter.SECOND));
        this.areaService.addShape(new HorizontalRhomb(Quarter.FOURTH));
    }

    public ShotEntity fromCreateDTOToEntity(CreateShotDTO source, Long userId) {
        ShotEntity target = new ShotEntity();
        target.setX((int) Math.round(source.getX()));
        target.setY(source.getY());
        target.setR((int) Math.round(source.getR()));
        areaService.checkArea(target);
        target.setUser(userRepository.findById(userId).orElseThrow(() -> new NotFoundDataException("Пользователь не найден")));
        return target;
    }

    public FullShotDTO fromEntityToDTO(ShotEntity source) {
        FullShotDTO target = new FullShotDTO();
        target.setX((double) source.getX());
        target.setY(source.getY());
        target.setR((double) source.getR());
        target.setHit(source.getIsHit());
        return target;
    }
}
