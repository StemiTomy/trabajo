package series;

import java.util.ArrayList;

public class SerieFACADE {
    private SerieDAO DAO;

    public SerieFACADE() {
        DAO = new SerieDAO();
    }

    public int add(SerieDTO DTO) {
        int success;
        success = DAO.add(DTO);
        return success;
    }

    public ArrayList<SerieDTO> getSeries() {
        ArrayList<SerieDTO> result = new ArrayList<SerieDTO>();
        result = DAO.getSeries();
        return result;
    }
}