package software.ulpgc.kata3.apps.android;

import software.ulpgc.kata3.architecture.model.FilmIndustryPerson;
import software.ulpgc.kata3.architecture.io.ProfessionBarchartLoader;
import software.ulpgc.kata3.architecture.control.ToggleGraphCommand;
import software.ulpgc.kata3.architecture.io.TsvFilmIndustryPersonReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Ian\\Desktop\\copia del drive\\obsidian\\base1\\Universidad\\INGENIERÍA DEL SOFTWARE II\\practica\\practica3\\kata3\\kata3\\src\\main\\resources\\name.basics.tsv");
        List<FilmIndustryPerson> filmIndustryPeople = new TsvFilmIndustryPersonReader(file).read();
        HashMap<String, Integer> professionToPeopleCount = new HashMap<>();
        HashMap<String, Integer> professionCountToPeopleCount = new HashMap<>();
        for(FilmIndustryPerson filmIndustryPerson: filmIndustryPeople){
            for(FilmIndustryPerson.Profession profession: filmIndustryPerson.getPrimaryProfession()){
                professionToPeopleCount.put(String.valueOf(profession), professionToPeopleCount.getOrDefault(String.valueOf(profession)
                        ,0) +1);
            }
            professionCountToPeopleCount.put(String.valueOf(filmIndustryPerson.getPrimaryProfession().length),
                    professionCountToPeopleCount.getOrDefault(String.valueOf(filmIndustryPerson.getPrimaryProfession().length), 0) +1);
        }

        MainFrame mainFrame = new MainFrame();
        ProfessionBarchartLoader loader = new ProfessionBarchartLoader(professionToPeopleCount, professionCountToPeopleCount);
        mainFrame.put("toggle", new ToggleGraphCommand(mainFrame.getDisplay(), loader));
        mainFrame.getDisplay().show(loader.load(0));
        mainFrame.setVisible(true);
    }
}
