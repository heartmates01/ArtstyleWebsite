package nl.heartmates01.ArtstyleWebsite.palette;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "palettes", path = "palettes")
public interface PaletteRepository extends PagingAndSortingRepository<Palette, Long>,
    CrudRepository<Palette, Long> {

  List<Palette> findByPaletteName(@Param("paletteName") String paletteName);

  List<Palette> findByColor1(@Param("color1") String color1);

  List<Palette> findByColor2(@Param("color2") String color2);

  List<Palette> findByColor3(@Param("color3") String color3);

  List<Palette> findByColor4(@Param("color4") String color4);

  List<Palette> findByColor5(@Param("color5") String color5);

  Palette findById(long id);

}
