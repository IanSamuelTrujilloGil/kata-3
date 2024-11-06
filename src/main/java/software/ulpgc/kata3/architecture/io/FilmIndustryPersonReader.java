package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.FilmIndustryPerson;

import java.util.List;

public interface FilmIndustryPersonReader {
    public List<FilmIndustryPerson> read();
}
